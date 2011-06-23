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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Mail-related extensions for Xalan.
 * 
 * Author: Ian A. Young, ian@iay.org.uk
 */
public class Mail {

	/**
	 * Pattern for valid e-mail addresses.  Note that the UK federation
	 * metadata convention includes an explicit "mailto:" scheme.
	 */
	private static Pattern eMailPattern = Pattern.compile(
        "^mailto:[0-9a-z\\.\\-_&]+\\@([0-9a-z\\-_]+\\.)+[a-z]+$",
        Pattern.CASE_INSENSITIVE
    );

    public static boolean dodgyAddress(String eMail) {
        Matcher m = eMailPattern.matcher(eMail);
        return !m.matches();
    }

}
