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
package be.abeel.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class LineIteratorFactory {

    public static LineIterator createFromGZip(File f) throws IOException {
        return new LineIterator(new GZIPInputStream(new FileInputStream(f)));
    }

    public static LineIterator createFromZip(File f) throws IOException {
        ZipInputStream zipinputstream = new ZipInputStream(new FileInputStream(f));

        ZipEntry zipentry = zipinputstream.getNextEntry();
//        System.out.println(zipentry);
        if (zipentry != null) {
            // for each entry to be extracted
            String entryName = zipentry.getName();
//            System.out.println("File ::" + entryName);
            // RandomAccessFile rf;
            File newFile = new File(entryName);
            return new LineIterator(newFile);

            // out = read(it, classIndex, separator);
            // zipinputstream.closeEntry();
        }
        return null;
    }
}
