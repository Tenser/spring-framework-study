package com.jiyoung.coin;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UpbitApi {
	
	String accessKey;
	String secretKey;
	String serverUrl;
	String market;
	JSONParser jsonParse;
	
	public UpbitApi(String accessKey, String secretKey, String serverUrl, String market) {
		
		//this.serverUrl = System.getenv(serverUrl);
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.serverUrl = serverUrl;
		this.market = market;
		this.jsonParse = new JSONParser();
		
		/*
		Algorithm algorithm = Algorithm.HMAC256(secretKey);
        String jwtToken = JWT.create()
                .withClaim("access_key", accessKey)
                .withClaim("nonce", UUID.randomUUID().toString())
                .sign(algorithm);

        this.authenticationToken = "Bearer " + jwtToken;
        */
        
	}
	
	public int accountSelect() throws org.json.simple.parser.ParseException {
		
		Algorithm algorithm = Algorithm.HMAC256(this.secretKey);
        String jwtToken = JWT.create()
                .withClaim("access_key", this.accessKey)
                .withClaim("nonce", UUID.randomUUID().toString())
                .sign(algorithm);

        String authenticationToken = "Bearer " + jwtToken;
		
		try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(this.serverUrl + "/v1/accounts");
            request.setHeader("Content-Type", "application/json");
            request.addHeader("Authorization", authenticationToken);
            //System.out.println(this.serverUrl + "/v1/accounts");
            //System.out.println(this.authenticationToken);

            HttpResponse response = client.execute(request);
            //System.out.println(123);
            HttpEntity entity = response.getEntity();
            String jsonData = EntityUtils.toString(entity, "UTF-8");
            System.out.println(jsonData);
	        JSONArray jsonArray = (JSONArray) jsonParse.parse(jsonData);
	        JSONObject jsonObj = (JSONObject) jsonArray.get(0);
	        int balance = (int) Math.round(Double.parseDouble((String) jsonObj.get("balance")));
	        return balance;
            
            //System.out.println(123);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return 0;
	}
	
	public HashMap<String, String> getOrdersChance() throws NoSuchAlgorithmException, UnsupportedEncodingException, org.json.simple.parser.ParseException {

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("market", "KRW-" + market);

        ArrayList<String> queryElements = new ArrayList<String>();
        for(Map.Entry<String, String> entity : params.entrySet()) {
            queryElements.add(entity.getKey() + "=" + entity.getValue());
        }

        String queryString = String.join("&", queryElements.toArray(new String[0]));

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(queryString.getBytes("UTF-8"));

        String queryHash = String.format("%0128x", new BigInteger(1, md.digest()));

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        String jwtToken = JWT.create()
                .withClaim("access_key", accessKey)
                .withClaim("nonce", UUID.randomUUID().toString())
                .withClaim("query_hash", queryHash)
                .withClaim("query_hash_alg", "SHA512")
                .sign(algorithm);

        String authenticationToken = "Bearer " + jwtToken;

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(serverUrl + "/v1/orders/chance?" + queryString);
            request.setHeader("Content-Type", "application/json");
            request.addHeader("Authorization", authenticationToken);

            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            
            HashMap<String, String> result = new HashMap<String, String>();
            String jsonData = EntityUtils.toString(entity, "UTF-8");
            System.out.println(jsonData);
            JSONObject jsonObj = (JSONObject) jsonParse.parse(jsonData);
            JSONObject bidObj = (JSONObject) jsonObj.get("bid_account");
            result.put("bid_balance", (String) bidObj.get("balance"));
            JSONObject askObj = (JSONObject) jsonObj.get("ask_account");
            result.put("ask_balance", (String) askObj.get("balance"));
            
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
	}
	
	public String order(String side, String volume, String price, String orderType) throws NoSuchAlgorithmException, UnsupportedEncodingException, org.json.simple.parser.ParseException{
		
		HashMap<String, String> params = new HashMap<String, String>();
        params.put("market", "KRW-" + market);
        params.put("side", side);
        params.put("ord_type", orderType);
        if(orderType.equals("limit")) {
        	params.put("volume", volume);
        	params.put("price", price);
        }else if(orderType.equals("price")) {
        	params.put("price", price);
        }else if(orderType.equals("market")) {
        	params.put("volume", volume);
        }

        ArrayList<String> queryElements = new ArrayList<String>();
        for(Map.Entry<String, String> entity : params.entrySet()) {
            queryElements.add(entity.getKey() + "=" + entity.getValue());
        }

        String queryString = String.join("&", queryElements.toArray(new String[0]));
        //System.out.println(1);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(queryString.getBytes("UTF-8"));

        String queryHash = String.format("%0128x", new BigInteger(1, md.digest()));
        //System.out.println(1);

        Algorithm algorithm = Algorithm.HMAC256(this.secretKey);
        //System.out.println(1);
        String jwtToken = JWT.create()
                .withClaim("access_key", this.accessKey)
                .withClaim("nonce", UUID.randomUUID().toString())
                .withClaim("query_hash", queryHash)
                .withClaim("query_hash_alg", "SHA512")
                .sign(algorithm);

        String authenticationToken = "Bearer " + jwtToken;

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(this.serverUrl + "/v1/orders");
            request.setHeader("Content-Type", "application/json");
            request.addHeader("Authorization", authenticationToken);
            request.setEntity(new StringEntity(new Gson().toJson(params)));

            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            
            String jsonData = EntityUtils.toString(entity, "UTF-8");
            System.out.println(jsonData);
            JSONObject jsonObj = (JSONObject) jsonParse.parse(jsonData);
            String uuid = (String) jsonObj.get("uuid");
	        //String avgPrice = (String) jsonObj.get("avg_price");
	        //Double dAvgPrice = Double.parseDouble(avgPrice);
	        
	        return uuid;

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
	}
	
	
	public String coinSelect() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		HashMap<String, String> params = new HashMap<String, String>();
        params.put("market", "KRW-" + market);

        ArrayList<String> queryElements = new ArrayList<String>();
        for(Map.Entry<String, String> entity : params.entrySet()) {
            queryElements.add(entity.getKey() + "=" + entity.getValue());
        }

        String queryString = String.join("&", queryElements.toArray(new String[0]));

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(queryString.getBytes("UTF-8"));

        String queryHash = String.format("%0128x", new BigInteger(1, md.digest()));

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        String jwtToken = JWT.create()
                .withClaim("access_key", accessKey)
                .withClaim("nonce", UUID.randomUUID().toString())
                .withClaim("query_hash", queryHash)
                .withClaim("query_hash_alg", "SHA512")
                .sign(algorithm);

        String authenticationToken = "Bearer " + jwtToken;

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(serverUrl + "/v1/orders/chance?" + queryString);
            request.setHeader("Content-Type", "application/json");
            request.addHeader("Authorization", authenticationToken);

            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
	}
	
	public Double candleSelect() throws org.json.simple.parser.ParseException {

		HashMap<String, String> params = new HashMap<String, String>();
        params.put("market", "KRW-" + market);
        params.put("count", "1");

        ArrayList<String> queryElements = new ArrayList<String>();
        for(Map.Entry<String, String> entity : params.entrySet()) {
            queryElements.add(entity.getKey() + "=" + entity.getValue());
        }

        String queryString = String.join("&", queryElements.toArray(new String[0]));
		
		try {
			HttpClient client = HttpClientBuilder.create().build();
	        HttpGet request = new HttpGet(serverUrl + "/v1/candles/days?" + queryString);

	        HttpResponse response = client.execute(request);
	        HttpEntity entity = response.getEntity();
	        String jsonData = EntityUtils.toString(entity, "UTF-8");
	        //System.out.println(jsonData);
	        JSONArray jsonArray = (JSONArray) jsonParse.parse(jsonData);
	        JSONObject jsonObj = (JSONObject) jsonArray.get(0);
	        Double tradePrice = (Double) jsonObj.get("trade_price");
	        return tradePrice;
		} catch (IOException e) {
            e.printStackTrace();
        }
        
        return 0.0;
	}
	
	public HashMap<String, Double> orderbookSelect(int bookSize) throws org.json.simple.parser.ParseException {
		HashMap<String, String> params = new HashMap<String, String>();
        params.put("markets", "KRW-" + market);

        ArrayList<String> queryElements = new ArrayList<String>();
        for(Map.Entry<String, String> entity : params.entrySet()) {
            queryElements.add(entity.getKey() + "=" + entity.getValue());
        }

        String queryString = String.join("&", queryElements.toArray(new String[0]));
		
		try {
			HttpClient client = HttpClientBuilder.create().build();
	        HttpGet request = new HttpGet(serverUrl + "/v1/orderbook?" + queryString);

	        HttpResponse response = client.execute(request);
	        HttpEntity entity = response.getEntity();
	        String jsonData = EntityUtils.toString(entity, "UTF-8");
	        //System.out.println(jsonData);
	        JSONArray jsonArray = (JSONArray) jsonParse.parse(jsonData);
	        JSONObject jsonObj = (JSONObject) jsonArray.get(0);
	        JSONArray orderbook_units = (JSONArray) jsonObj.get("orderbook_units");
	        Double askSum = 0.0;
	        Double bidSum = 0.0;
	        for(int i=0;i<bookSize;i++) {
	        	JSONObject unit = (JSONObject) orderbook_units.get(i);
	        	askSum += (Double) unit.get("ask_size");
	        	bidSum += (Double) unit.get("bid_size");
	        }
	        HashMap<String, Double> sums = new HashMap<String, Double>();
	        sums.put("ask_sum", askSum);
	        sums.put("bid_sum", bidSum);
	        //Double tradePrice = (Double) jsonObj.get("trade_price");
	        return sums;
		} catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
	}
	
	public ArrayList<Double> candleSelect2(String minute) throws org.json.simple.parser.ParseException {

		HashMap<String, String> params = new HashMap<String, String>();
        params.put("market", "KRW-" + market);
        params.put("count", "1");

        ArrayList<String> queryElements = new ArrayList<String>();
        for(Map.Entry<String, String> entity : params.entrySet()) {
            queryElements.add(entity.getKey() + "=" + entity.getValue());
        }

        String queryString = String.join("&", queryElements.toArray(new String[0]));
		
		try {
			HttpClient client = HttpClientBuilder.create().build();
	        HttpGet request = new HttpGet(serverUrl + "/v1/candles/minutes/" + minute + "?" + queryString);

	        HttpResponse response = client.execute(request);
	        HttpEntity entity = response.getEntity();
	        String jsonData = EntityUtils.toString(entity, "UTF-8");
	        //System.out.println(jsonData);
	        JSONArray jsonArray = (JSONArray) jsonParse.parse(jsonData);
	        JSONObject jsonObj = (JSONObject) jsonArray.get(0);
	        Double tradePrice = (Double) jsonObj.get("trade_price");
	        Double lowPrice = (Double) jsonObj.get("low_price");
	        Double openingPrice = (Double) jsonObj.get("opening_price");
	        String datetime = (String) jsonObj.get("candle_date_time_kst");
	        Double minute2 = Double.parseDouble(datetime.split(":")[1]);
	        
	        Double isNoTail = 0.0;
	        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	        Date time = new Date();
	        String time1 = format1.format(time);
	        Double time2 = Double.parseDouble(time1.split(":")[1]);
	        System.out.println(time2 - minute2);
	        System.out.println(Double.parseDouble("00"));
	        
	        if(time2 - minute2 >= Double.parseDouble(minute) * (1.0/3.0) && tradePrice < openingPrice && Double.compare(tradePrice, lowPrice) == 0){
	        	isNoTail = 1.0;
	        }
	        
	        ArrayList<Double> list = new ArrayList<Double>();
	        list.add(isNoTail);
	        list.add(tradePrice);
	        
	        return list;
		} catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
	}
}
