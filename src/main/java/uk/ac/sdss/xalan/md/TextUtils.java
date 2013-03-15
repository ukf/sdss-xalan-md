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

/**
 * Text utility extensions for Xalan.
 * 
 * Author: Ian A. Young, ian@iay.org.uk
 */
public class TextUtils {

    /**
     * The argument string is the base-64 encoding of something. Normalise this
     * so that it doesn't have white space in peculiar places, then break it into
     * lines of 64 characters each.
     * 
     * @param s base-64 encoded string
     * @return normalised string with line breaks
     */
    public static String wrapBase64(String s) {
        /* remove all white space */
        s = s.replaceAll("\\s*", "");

        StringBuilder result = new StringBuilder();
        StringBuilder line = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (line.length() == 64) {
                if (result.length() != 0) {
                    result.append('\n');
                }
                result.append(line);
                line.setLength(0);
            }
            line.append(c);
        }
        if (line.length() != 0) {
            if (result.length() != 0) {
                result.append('\n');
            }
            result.append(line);
        }
        return result.toString();
    }

}
