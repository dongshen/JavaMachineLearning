/**
 * %SVN.HEADER%
 */
package net.sf.javaml.classification;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import net.sf.javaml.classification.MeanFeatureVotingClassifier;
import net.sf.javaml.classification.evaluation.CrossValidation;
import net.sf.javaml.classification.evaluation.PerformanceMeasure;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

import org.junit.Test;

public class TestMeanFeatureVoting {
    @Test
    public void testColon() {
        
        try {
            Dataset data = FileHandler.loadDataset(new File("devtools/data/colon.csv.gz"), 0, ",");
            System.out.println("Loader: " + data.classes());
            MeanFeatureVotingClassifier nmc = new MeanFeatureVotingClassifier();
            CrossValidation cv = new CrossValidation(nmc);
            Map<Object,PerformanceMeasure>p=cv.crossValidation(data, 5, new Random(10));
            System.out.println(p);
            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
    
    @Test
    public void testNearestMeanIris(){
        try {
            Dataset data = FileHandler.loadDataset(new File("devtools/data/iris.data"), 4,",");
            System.out.println("Loader: " + data.classes());
            MeanFeatureVotingClassifier nmc = new MeanFeatureVotingClassifier();
            CrossValidation cv = new CrossValidation(nmc);
            Map<Object,PerformanceMeasure>p=cv.crossValidation(data, 5, new Random(10));
            System.out.println(p);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

   

}
