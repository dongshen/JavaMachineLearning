/**
 * %SVN.HEADER%
 */
package net.sf.javaml.filter;

import java.io.File;
import java.io.IOException;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;
import net.sf.javaml.featureselection.ranking.RecursiveFeatureEliminationSVM;
import net.sf.javaml.tools.data.FileHandler;

import org.junit.Test;

public class TestRFESVM {
    @Test
    public void testRELIEFSynthetic() {
        // double[] vals = { 1, 2, 3, 4, 5, 6 };

        Dataset data = new DefaultDataset();
        for (int i = 0; i < 100; i++) {
            double[] vals = { vary(5 * (i / 50), 1), vary(1, 0),Math.random() };
            Instance inst = new DenseInstance(vals, i /50);
            data.add(inst);

        }
//        NOrma dnm=new DatasetNormalizeMidrange(0.5,1);
//        dnm.build(data);
//        Dataset test=dnm.filterDataset(data);
        
        System.out.println(data);
        RecursiveFeatureEliminationSVM ga = new RecursiveFeatureEliminationSVM(0.2);
        //ga.setNumNeigbors(4);
     
        ga.build(data);
     
        System.out.println(ga.rank(0));
        System.out.println(ga.rank(1));
        System.out.println(ga.rank(2));
        
      
       

    }
    
    @Test
    public void testRELIEFReal(){
        try {
            Dataset data = FileHandler.loadDataset(new File("devtools/data/iris.data"), 4,",");
            System.out.println(data.classes());
            RecursiveFeatureEliminationSVM ga = new RecursiveFeatureEliminationSVM(0.20);
            //ga.setNumNeigbors(4);
         
            ga.build(data);
         
            System.out.println(ga.rank(0));
            System.out.println(ga.rank(1));
            System.out.println(ga.rank(2));
            System.out.println(ga.rank(3));
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private double vary(double i, double j) {
        return i + j * Math.random();
    }
}
