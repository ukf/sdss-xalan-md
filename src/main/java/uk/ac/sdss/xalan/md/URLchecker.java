/**
 * URL-related extensions for Xalan.
 * 
 * Author: Ian A. Young, ian@iay.org.uk
 */
package uk.ac.sdss.xalan.md;

import java.net.MalformedURLException;
import java.net.URL;

public class URLchecker {

	public static String whyInvalid(String u) {
		try {
			new URL(u);
    		return null;
		} catch (MalformedURLException e) {
			return "Malformed URL: " + e.getMessage();
		}		
	}
	
    public static boolean invalidURL(String u) {
    	String err = whyInvalid(u);
    	return (err != null);
    }

}
