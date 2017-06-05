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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import org.junit.Test;

import be.abeel.graphics.Drawable;
import be.abeel.graphics.GraphicsFileExport;

public class TestGraphics {

    class Rect implements Drawable {

        public void draw(Graphics2D g, Rectangle2D rec) {
            g.setColor(Color.white);
            g.fillRect((int) rec.getMinX(), (int) rec.getMinY() , (int) rec.getWidth(), (int) rec
                    .getHeight());
            g.setColor(Color.black);
            g.drawRect((int) rec.getMinX() + 5, (int) rec.getMinY() + 5, (int) rec.getWidth() - 10, (int) rec
                    .getHeight() - 10);
            g.setColor(Color.red);
            g.fillOval((int) rec.getMinX() + 5, (int) rec.getMinY() + 5, (int) rec.getWidth() - 10, (int) rec
                    .getHeight() - 10);

        }

    }

    @Test
    public void testGraphics() {
        System.out.println("BMP");
        GraphicsFileExport.exportBMP(new Rect(), "rect", 100, 50);
        System.out.println("PDF");
        GraphicsFileExport.exportPDF(new Rect(), "rect", 100, 50);
        System.out.println("PNG");
        GraphicsFileExport.exportPNG(new Rect(), "rect", 100, 50);
        System.out.println("ICO");
        GraphicsFileExport.exportICO(new Rect(), "rect", 64, 64);
        System.out.println("JPG");
        GraphicsFileExport.exportJPG(new Rect(), "rect", 100, 50);
        System.out.println("GIF");
        GraphicsFileExport.exportGIF(new Rect(), "rect", 100, 50);
        
    }

}
