/*
 * Copyright (C) 2013 University of Edinburgh.
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Mail-related extensions for Xalan.
 * 
 * Author: Ian A. Young, ian@iay.org.uk
 */
public final class Mail {

    /**
     * Pattern for valid e-mail addresses.
     * 
     * This is a simplified version of the address forms permitted by RFC2822.
     * 
     * addr-spec      = local-part "@" domain
     * local-part     = dot-atom
     * dot-atom       = dot-atom-text
     * dot-atom-text  = 1*atext *("." 1*atext)
     * atext          = ALPHA / DIGIT /
     *                  "&" / "'" /
     *                  "+" /
     *                  "-" /
     *                  "_"
     *                  
     * Quite a few legal options are currently missing here. The full RFC 2822
     * grammar for atext is:
     * 
     * atext           = ALPHA / DIGIT / ; Any character except controls,
     *                   "!" / "#" /     ;  SP, and specials.
     *                   "$" / "%" /     ;  Used for atoms
     *                   "&" / "'" /
     *                   "*" / "+" /
     *                   "-" / "/" /
     *                   "=" / "?" /
     *                   "^" / "_" /
     *                   "`" / "{" /
     *                   "|" / "}" /
     *                   "~"
     * 
     * Note that the UK federation metadata convention includes an
     * explicit "mailto:" scheme.
     */
    private static Pattern eMailPattern = Pattern.compile(
        "^mailto:[a-z0-9&'+\\-_]+(\\.[a-z0-9&+'\\-_]+)*\\@([0-9a-z\\-_]+\\.)+[a-z]+$",
        Pattern.CASE_INSENSITIVE
    );

    /** Constructor. */
    private Mail() {}
    
    /**
     * Indicates whether an e-mail address looks dodgy, i.e., has the wrong pattern.
     * 
     * @param eMail e-mail address to check
     * @return <code>true</code> if the e-mail address does not match the pattern
     */
    public static boolean dodgyAddress(String eMail) {
        Matcher m = eMailPattern.matcher(eMail);
        return !m.matches();
    }

}
