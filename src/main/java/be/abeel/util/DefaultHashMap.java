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

import java.util.HashMap;

/**
 * Extension of the HashMap that will return a default value instead of null
 * when a key is not present in the map.
 * 
 * @author Thomas Abeel
 * 
 * @param <K>
 * @param <V>
 */
public class DefaultHashMap<K, V> extends HashMap<K, V> {

    private static final long serialVersionUID = -3738594693170825324L;

    private V defaultValue = null;

    public DefaultHashMap(V defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public V get(Object key) {
        if (super.containsKey(key))
            return super.get(key);
        else
            return defaultValue;
    }

}
