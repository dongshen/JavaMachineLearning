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
package test;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

import be.abeel.bioinformatics.dnaproperties.DNAProperty;

public class TestDNAProperty {
    @Test
    public void testProperty() {
       System.out.println(Arrays.toString(DNAProperty.BaseStacking.normalizedProfile("aattcgcgagtcgat")));
       System.out.println(Arrays.toString(DNAProperty.BaseStacking.profile("aattcgcgagtcgat")));
       double[]values=DNAProperty.BaseStacking.profile("aattcgcgagtcgat");
       Assert.assertEquals(-5.37, values[0], 0.000001);//aa
       Assert.assertEquals(-6.57, values[1], 0.000001);//at
       Assert.assertEquals(-5.37, values[2], 0.000001);//tt
       Assert.assertEquals(-9.81, values[3], 0.000001);//tc
       Assert.assertEquals(-9.69, values[4], 0.000001);//cg
       Assert.assertEquals(-14.59, values[5], 0.000001);//gc
       Assert.assertEquals(-9.69, values[6], 0.000001);//cg
       Assert.assertEquals(-9.81, values[7], 0.000001);//ga
       Assert.assertEquals(-6.78, values[8], 0.000001);//ag
       Assert.assertEquals(-10.51, values[9], 0.000001);//gt
       Assert.assertEquals(-9.81, values[10], 0.000001);//tc
       double val=DNAProperty.BaseStacking.value("aattcgcgagtcgat");
       Assert.assertEquals(-8.862142857, val, 0.0000001);
    }
    @Test
    public void testPropertyUpperCase() {
       System.out.println(Arrays.toString(DNAProperty.BaseStacking.normalizedProfile("AATTCGCGAGTCGAT")));
       System.out.println(Arrays.toString(DNAProperty.BaseStacking.profile("AATTCGCGAGTCGAT")));
       double[]values=DNAProperty.BaseStacking.profile("AATTCGCGAGTCGAT");
       Assert.assertEquals(-5.37, values[0], 0.000001);//aa
       Assert.assertEquals(-6.57, values[1], 0.000001);//at
       Assert.assertEquals(-5.37, values[2], 0.000001);//tt
       Assert.assertEquals(-9.81, values[3], 0.000001);//tc
       Assert.assertEquals(-9.69, values[4], 0.000001);//cg
       Assert.assertEquals(-14.59, values[5], 0.000001);//gc
       Assert.assertEquals(-9.69, values[6], 0.000001);//cg
       Assert.assertEquals(-9.81, values[7], 0.000001);//ga
       Assert.assertEquals(-6.78, values[8], 0.000001);//ag
       Assert.assertEquals(-10.51, values[9], 0.000001);//gt
       Assert.assertEquals(-9.81, values[10], 0.000001);//tc
       double val=DNAProperty.BaseStacking.value("AATTCGCGAGTCGAT");
       Assert.assertEquals(-8.862142857, val, 0.0000001);
    }

}
