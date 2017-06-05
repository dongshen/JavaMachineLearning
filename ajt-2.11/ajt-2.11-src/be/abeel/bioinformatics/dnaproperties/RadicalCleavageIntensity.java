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
package be.abeel.bioinformatics.dnaproperties;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.NumberFormat;
import java.util.HashMap;

/**
 * Radical Cleavage Intensity
 * 
 * <pre>
 * Greenbaum et al. 2007, Genome Research
 * 
 * Construction of a genome-scale structural map at single-nucleotide resolution
 * 
 * Jason A. Greenbaum, Bo Pang, and Thomas D. Tullius
 * 
 * tullius@bu.edu
 * 
 * http://dna.bu.edu/orchid/
 * 
 * PMID: 17568010
 * </pre>
 * 
 * 
 * 
 * @author Thomas Abeel
 * 
 */
public class RadicalCleavageIntensity extends DNAProperty {

    /**
     * The number of nucleotides to take into account to calculate the Radical
     * Cleavage Intensifty.
     */
    private int Nmer;

    private HashMap<String, double[]> mapping;

    protected RadicalCleavageIntensity(int Nmer) {
        super("Radical cleavage intensity (" + Nmer + "-mer)");
        this.Nmer = Nmer;
        mapping = new HashMap<String, double[]>();

        try {
            URL url = RadicalCleavageIntensity.class.getResource("rci" + Nmer + ".tsv");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = in.readLine();
            while (line != null) {
                String[] arr = line.split("\t");
                double[] tmp = new double[Nmer];
                for (int i = 1; i <= Nmer; i++) {
                    tmp[i - 1] = Double.parseDouble(arr[i]);
                }
                mapping.put(arr[0].toLowerCase(), tmp);
                line = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not construct radical cleavage intensity property");
        }
    }

    @Override
    public int length() {
        return Nmer;
    }

    @Override
    public double[] normalizedProfile(String seq) {
        // the tables are normalized by default
        return profile(seq);
    }

    @Override
    public double normalizedValue(String seq) {
        // the tables are normalized by default
        return value(seq);
    }

    @Override
    public double[] profile(String seq) {

        int len = seq.length() - Nmer + 1;
        // System.out.println("len: " + len);
        double[] values = new double[seq.length()];
        int[] tmp = new int[seq.length()];
        for (int i = 0; i < len; i++) {
            // System.out.println("sub: " + seq.substring(i, i +
            // Nmer).toLowerCase());
            String sub = seq.substring(i, i + Nmer).toLowerCase();
            if (mapping.containsKey(sub)) {
                double[] seqVal = mapping.get(sub);
                for (int j = 0; j < seqVal.length; j++) {
                    values[i + j] += seqVal[j];
                    tmp[i + j]++;
                }
            }
        }
        // System.out.println("tmp: " + Arrays.toString(tmp));
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        double div = 1;
        for (int i = 0; i < seq.length(); i++) {
            // System.out.println(seq.charAt(i) + "\t" + i + "\tdiv: " + div +
            // "\t" + nf.format(values[i]) + "\t"
            // + nf.format(values[i] / div));
            values[i] /= div;

            if (i + 1 < Nmer)
                div++;
            if (i + Nmer >= seq.length())
                div--;

        }

        return values;
    }

    @Override
    public double value(String seq) {
        double value = 0;
        int count = 0;
        int len = seq.length() - Nmer + 1;
        for (int i = 0; i < len; i++) {
            double[] seqVal = mapping.get(seq.substring(i, i + Nmer).toLowerCase());
            if (seqVal == null)
                return 0;
            for (int j = 0; j < seqVal.length; j++) {
                value += seqVal[j];
                count++;
            }
        }
        value /= count;
        return value;
    }

}
