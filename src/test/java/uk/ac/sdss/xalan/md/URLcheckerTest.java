package uk.ac.sdss.xalan.md;

import junit.framework.TestCase;

public class URLcheckerTest extends TestCase {

	public void testSuccess() {
		String OK = "https://example.org:1234/example";
		assertNull(URLchecker.whyInvalid(OK));
		assertFalse(URLchecker.invalidURL(OK));
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

}
