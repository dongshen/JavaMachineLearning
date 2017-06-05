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
package be.abeel.io;

import java.io.File;
import java.util.List;
import java.util.Vector;

/**
 * File extension manager, makes sure a file has an specified extension, or one
 * that is commonly used for that type of file.
 * 
 * @author Thomas Abeel
 * 
 */
public class ExtensionManager {

	/**
	 * List of commonly used extensions for JPEG encoded files.
	 */
	public static List<String> JPG = new Vector<String>();

	/**
	 * List of commonly used extensions for files related to web sites.
	 */
	public static List<String> WEB = new Vector<String>();

	/**
	 * List of commonly used extensions for GIF encoded files.
	 */
	public static List<String> GIF = new Vector<String>();

	/**
	 * List of commonly used extensions for PNG encoded files.
	 */
	public static List<String> PNG = new Vector<String>();

	/**
	 * List of commonly used extensions for PDF encoded files.
	 */
	public static List<String> PDF = new Vector<String>();

	/**
	 * List of commonly used extensions for EPS encoded files.
	 */
	public static List<String> EPS = new Vector<String>();

	/**
	 * List of commonly used extensions for EPS encoded files.
	 */
	public static List<String> BMP = new Vector<String>();

	/**
	 * List of commonly used extensions for ICO encoded files.
	 */
	public static List<String> ICO = new Vector<String>();

	/**
	 * List of commonly used extensions for SVG encoded files.
	 */
	public static List<String> SVG = new Vector<String>();

	static {
		/*
		 * JPEG
		 */
		JPG.add("jpg");
		JPG.add("jpeg");
		/*
		 * Web
		 */
		WEB.add("html");
		WEB.add("htm");
		WEB.add("php");
		WEB.add("htpl");
		WEB.add("jsp");
		WEB.add("php");
		WEB.add("css");
		WEB.add("asp");
		WEB.add("aspx");
		/*
		 * GIF
		 */
		GIF.add("gif");
		/*
		 * PNG
		 */
		PNG.add("png");
		/*
		 * PDF
		 */
		PDF.add("pdf");
		/*
		 * EPS-PS
		 */
		EPS.add("eps");
		EPS.add("ps");
		/*
		 * BMP
		 */
		BMP.add("bmp");

		/*
		 * ICO
		 */
		ICO.add("ico");

		/*
		 * SVG
		 */
		SVG.add("svg");
	}

	/**
	 * Makes sure a file has the specified extension, or one of the specified
	 * compatible ones.
	 * 
	 * @param fileName
	 *            The input file name
	 * @param exts
	 *            a <code>List</code>with the allowed extensions. The first one
	 *            will be used to add if the original file name doesn't have a
	 *            compatible extension.
	 * @return a new file name with the correct extension
	 */
	public static String extension(String fileName, List<String> exts) {
		int lastDot = fileName.lastIndexOf('.');
		String ext = null;
		if (lastDot > 0) {
			ext = fileName.substring(lastDot + 1, fileName.length()).toLowerCase();
		}
		if (ext == null || !exts.contains(ext)) {
			fileName += "." + exts.get(0);
		}
		return fileName;
	}

	/**
	 * Adds the correct extension to a file.
	 * 
	 * If the file already has an other extension, the new one will just be
	 * concatenated to it if they don't match.
	 * 
	 * @param fileName
	 *            input file name
	 * @param corExt
	 *            a string with the correct extension
	 * @return the new file name with the correct extension
	 */
	static public String extension(String fileName, String corExt) {
		Vector<String> exts = new Vector<String>();
		exts.add(corExt);
		return extension(fileName, exts);
	}

	/**
	 * Adds the correct extension to a file. If the file already has another
	 * extension, the new one will be appended. If the file already has the
	 * correct extension, it will be left alone.
	 * 
	 * @param file
	 *            name of input file
	 * @param corExt
	 *            the target extension
	 * @return a new File name with the correct extension
	 */
	public static File extension(File file, String corExt) {
		return new File(extension(file.toString(), corExt));
	}

	/**
	 * Adds the correct extension to a file.
	 * 
	 * If the file already has an other extension, the new one will just be
	 * concatenated to it if they don't match.
	 * 
	 * @param file
	 *            input file name
	 * @param exts
	 *            a list of allowed extensions, the first one will be used to add.
	 * @return the new File with the correct extension
	 */
	public static File extension(File file, List<String> exts) {
		return new File(extension(file.toString(), exts));
	}
}
