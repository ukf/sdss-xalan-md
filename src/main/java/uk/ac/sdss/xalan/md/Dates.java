/*
 * Copyright (C) 2011 University of Edinburgh.
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

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * Date-related extensions for Xalan.
 * 
 * Author: Ian A. Young, ian@iay.org.uk
 */
public class Dates {

    /**
     * UTC time zone.
     */
    private final static DateTimeZone zoneUTC = DateTimeZone.UTC;

    /**
     * Formatter: results in "2009-01-01T12:34:56Z".
     */
    private final static DateTimeFormatter fmt = ISODateTimeFormat.dateTimeNoMillis();

    /**
     * Parses an xsl:dateTime, adds a given number of days to it, and returns the result as a string formatted in
     * standard form with the Z time zone specifier.
     * 
     * @param base Base date formatted as an xsl:dateTime.
     * @param days Number of days to add on.
     * 
     * @return An xsl:dateTime <code>days</code> days later than <code>base</code>.
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
     * Formatter: results in "2009-01-01".
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
