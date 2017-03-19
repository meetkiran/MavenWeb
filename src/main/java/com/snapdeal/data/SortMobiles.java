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

public class SortMobiles implements Comparable{

	
	

		Map<Integer, MobileBean> allData;

		public SortMobiles() {
			System.setProperty("https.proxyHost", "proxy-in.glb.my-it-solutions.net");

			System.setProperty("https.proxyPort", "84");
		}

	/*	SortMobiles(Map<Integer, MobileBean> allData) {
			this.allData = allData;
		}*/

		public static void main(String[] args) throws Exception {
			new SortMobiles().sendData();
		}
		public static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
		    SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
		            new Comparator<Map.Entry<K, V>>() {
		                public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
		                    return e1.getValue().compareTo(e2.getValue());
		                }
		            });
		    sortedEntries.addAll(map.entrySet());
		    return sortedEntries;
		}
		public Map<Integer, MobileBean> sendData() throws Exception {
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
			allData = new HashMap<Integer, MobileBean>();
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
				allData.put(count++, mb);

			}
			// Collections.sort(allData, new MyJSONComparator());

			System.out.println(allData.values());

			return allData;
		}

		

		public int compareTo(Object o) {


			SortMobiles s=(SortMobiles)o;
			
			return 0;
		}

	}



