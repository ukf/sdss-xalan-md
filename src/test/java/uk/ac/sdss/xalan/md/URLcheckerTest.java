package uk.ac.sdss.xalan.md;

import junit.framework.TestCase;

public class URLcheckerTest extends TestCase {

	public void testSuccess() {
		String OK = "https://example.org:1234/example";
		assertNull(URLchecker.whyInvalid(OK));
		assertFalse(URLchecker.invalidURL(OK));
	}
	
	public void testBadPort() {
		String bad = "https://example.org:port/example";
		assertNotNull(URLchecker.whyInvalid(bad));
		assertTrue(URLchecker.invalidURL(bad));
	}

}
