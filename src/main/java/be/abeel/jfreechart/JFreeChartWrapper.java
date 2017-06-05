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
package be.abeel.jfreechart;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.JFreeChart;

import be.abeel.graphics.Drawable;

/**
 * Wrapper around a JFreeChart to be able to use make it a Drawable object.
 * 
 * @author Thomas Abeel
 * 
 */
public class JFreeChartWrapper implements Drawable {

    private JFreeChart chart;

    public JFreeChartWrapper(JFreeChart chart) {
        this.chart = chart;
    }

    public void draw(Graphics2D g, Rectangle2D rec) {
        chart.draw(g, rec);

    }
}
