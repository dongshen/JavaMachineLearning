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
package be.abeel.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Thomas Abeel
 * 
 */
public class MemoryWidget extends JLabel {

	private static final long serialVersionUID = -3984980155889057580L;

	public static long getAvailable() {
		return available;
		
	}

	private static long available;
	
	public MemoryWidget() {
		super.setToolTipText("Memory used/available");
		Thread t = new Thread(new Runnable() {

			public void run() {
				while (true) {
					repaint();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		t.setDaemon(true);
		t.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		MemoryUsage mu = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
		available=mu.getMax()-mu.getUsed();
		int width = this.getSize().width;
		int used = (int) ((mu.getUsed() / (double) mu.getMax()) * width);
		int comm = (int) ((mu.getCommitted() / (double) mu.getMax()) * width);
		mu.toString();
		g.setColor(Color.green);
		g.fillRect(0, 0, width, this.getSize().height);
		g.setColor(Color.orange);
		g.fillRect(0, 0, comm, this.getSize().height);
		g.setColor(Color.red);
		g.fillRect(0, 0, used, this.getSize().height);
		StringBuffer buf = new StringBuffer();

		buf.append((mu.getUsed() >> 20) + " / ");
		buf.append((mu.getMax() >> 20) + " (Mb)");
		g.setColor(Color.black);

		drawCenteredString(buf.toString(), width, this.getSize().height, g);

	}

	public void drawCenteredString(String s, int w, int h, Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		int x = (w - fm.stringWidth(s)) / 2;
		int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		g.drawString(s, x, y);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Test MemoryWidget");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(new MemoryWidget());
		GridBagPanel gp = new GridBagPanel();
		gp.add(new MemoryWidget(), gp.gc);
		window.setPreferredSize(new Dimension(100, 50));
		window.pack();
		window.setVisible(true);
	}

}
