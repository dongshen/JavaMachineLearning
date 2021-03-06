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
package be.abeel.util;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYBarDataset;

import be.abeel.graphics.GraphicsFileExport;
import be.abeel.jfreechart.JFreeChartWrapper;

/**
 * Utility methods for frequency maps.
 * 
 * @author Thomas Abeel
 */
public class FrequencyMapUtils {

	public static void plot(FrequencyMap freq, String file) {
		plot(freq, file, false);
	}

	/**
	 * Exports the frequency map as a plot in a png file.
	 */
	public static void plot(FrequencyMap freq, String file, boolean countNormalization) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i : freq.keySet()) {
			if (i > max)
				max = i;
			if (i < min)
				min = i;
		}

		plot(freq, file, countNormalization, min, max);

	}

	public static void plot(FrequencyMap freq, String file, boolean countNormalization, int lower, int upper) {
		plot("Frequency map", freq, file, countNormalization, lower, upper);

	}

	public static void plot(String title, FrequencyMap freq, String file, boolean countNormalization, int lower, int upper) {
		// XYSeries xy = new XYSeries("Frequency");
		// SimpleHistogramDataset xy=new SimpleHistogramDataset("Frequency");
		double[][] data = new double[2][freq.keySet().size()];
		int index = 0;
		for (int i : freq.keySet()) {
			data[0][index] = i;
			data[1][index] = freq.get(i);
			// xy.add(i, this.get(i));
			index++;
		}

		if (countNormalization) {
			int totalCount = freq.totalCount();
			for (int i = 0; i < data[1].length; i++)
				data[1][i] /= totalCount;
		}
		// XYSeriesCollection col = new XYSeriesCollection();
		DefaultXYDataset set = new DefaultXYDataset();
		set.addSeries("freq", data);
		// col.addSeries(xy);
		JFreeChart chart = ChartFactory.createXYBarChart(title, "bin", false, "count", new XYBarDataset(set, 1.0), PlotOrientation.VERTICAL, false, false, false);
		if (countNormalization) {
			chart.getXYPlot().getRangeAxis().setRange(0, 1);
		}
		chart.getXYPlot().getDomainAxis().setRange(lower, upper);
		GraphicsFileExport.exportPNG(new JFreeChartWrapper(chart), file, 800, 600);

	}

	public static void plot(String title,List<FrequencyMap> list, String file, boolean countNormalization, int lower, int upper,String[]labels) {
		// XYSeries xy = new XYSeries("Frequency");
		// SimpleHistogramDataset xy=new SimpleHistogramDataset("Frequency");
		int count = 0;
		DefaultXYDataset set = new DefaultXYDataset();
		for (FrequencyMap freq : list) {
			double[][] data = new double[2][freq.keySet().size()];
			int index = 0;

			for (int i : freq.keySet()) {
				data[0][index] = i;
				data[1][index] = freq.get(i);
				// xy.add(i, this.get(i));
				index++;
			}

			if (countNormalization) {
				int totalCount = freq.totalCount();
				for (int i = 0; i < data[1].length; i++)
					data[1][i] /= totalCount;
			}
			// XYSeriesCollection col = new XYSeriesCollection();
			

			set.addSeries(labels!=null?labels[count++]:"freq" + count++, data);
		}
		// col.addSeries(xy);
		JFreeChart chart = ChartFactory.createXYBarChart(title, "bin", false, "count", new XYBarDataset(set, 1.0), PlotOrientation.VERTICAL, false, false, false);
		if (countNormalization) {
			chart.getXYPlot().getRangeAxis().setRange(0, 1);
		}
		chart.getXYPlot().getDomainAxis().setRange(lower, upper);
		GraphicsFileExport.exportPNG(new JFreeChartWrapper(chart), file, 800, 600);

	}

}
