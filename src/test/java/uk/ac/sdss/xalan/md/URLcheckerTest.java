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

public class URLcheckerTest extends TestCase {

	public void testSuccess() {
		String ok = "https://example.org:1234/example";
		assertNull(URLchecker.whyInvalid(ok));
		assertFalse(URLchecker.invalidURL(ok));
	}
	
	/**
	 * Generic test for a bad URL.
	 * 
	 * @param bad	bad URL to test
	 */
	private void badURL(String bad) {
		assertTrue(URLchecker.invalidURL(bad));
		//System.out.println("Bad '" + bad + "' because: " + URLchecker.whyInvalid(bad));
		assertNotNull(URLchecker.whyInvalid(bad));
	}
	
	public void testBadPort() {
		String bad = "https://example.org:port/example";
		assertNotNull(URLchecker.whyInvalid(bad));
		assertTrue(URLchecker.invalidURL(bad));
	}
	
	/**
	 * Test the case where the authority's port field is present but empty.
	 * 
	 * This is valid by the specification, but is regarded as invalid by
	 * libxml2's xs:anyURI checker.
	 */
	public void testEmptyPort() {
		badURL("http://example.org:/example/");
	}
	
	public void testDoubleScheme() {
		badURL("http://http://example.org/example/");
	}
	
	public void testBareDomain() {
		badURL("www.example.org");
	}
	
	public void testEmptyUrl() {
	    badURL("");
	}

	public void testNullUrl() {
	    badURL(null);
	}
	
	public void testEmptyAuthority() {
	    badURL("http:///foo/");
	}
	
	public void testFillInHostName() {
	    badURL("http://*** FILL IN ***/");
	}
}
