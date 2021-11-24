from lstm import Model1
from data_manager import DataManager

class PredictManager:
    def __init__(self, code, time_size, name=None):
        self.name = name
        dm = DataManager(code)
        (self.x_train, self.t_train), (self.x_today, self.x_max, self.x_min) = dm.getData3(time_size)
        
        self.model = Model1(time_size)
        self.model.compile(optimizer='adam',
              loss='mse')

    def reset(self, time_size):
        self.model = Model1(time_size)
        self.model.compile(optimizer='adam',
              loss='mse')

    def fit(self, epochs=20, batch_size=20):
        print("optimize start")
        self.model.fit(self.x_train, self.t_train, epochs=epochs, batch_size=batch_size)
        print("optimize finish")

    def predict_tomorrow(self):
        x = self.x_today[0,self.x_today.shape[1]-1,0]
        x = int(x * (self.x_max - self.x_min) + self.x_min)
        y = self.model(self.x_today)
        y = int(y[0][0] * (self.x_max - self.x_min) + self.x_min)
        if self.name is None:
            print("{x} -> {y}".format(x=x, y=y))
        else:
            print("{name}: {x} -> {y}".format(name=self.name, x=x, y=y))
        return x, y
    

