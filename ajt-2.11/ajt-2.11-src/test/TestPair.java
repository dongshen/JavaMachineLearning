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
package test;

import junit.framework.Assert;

import org.junit.Test;

import be.abeel.util.Pair;

public class TestPair {
    @Test
    public void testPair() {
        Pair<Integer, Integer> p1 = new Pair<Integer, Integer>(1, 2);
        Pair<Integer, Integer> p2 = new Pair<Integer, Integer>(1, 2);
       
        Assert.assertEquals(p1.hashCode(), p2.hashCode());
        Assert.assertTrue(p1.equals(p2));
        Assert.assertTrue(p2.equals(p1));
        Pair<String, String> q1 = new Pair<String, String>("Hallo kroket", "yow");
        Pair<String, String> q2 = new Pair<String, String>("Hallo kroket", "yow");
        Pair<String, String> q3 = new Pair<String, String>("Hallo kroket", "verkeerd");
        Assert.assertEquals(q1.hashCode(), q2.hashCode());
        Assert.assertTrue(q1.equals(q2));
        Assert.assertTrue(q2.equals(q1));
        Assert.assertFalse(q3.equals(q1));
        Assert.assertFalse(q3.equals(q2));
        Assert.assertFalse(q1.equals(q3));
        Assert.assertFalse(q2.equals(q3));
        Pair<String, Integer> s1=new Pair<String, Integer>("chr6_qbl_hap2",4452925);
        Pair<String, Integer> s2=new Pair<String, Integer>("chr6_qbl_hap2",4452925);
        Assert.assertEquals(s1.hashCode(), s2.hashCode());
        Assert.assertTrue(s1.equals(s2));
        Assert.assertTrue(s2.equals(s1));
    }

}
