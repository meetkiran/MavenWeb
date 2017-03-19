package com.flipkart.data;


import java.lang.*;
import java.util.*;

import java.io.*;

public class APIFeeds {

	public DataParser parser;

	public APIFeeds(String affiliateId, String affiliateToken, String downloadType) {

		System.setProperty("https.proxyHost", "proxy-in.glb.my-it-solutions.net");

		System.setProperty("https.proxyPort", "84");
		if (downloadType.equalsIgnoreCase("XML")) {
			// parser = new XMLDataParser(affiliateId, affiliateToken);
			//System.out.println("Usage: APIFeeds <Affiliate ID> <Affiliate Token> <JSON>");

		} else {
			parser = new JSONDataParser(affiliateId, affiliateToken);
		}
	}

	public DataParser getParser() {
		return parser;
	}

	public static void main(String args[]) {
		System.setProperty("https.proxyHost", "proxy-in.glb.my-it-solutions.net");

		System.setProperty("https.proxyPort", "84");
		/**
		 * Usage: APIFeeds <AffiliateID> <AffiliateToken> <XML/JSON>
		 */
		/*
		 * if(args.length < 3) { System.out.println(); System.out.println();
		 * System.out.
		 * println("Usage: APIFeeds <Affiliate ID> <Affiliate Token> <JSON>");
		 * System.out.println(); System.out.println(); return; }
		 */

		try {
			/*
			 * if (args[2].equalsIgnoreCase("XML")) { // parser = new
			 * XMLDataParser(affiliateId, affiliateToken); System.out.
			 * println("Usage: APIFeeds <Affiliate ID> <Affiliate Token> <JSON>"
			 * ); return; }
			 */
			APIFeeds feeds = new APIFeeds("kiranbira1", "a3e735a6979b4094a2cf3b6bb3f6505e", "");

			// Query the API service to get the list of categories and the
			// corresponding URLs and store it
			// locally in productDirectory Map.
			if (feeds.getParser().initializeProductDirectory()) {

				// System.out.println("Choose one of the categories:");
				// Get the list of categories from the locally stored
				// productDirectory Map.
				Iterator<String> category_iterator = feeds.getParser().getProductDirectory().keySet().iterator();
				// while(category_iterator.hasNext()) {
				// System.out.println(category_iterator.next());
				// }
				// System.out.print("Enter a category (or type 'q' to quit): ");
				// Scanner s = new Scanner(System.in);
				String category = "mobiles";

				int count = 0;
				// Get a list of products for the given category.
				Iterator<ProductInfo> products_iterator = feeds.getParser().getProductList(category).listIterator();
				while (products_iterator.hasNext()) {
					ProductInfo product = products_iterator.next();
					if (product.isInStock()!=null) {
						// Some of the fields are printed.
						//System.out.println("Title: " + product.getTitle());
						//System.out.println("URL: " + product.getProductUrl());
					//	System.out.println("Price: " + product.getMrp() + "\n\n");
						count++;
					}
				}

				//System.out.println("Found " + count + " products in " + category + " category.\n\n");
			} else {
				System.out.println("Unable to contact the Flipkart Affiliate API service.");
			}
		} catch (AffiliateAPIException e) {
			System.out.println("API Exception raised: " + e.getMessage());
		}
	}
}
