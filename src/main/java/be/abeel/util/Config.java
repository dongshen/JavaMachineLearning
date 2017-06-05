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
package be.abeel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Config {

    private Properties prop;

    private File file;

    public synchronized void set(String key, String value) throws IOException {
        prop.put(key, value);
        save();
    }

    public synchronized String get(String key) {
        return prop.getProperty(key);
    }

    public synchronized String get(String name, String defaultValue) {
        return prop.getProperty(name, defaultValue);
    }

    public Config(String name) throws IOException {
        String home = System.getProperty("user.home");
        file = new File(home + "/." + name);
        if (!file.exists())

            file.createNewFile();

        prop = new Properties();

        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
        fis.close();

    }

    private void save() throws IOException {

        FileOutputStream fos = new FileOutputStream(file);
        prop.store(fos, "Saved: " + new Date());
        fos.close();

    }

}
