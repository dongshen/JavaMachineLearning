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
 * Two-dimensional HashMap with a default value. Each value has a pair of keys.
 * The outer Map consists of HashMaps keyed by the first key, and each
 * corresponding HashMap is keyed by the second key.
 * 
 * @author Thomas Abeel
 */
public class DefaultHashMap2D<K, L, V> extends HashMap2D<K, L, V> {
	

	
	private static final long serialVersionUID = -5725812876666561447L;
	private V defaultValue;

	/**
	 * Constructs an empty LinkedHashMap.
	 */
	public DefaultHashMap2D(V defaultValue) {
		super();
		this.defaultValue = defaultValue;
	}



	/**
	 * Gets the value of the property.
	 * 
	 * @param key1
	 *            The outer key of the property
	 * @param key2
	 *            The inner key of the property.
	 * @return The value of the property
	 */
	public V get(K key1, L key2) {
		V value = defaultValue;
		if (super.get(key1,key2)!=null) {
			value = this.get(key1).get(key2);
		}
		return value;
	}

	

	/**
	 * Returns the value that will be returned as a default for missing values.
	 * 
	 * @return default value
	 */
	public V getDefault() {
		return defaultValue;
	}
}