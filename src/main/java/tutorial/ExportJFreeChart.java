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
package tutorial;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import be.abeel.graphics.GraphicsFileExport;
import be.abeel.jfreechart.JFreeChartWrapper;

public class ExportJFreeChart {

    public static void main(String[] args) {
        XYSeries ser = new XYSeries("Sample");

        ser.add(0, 1);
        ser.add(1, 5);
        ser.add(2, 3);
        ser.add(3, 0);
        XYSeriesCollection col = new XYSeriesCollection();
        col.addSeries(ser);
        JFreeChart chart = ChartFactory.createXYLineChart("Sample chart", "x-axis", "y-axis", col,
                PlotOrientation.VERTICAL, true, false, false);
        GraphicsFileExport.exportPDF(new JFreeChartWrapper(chart), "export", 640, 480);

    }
}
