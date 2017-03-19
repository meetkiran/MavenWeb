package com.snapdeal.data;

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

public class HttpURLConnectionSnapdeal {
	public HttpURLConnectionSnapdeal(){
		
		
System.setProperty("https.proxyHost", "proxy-in.glb.my-it-solutions.net");
		
		System.setProperty("https.proxyPort", "84");
		
			
		
	
	}

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HttpURLConnectionSnapdeal http = new HttpURLConnectionSnapdeal();

		//System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

	}

	// HTTP GET request
	public  Map<Integer,ProductInfoSnapdeal> sendGet() throws Exception {

		String url = "https://affiliate-feeds.snapdeal.com/feed/api/dod/offer";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("Snapdeal-Affiliate-Id", "113434");
		con.setRequestProperty("Snapdeal-Token-Id","11b1c96a5eef56e65fbe6e37a3def1");

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
			JSONArray msg = (JSONArray) jsonObject.get("products");
			Map<Integer,ProductInfoSnapdeal>allData=new HashMap<Integer,ProductInfoSnapdeal>();
			int key=0;
			System.out.println(msg);
			for (Object o : msg) {
				ProductInfoSnapdeal prodinfo=new ProductInfoSnapdeal();
	            JSONObject person = (JSONObject) o;
	            
	            prodinfo.setTitle(person.get("title").toString());
	            prodinfo.setDescription(person.get("description").toString());
	            prodinfo.setInStock(person.get("availability").toString());
	            prodinfo.setProductUrl(person.get("link").toString());
	            prodinfo.setOfferPrice(person.get("offerPrice").toString());
	            prodinfo.setMrp(person.get("mrp").toString());
			
			
	            prodinfo.setImgurl(person.get("imageLink").toString());
			allData.put(key++, prodinfo);
			
			}
			System.out.println(allData);
return allData;

	}finally{}
}
	
void getData() throws Exception{
	
	HttpURLConnectionSnapdeal http = new HttpURLConnectionSnapdeal();

	//System.out.println("Testing 1 - Send Http GET request");
	http.sendGet();

}
}