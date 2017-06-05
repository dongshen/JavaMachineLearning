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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JPanel;

/**
 * A panel that has a GridBagLayout as a default. By default this panel has a
 * layout with insets of 3 pixels on all sides and will fill components in both
 * directions.
 * 
 * @author Thomas Abeel
 * 
 */
public class GridBagPanel extends JPanel {

    private static final long serialVersionUID = -1911821687959606247L;

    public GridBagConstraints gc;

    private void init() {
        this.setLayout(new GridBagLayout());
        gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(3, 3, 3, 3);
        
//        gc.weightx=1;
//        gc.weighty=1;
    }

    public GridBagPanel(LayoutManager arg0, boolean arg1) {
        super(arg0, arg1);
        init();
    }

    public GridBagPanel(LayoutManager arg0) {
        super(arg0);
        init();
    }

    public GridBagPanel(boolean arg0) {
        super(arg0);
        init();
    }

    public GridBagPanel() {
        super();
        init();
    }

}
