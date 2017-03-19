package com.flipkart.data;



import java.lang.Exception;

public class AffiliateAPIException extends Exception {
    AffiliateAPIException(String message) {
        super(message);
    }
}