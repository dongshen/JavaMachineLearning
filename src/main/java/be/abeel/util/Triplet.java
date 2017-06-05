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
 *
 */
package be.abeel.util;

/**
 * Represents a pair or couple of objects.
 * 
 * @author Thomas Abeel
 * 
 * @param <S>
 *            type of the first element
 * @param <T>
 *            type of the second element
 */
public class Triplet<S, T, U> {

    private S x;

    private T y;

    private U z;

    private int hashCode;

    public Triplet(S x, T y, U z) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.hashCode = (2 << x.hashCode()) + (1 << y.hashCode()) + z.hashCode();
    }

    public S x() {
        return x;

    }

    public T y() {
        return y;
    }

    public U z() {
        return z;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        Triplet p = (Triplet) o;
        return p.x.equals(this.x) && p.y.equals(this.y) && p.z.equals(this.z);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        return "[" + x.toString() + ";" + y.toString()+ ";" + z.toString() + "]";
    }
}