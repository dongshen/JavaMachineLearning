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

import junit.framework.Assert;

import org.junit.Test;

import be.abeel.util.TimeInterval;

public class TestTimeInterval {
	@Test
	public void testTimeInterval() {
		long time=System.currentTimeMillis();
		TimeInterval t=new TimeInterval(time);
		Assert.assertEquals(time, t.getLengthInMilliseconds());
		String st=t.toString();
		TimeInterval t2=new TimeInterval(st);
		Assert.assertEquals(time,t2.getLengthInMilliseconds());
		Assert.assertEquals(st, t2.toString());
		
	}
}
