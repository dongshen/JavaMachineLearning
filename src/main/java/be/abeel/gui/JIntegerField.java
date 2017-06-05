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
package be.abeel.gui;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

/**
 * This text field will only allow the user to type positive integer values.
 * 
 * @author Thomas Abeel
 * 
 */
public class JIntegerField extends JTextField {

    private static final long serialVersionUID = 3389445665241505189L;

    final static String badchars = "`~!@#$%^&*()_+=\\|\"':;?/>.<, ";

    public JIntegerField() {
        super();
    }

    public JIntegerField(String string) {
        super(string);
    }

    @Override
    public void processKeyEvent(KeyEvent ev) {
        char c = ev.getKeyChar();
        if ((Character.isLetter(c) && !ev.isAltDown()) || badchars.indexOf(c) > -1) {
            ev.consume();
        } else {
            super.processKeyEvent(ev);
        }

    }

    public int getValue() {
        return Integer.parseInt(this.getText());
    }
}
