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
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import be.abeel.io.ExtensionManager;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.DefaultFontMapper;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

public class PDFexport {

    public static void exportPDF(Drawable d, String fileName, int x, int y) {
        com.lowagie.text.Rectangle pagesize = new com.lowagie.text.Rectangle(x, y);
        Document document = new Document(pagesize, 50, 50, 50, 50);

        try {
            fileName = ExtensionManager.extension(fileName, ExtensionManager.PDF);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            document.open();
            PdfTemplate tp = cb.createTemplate(x, y);
            Graphics2D g2 = tp.createGraphics(x, y, new DefaultFontMapper());
            Rectangle2D r2D = new Rectangle2D.Double(0, 0, x, y);
            // System.out.println("ExportFactory.java: "+charts[i]);
            d.draw(g2, r2D);
            g2.dispose();
            cb.addTemplate(tp, 0, 0);

            //
            document.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
