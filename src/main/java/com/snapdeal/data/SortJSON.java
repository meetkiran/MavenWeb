package com.snapdeal.data;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SortJSON implements Comparator<Integer> {

	ArrayList< MobileBean> allData;

	public SortJSON() {
		System.setProperty("https.proxyHost", "proxy-in.glb.my-it-solutions.net");

		System.setProperty("https.proxyPort", "84");
	}

	

	public static void main(String[] args) throws Exception {
		new SortJSON().sendData();
	}

	public ArrayList< MobileBean> sendData() throws Exception {
		System.setProperty("https.proxyHost", "proxy-in.glb.my-it-solutions.net");

		System.setProperty("https.proxyPort", "84");

		ArrayList<JSONObject> list = null;

		///////// -------->Always check first
		///////// ------>http://affiliate-feeds.snapdeal.com/feed/113434.json<--------------and
		///////// s in https
		String url = "https://affiliate-feeds.snapdeal.com/feed/api/category/v1:12:649835220389?expiresAt=1484818200110&signature=wxzjmmvpkxljuqhmmeem";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("Snapdeal-Affiliate-Id", "113434");
		con.setRequestProperty("Snapdeal-Token-Id", "11b1c96a5eef56e65fbe6e37a3def1");

		int responseCode = con.getResponseCode();
		// System.out.println("\nSending 'GET' request to URL : " + url);
		// System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;

		inputLine = in.readLine();
		// System.out.println(inputLine);
		JSONParser parser = new JSONParser();
		allData = new ArrayList<MobileBean>();
		JSONObject jsonObject = null;
		JSONArray array = null;
		try {

			Object obj1 = parser.parse(inputLine);

			jsonObject = (JSONObject) obj1;
			array = (JSONArray) jsonObject.get("products");
			/*
			 * list = new ArrayList<JSONObject>();
			 * 
			 * for (int i = 0; i < array.size(); i++) { list.add((JSONObject)
			 * array.get(i)); //System.out.println(list); }
			 */

			/*
			 * for (JSONObject objlist : list) {
			 * System.out.println(objlist.get("offerPrice"));
			 * System.out.println(objlist.get("title")); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(inputLine);
		int count = 0;
		// JSONArray msg = (JSONArray) jsonObject.get(0);
		for (Object o : array) {
			JSONObject mobile = (JSONObject) o;
			MobileBean mb = new MobileBean();
			mb.setImageLink(mobile.get("imageLink").toString());
			mb.setAvailability(mobile.get("availability").toString());
			mb.setDescription(mobile.get("description").toString());
			mb.setLink(mobile.get("link").toString());
			mb.setMrp(mobile.get("mrp").toString());
			mb.setTitle(mobile.get("title").toString());
			allData.add(mb);

		}
		 Collections.sort(allData, new MyJSONComparator());

		for(MobileBean b:allData){
			
			System.out.println(b.getMrp());
		}

		return allData;
	}

	// Note: this comparator imposes orderings that are inconsistent with
	// equals.
	public int compare(Integer a, Integer b) {
		return ((MobileBean) allData.get(a)).compareTo(allData.get(b));
	}

}

class MyJSONComparator implements Comparator<MobileBean> {

	public int compare(MobileBean o1, MobileBean o2) {

		String v1 = (String) o2.getMrp();// (String) ((JSONObject)
										// o1.get("0")).get("offerPrice");
		String v3 = (String) o1.getMrp();// (String) ((JSONObject)
										// o2.get("1")).get("offerPrice");
		return v1.compareTo(v3);
	}

}

class ValueComparator implements Comparator<Integer> {

	Map<Integer, MobileBean> base;

	public ValueComparator(Map<Integer, MobileBean> base) {
		this.base = base;
	}

	// Note: this comparator imposes orderings that are inconsistent with
	// equals.
	public int compare(Integer a, Integer b) {
		return ((MobileBean) base.get(a)).compareTo(base.get(b));
	}

}