/**
 * Copyright (c) 2005-2013, Thomas Abeel
 * 
 * This file is part of the Abeel Java Toolkit (AJT).
 * the Abeel Java Toolkit (AJT) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * The Abeel Java Toolkit (AJT) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Abeel Java Toolkit (AJT).  If not, see http://www.gnu.org/licenses/.
 */
 */
package be.abeel.util;

import java.util.HashSet;
import java.util.Set;

/**
 * Implements additional operations on sets.
 * 
 * @author Thomas Abeel
 * 
 */
public class SetTools {
    /**
     * Returns the union of the two sets provided as arguments.
     * 
     * @param a
     *            the first set
     * @param b
     *            the second set
     * @return union of a and b
     */
    public static Set<?> union(Set<?> a, Set<?> b) {
        Set<Object> out = new HashSet<Object>();
        out.addAll(a);
        out.addAll(b);
        return out;

    }

    /**
     * Returns the intersection of the two sets provided as arguments.
     * 
     * @param a
     *            the first set
     * @param b
     *            the second set
     * @return intersection of a and b
     */
    public static Set<?> intersection(Set<?> a, Set<?> b) {
        Set<Object> out = new HashSet<Object>();
        out.addAll(a);
        out.retainAll(b);
        return out;
    }
}
