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
package be.abeel.graphics;


/**
 * This class provides utility methods to export objects that implement the
 * Drawable interface to files.
 * 
 * @author Thomas Abeel
 * 
 */
public class GraphicsFileExport {

    /**
     * Export the drawable to a file in PNG format.
     * 
     * @param d
     *            the object to export
     * @param fileName
     *            the filename of the file
     * @param x
     *            the width in pixels
     * @param y
     *            the height in pixels
     */
    public static void exportPNG(Drawable d, String fileName, int x, int y) {
        ImageIOexport.exportPNG(d, fileName, x, y);
    }

    /**
     * Export the drawable to a file in JPG format.
     * 
     * @param d
     *            the object to export
     * @param fileName
     *            the filename of the file
     * @param x
     *            the width in pixels
     * @param y
     *            the height in pixels
     */
    public static void exportJPG(Drawable d, String fileName, int x, int y) {
        ImageIOexport.exportJPG(d, fileName, x, y);
    }

    /**
     * Export the drawable to a file in GIF format.
     * 
     * @param d
     *            the object to export
     * @param fileName
     *            the filename of the file
     * @param x
     *            the width in pixels
     * @param y
     *            the height in pixels
     */
    public static void exportGIF(Drawable d, String fileName, int x, int y) {
        ImageIOexport.exportGIF(d, fileName, x, y);
    }

    /**
     * Export the drawable to a file in PDF format
     * 
     * @param d
     *            the object to export
     * @param fileName
     *            the filename of the file
     * @param x
     *            the width in pixels
     * @param y
     *            the height in pixels
     */
    public static void exportPDF(Drawable d, String fileName, int x, int y) {
        PDFexport.exportPDF(d, fileName, x, y);
    }

    /**
     * Export the Drawable to a file in BMP format.
     * 
     * @param d
     *            the object to export
     * @param fileName
     *            the filename of the file
     * @param x
     *            the width in pixels
     * @param y
     *            the height in pixels
     */
    public static void exportBMP(Drawable d, String fileName, int x, int y) {
       Image4Jexport.exportBMP(d,fileName,x,y);
    }

    /**
     * Export the Drawable to a file in ICO format.
     * 
     * @param d
     *            the object to export
     * @param fileName
     *            the filename of the file
     * @param x
     *            the width in pixels
     * @param y
     *            the height in pixels
     */
    public static void exportICO(Drawable d, String fileName, int x, int y) {
        Image4Jexport.exportICO(d,fileName,x,y);
    }

    /**
     * Export the drawable to an SVG file
     * 
     * @param d
     * @param fileName
     * @param x
     * @param y
     */
    public static void exportSVG(Drawable d, String fileName, int x, int y) {

      SVGexport.exportSVG(d,fileName,x,y);

    }

}
