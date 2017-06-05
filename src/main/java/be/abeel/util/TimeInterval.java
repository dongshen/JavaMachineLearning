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

import java.io.Serializable;
/**
 * 
 * @author Thomas Abeel
 *
 */
public class TimeInterval implements Serializable {

    private static final long serialVersionUID = -5251967760337130846L;

    private long milliseconds, seconds, minutes, hours, days;

    public TimeInterval(String s){
    	String[] d=s.split("d ");
    	days=Long.parseLong(d[0]);
    	String[] h=d[1].split(":");
    	hours=Long.parseLong(h[0]);
    	minutes=Long.parseLong(h[1]);
    	String[]ms=h[2].split("'");
    	seconds=Long.parseLong(ms[0]);
    	milliseconds=Long.parseLong(ms[1]);
    }
    
    public long getLengthInMilliseconds(){
    	return ((((((24*days)+hours)*60)+minutes)*60)+seconds)*1000+milliseconds;
    }
    
    public TimeInterval(long ms) {
        seconds = ms / 1000;
        minutes = seconds / 60;
        hours = minutes / 60;
        days = hours / 24;
        hours = hours % 24;
        minutes = minutes % 60;
        seconds = seconds % 60;
        milliseconds = ms % 1000;
    }

    public String toString() {
        return days + "d " + hours + ":" + (minutes < 10 ? "0" + minutes : minutes) + ":"
                + (seconds < 10 ? "0" + seconds : seconds) + "'" + milliseconds;

    }

    public long getDays() {
        return days;
    }

    public long getHours() {
        return hours;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return seconds;
    }

}

