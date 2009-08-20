package uk.ac.sdss.xalan.md;

import junit.framework.TestCase;

public class MailTest extends TestCase {

    public void testDodgyAddress() {
        assertFalse(Mail.dodgyAddress("mailto:ian@iay.org.uk"));

        assertTrue(Mail.dodgyAddress(""));							// empty element
        assertTrue(Mail.dodgyAddress("ian@iay.org.uk"));			// no "mailto:"
        assertTrue(Mail.dodgyAddress(" mailto:ian@iay.org.uk"));	// leading space
        assertTrue(Mail.dodgyAddress("mailto:ian@iay.org.uk "));	// trailing space
        assertTrue(Mail.dodgyAddress("mailto:ian.iay.org.uk"));		// no '@'
    }

}
