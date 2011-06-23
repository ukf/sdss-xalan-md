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

import junit.framework.TestCase;

public class DatesTest extends TestCase {

	public final void testDateAdd() {
		// start date is not in DST, using Z time zone
		assertEquals("2009-01-01T01:23:45Z", Dates.dateAdd("2009-01-01T01:23:45Z", 0));
		assertEquals("2009-01-29T01:23:45Z", Dates.dateAdd("2009-01-01T01:23:45Z", 28));

		// test for normalisation of base dates with an offset
		assertEquals("2009-01-01T01:23:45Z", Dates.dateAdd("2009-01-01T02:23:45+0100", 0));
		assertEquals("2009-01-29T01:23:45Z", Dates.dateAdd("2009-01-01T02:23:45+0100", 28));
		assertEquals("2009-01-01T01:23:45Z", Dates.dateAdd("2009-01-01T00:23:45-0100", 0));
		assertEquals("2009-01-29T01:23:45Z", Dates.dateAdd("2009-01-01T00:23:45-0100", 28));

		// base date not in DST, result in DST 
		assertEquals("2009-03-27T17:01:28Z", Dates.dateAdd("2009-03-27T17:01:28Z", 0));
		assertEquals("2009-04-24T17:01:28Z", Dates.dateAdd("2009-03-27T17:01:28Z", 28));
		
		// both dates in DST
		assertEquals("2009-03-30T16:40:08Z", Dates.dateAdd("2009-03-30T17:40:08+01:00", 0));
		assertEquals("2009-04-27T16:40:08Z", Dates.dateAdd("2009-03-30T17:40:08+01:00", 28));
	}

}
