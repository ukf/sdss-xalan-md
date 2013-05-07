/*
 * Copyright (C) 2013 University of Edinburgh.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.sdss.xalan.md;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL-related extensions for Xalan.
 * 
 * Author: Ian A. Young, ian@iay.org.uk
 */
public final class URLchecker {

    /** Constructor. */
    private URLchecker() {}
    
    /**
     * Indicates why the provided string is not a valid URL.
     * 
     * @param u supposed URL to validate
     * @return reason the URL is not valid, or <code>null</code> if it is valid
     */
    public static String whyInvalid(String u) {
        try {
            // Delegate most checking to the Java URL class constructor.
            URL url = new URL(u);

            // The Java URL constructor incorrectly accepts un-encoded spaces.
            if (u.indexOf(' ') >= 0) {
                return "URL value must not contain an unencoded space character";
            }
            
            String host = url.getHost();
            if (host.length() == 0) {
                return "host name not present";
            }

            String authority = url.getAuthority();
            if (authority != null) {
                if (authority.charAt(authority.length() - 1) == ':') {
                    return "libxml2: port present but empty";
                }
            }
            return null;
        } catch (MalformedURLException e) {
            return "Malformed URL: " + e.getMessage();
        }
    }

    /**
     * Indicates whether the provided string is not a valid URL.
     * 
     * @param u supposed URL to validate
     * @return <code>true</code> if the string is not a valid URL.
     */
    public static boolean invalidURL(String u) {
        String err = whyInvalid(u);
        return err != null;
    }

}
