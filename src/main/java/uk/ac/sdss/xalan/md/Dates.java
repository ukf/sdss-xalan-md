/**
 * Date-related extensions for Xalan.
 * 
 * Author: Ian A. Young, ian@iay.org.uk
 */
package uk.ac.sdss.xalan.md;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class Dates {
	
	/**
	 * UTC time zone.
	 */
	private final static DateTimeZone zoneUTC = DateTimeZone.UTC;
	
	/**
	 * Formatter: results in 2009-01-01T12:34:56Z
	 */
	private final static DateTimeFormatter fmt = ISODateTimeFormat.dateTimeNoMillis();

	/**
	 * Parses an xsl:dateTime, adds a given number of days to it, and returns the
	 * result as a string formatted in standard form with the Z time zone specifier.
	 * 
	 * @param base	Base date formatted as an xsl:dateTime.
	 * @param days	Number of days to add on.
	 * 
	 * @return	An xsl:dateTime <code>days</code> days later than <code>base</code>.
	 */
	public static String dateAdd(String base, int days) {
		try {
			DateTime dt = new DateTime(base, zoneUTC);
			DateTime future = dt.plusDays(days);
			return future.toString(fmt);
		} catch (NumberFormatException e) {
			return "(could not parse date)";
		}
	}
	
	/**
	 * Formatter: results in 2009-01-01
	 */
	private final static DateTimeFormatter dateFormat = ISODateTimeFormat.date();
	
	/**
	 * Produces the current date as a string in a standard format.
	 * 
	 * @return the current date
	 */
	public static String date() {
		DateTime dt = new DateTime(zoneUTC);
		return dt.toString(dateFormat);
	}

}
