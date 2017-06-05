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
package be.abeel.security;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Utility class to calculate an MD5 digest from a String.
 * 
 * @author Thomas Abeel
 *
 */
public class MD5Tools {

	/**
	 * Returns the hexadecimal representation of an MD5 hash.
	 *
	 * @param pass input string
	 * @return hashed string
	 */
	static public String md5(String pass){
		return hex(calcMd5(pass));
	}

	/**
	 * make an md5 hash from a string
	 *
	 * @param pass string to be hashed
	 * @return the hash as an byte array
	 */
	static private byte[] calcMd5(String pass){
		try{
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(pass.getBytes(),0,pass.length());
			byte[] hash = digest.digest();
			return hash;
		} catch(NoSuchAlgorithmException e){
			System.err.println("No MD5 algorithm found");
			throw new RuntimeException(e);
		}
	}


	/**
	 * Convert an array of bytes to an uppercase hexadecimal representation
	 *
	 * @param array a byte array
	 * @return the byte array as a hexadecimal string representation
	 */
	static private String hex(byte[] array) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; ++i) {
			sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1,3));
		}
		return sb.toString();
	}


}
