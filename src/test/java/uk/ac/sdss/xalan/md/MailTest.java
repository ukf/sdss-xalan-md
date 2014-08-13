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

public class MailTest extends TestCase {

    public void testDodgyAddress() {
        assertFalse(Mail.dodgyAddress("mailto:ian@iay.org.uk"));
        assertFalse(Mail.dodgyAddress("mailto:First.O'Last@example.com"));
        assertFalse(Mail.dodgyAddress("mailto:address+sub@example.org"));

        assertTrue(Mail.dodgyAddress(""));							// empty element
        assertTrue(Mail.dodgyAddress("ian@iay.org.uk"));			// no "mailto:"
        assertTrue(Mail.dodgyAddress(" mailto:ian@iay.org.uk"));	// leading space
        assertTrue(Mail.dodgyAddress("mailto:ian@iay.org.uk "));	// trailing space
        assertTrue(Mail.dodgyAddress("mailto:ian.iay.org.uk"));		// no '@'
    }

}
