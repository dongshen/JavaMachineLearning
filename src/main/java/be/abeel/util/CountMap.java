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
 * An extension of a TreeMap<A,Integer> that is designed to be used as a
 * frequency table for any object of type A. While this implementation allows
 * you to count any type of object, it is more restricted in terms of post
 * modifications than the <code>FrequencyMap</code>.
 * 
 * @see FrequencyMap
 * 
 * @author Thomas Abeel
 */
public class CountMap<A> extends DefaultTreeMap<A, Integer> {

	private static final long serialVersionUID = -3368572739262620314L;

	/**
	 * Creates a CountMap with the provided number of pseudo counts.
	 * 
	 * @param pseudoCounts
	 */
	public CountMap(int pseudoCounts) {
		super(pseudoCounts);
	}

	public int totalCount() {
		int totalCount = 0;
		for (A k : this.keySet())
			totalCount += this.get(k);
		return totalCount;
	}

	public CountMap() {
		super(0);

	}

	/**
	 * Returns the normalized value between [0,1] for this key.
	 * 
	 * @param key
	 *            the key to get a normalized value for
	 * @return normalized count
	 */
	public double getNormalized(A key) {
		return get(key) / (double) totalCount();
	}

	/**
	 * Adds one to the count of value.
	 * 
	 * @param value
	 *            the value to count
	 */
	public void count(A value) {
		count(value,1);

	}

	/**
	 * Create a deep copy of this object.
	 */
	public CountMap<A> copy() {
		CountMap<A> out = new CountMap<A>();
		for (A i : this.keySet())
			out.put(i, this.get(i));
		return out;
	}

	public void count(A key, int value) {
		this.put(key, this.get(key) + value);
		
	}
}
