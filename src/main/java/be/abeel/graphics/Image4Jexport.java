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

package be.abeel.graphics;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import net.sf.image4j.codec.bmp.BMPEncoder;
import net.sf.image4j.codec.ico.ICOEncoder;
import be.abeel.io.ExtensionManager;

public class Image4Jexport {

    public static void exportBMP(Drawable d, String fileName, int x, int y) {
        try {
            BufferedImage bimage = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bimage.createGraphics();
            d.draw(g2d, new Rectangle(x, y));
            BMPEncoder.write(bimage, new File(ExtensionManager.extension(fileName, ExtensionManager.BMP)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public static void exportICO(Drawable d, String fileName, int x, int y) {
        try {
            BufferedImage bimage = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bimage.createGraphics();
            d.draw(g2d, new Rectangle(x, y));
            ICOEncoder.write(bimage, new File(ExtensionManager.extension(fileName, ExtensionManager.ICO)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
