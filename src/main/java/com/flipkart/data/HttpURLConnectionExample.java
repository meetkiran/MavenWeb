package com.flipkart.data;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {
	public HttpURLConnectionExample(){
		
		
System.setProperty("https.proxyHost", "proxy-in.glb.my-it-solutions.net");
		
		System.setProperty("https.proxyPort", "84");
		
			
		
	
	}

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HttpURLConnectionExample http = new HttpURLConnectionExample();

		//System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

	}

	// HTTP GET request
	public  Map<Integer,ProductInfo> sendGet() throws Exception {

		String url = "https://affiliate-api.flipkart.net/affiliate/offers/v1/dotd/json";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("Fk-Affiliate-Id", "kiranbira1");
		con.setRequestProperty("Fk-Affiliate-Token","a3e735a6979b4094a2cf3b6bb3f6505e");

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		inputLine = in.readLine();
		//System.out.println(inputLine);
		JSONParser parser = new JSONParser();

		try {

			Object obj1 = parser.parse(inputLine);

			JSONObject jsonObject = (JSONObject) obj1;

			// loop array
			JSONArray msg = (JSONArray) jsonObject.get("dotdList");
			Map<Integer,ProductInfo>allData=new HashMap<Integer,ProductInfo>();
			int key=0;
			for (Object o : msg) {
				ProductInfo pi=new ProductInfo();
	            JSONObject person = (JSONObject) o;
	            
			pi.setTitle(person.get("title").toString());
			pi.setDescription(person.get("description").toString());
			pi.setInStock(person.get("availability").toString());
			pi.setProductUrl(person.get("url").toString());
			JSONArray imageUrls = (JSONArray) person.get("imageUrls");
			JSONObject low = (JSONObject) imageUrls.get(1);
			//System.out.println(low);
			if(low!=null)
			if(low.get("url")!=null)
			pi.setImgurl(low.get("url").toString());
			allData.put(++key, pi);
			
			}
return allData;

	}finally{}
}
	
void getData() throws Exception{
	
	HttpURLConnectionExample http = new HttpURLConnectionExample();

	//System.out.println("Testing 1 - Send Http GET request");
	http.sendGet();

}
}