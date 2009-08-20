/**
 * Text utility extensions for Xalan.
 * 
 * Author: Ian A. Young, ian@iay.org.uk
 */
package uk.ac.sdss.xalan.md;

public class TextUtils {

	/**
	 * The argument string is the base-64 encoding of something.  Normalise this
	 * so that it doesn't have white space in peculiar places, then break it into
	 * lines of 64 characters each.
	 * 
	 * @param s	base-64 encoded string
	 * @return normalised string with line breaks
	 */
	public static String wrapBase64(String s) {
		/* remove all white space */
		s = s.replaceAll("\\s*", "");
		
		StringBuilder result = new StringBuilder();
		StringBuilder line = new StringBuilder();
		for (char c: s.toCharArray()) {
			if (line.length() == 64) {
				if (result.length() != 0) {
					result.append('\n');
				}
				result.append(line);
				line.setLength(0);
			}
			line.append(c);
		}
		if (line.length() != 0) {
			if (result.length() != 0) {
				result.append('\n');
			}
			result.append(line);
		}
		return result.toString();
	}

}
