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
import java.io.FileFilter;
import java.util.List;
import java.util.Vector;

public class ExtensionFileFilter implements FileFilter {
    private Vector<String> extension = new Vector<String>();

    private void addExtension(String ext) {
        // Add a dot, it it doesn't start with one.
        if (!ext.startsWith("\\."))
            ext = "." + ext;
        this.extension.add(ext.toLowerCase());
    }

    public ExtensionFileFilter(List<String> ext) {
        for (String s : ext)
            addExtension(s.toLowerCase());
    }

    public ExtensionFileFilter(String ext) {
        addExtension(ext.toLowerCase());
    }

    public boolean accept(File file) {
        boolean accept = false;
        for (String s : extension) {
            if (file.getName().endsWith(s))
                accept = true;
        }
        return accept;
        // return extension.indexOf(file.getName().toLowerCase().e;
    }
}
