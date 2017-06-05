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

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import be.abeel.io.ExtensionManager;

public class ImageIOexport {
    private static void imageIOExport(String type, Drawable d, String fileName, int x, int y) {
    	System.out.println("EXporting");
        BufferedImage bi = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) bi.getGraphics();
        d.draw(g, new Rectangle(x, y));
        try {
            ImageIO.write(bi, type, new File(fileName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void exportPNG(Drawable d, String fileName, int x, int y) {
        imageIOExport("PNG", d, ExtensionManager.extension(fileName, ExtensionManager.PNG), x, y);

    }

    public static void exportJPG(Drawable d, String fileName, int x, int y) {
        imageIOExport("JPG", d, ExtensionManager.extension(fileName, ExtensionManager.JPG), x, y);

    }

    public static void exportGIF(Drawable d, String fileName, int x, int y) {
        imageIOExport("GIF", d, ExtensionManager.extension(fileName, ExtensionManager.GIF), x, y);
        
    }
}
