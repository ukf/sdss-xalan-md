/**
 * Mail-related extensions for Xalan.
 * 
 * Author: Ian A. Young, ian@iay.org.uk
 */
package uk.ac.sdss.xalan.md;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {

	/**
	 * Pattern for valid e-mail addresses.  Note that the UK federation
	 * metadata convention includes an explicit "mailto:" scheme.
	 */
	private static Pattern eMailPattern = Pattern.compile(
        "^mailto:[0-9a-z\\.\\-_&]+\\@([0-9a-z\\-_]+\\.)+[a-z]+$",
        Pattern.CASE_INSENSITIVE
    );

    public static boolean dodgyAddress(String eMail) {
        Matcher m = eMailPattern.matcher(eMail);
        return !m.matches();
    }

}
