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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;


public class GZIPPrintWriter extends PrintWriter {

    public GZIPPrintWriter(File file, String csn) throws IOException {
        super(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(ExtensionManager.extension(file, "gz"))),csn));
    }

    public GZIPPrintWriter(File file) throws IOException {
        super(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(ExtensionManager.extension(file, "gz")))));
    }

    public GZIPPrintWriter(OutputStream out, boolean autoFlush) throws IOException {
        super(new OutputStreamWriter(new GZIPOutputStream(out)));
    }

    public GZIPPrintWriter(OutputStream out) throws IOException {
        super(new OutputStreamWriter(new GZIPOutputStream(out)));
    }

    public GZIPPrintWriter(String fileName, String csn) throws IOException {
        super(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(ExtensionManager.extension(fileName, "gz"))), csn));
    }

    public GZIPPrintWriter(String fileName) throws IOException {
        super(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(ExtensionManager.extension(fileName, "gz")))));
    }

}
