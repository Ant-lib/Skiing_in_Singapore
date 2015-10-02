/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skiing.launcher;

import common.exceptions.SimpleException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import skiing.common.*;

/**
 *
 * @author Ant
 */
public class AppLauncher {

    // Main method to start execution.
    public static void main(String arg[]) throws FileNotFoundException, IOException, SimpleException {
        try {
            // Getting file path
            BufferedReader br = null;
            File file = InputProcessing.processFile();

            // Processing file content
            try {
                br = new BufferedReader(new FileReader(file));
            } catch(Exception e) {
                throw new SimpleException("Error processing file");
            }

            // Creating graph by specified size
            Integer[][] graph = InputProcessing.getGraphSize(br);

            // Fill in the graph
            InputProcessing.processGraph(br, graph);

            // Do the main logic. Getting longest run according to conditions
            LongestRunCalc longestRun = new LongestRunCalc();
            String[] lr = longestRun.getLongestRun(graph);        

            // Processing results and reverse it
            int[] result = new int[lr.length];

            for (int i = 0; i < lr.length; i++)
                result[i] = Integer.parseInt(lr[i]);

            for(int i = 0; i < result.length / 2; i++) {
                int x = result[i];
                result[i] = result[result.length - i - 1];
                result[result.length - i - 1] = x;
            }

            System.out.println("\rLongest run: " + Arrays.toString(result));    
        } catch (SimpleException e) {
            System.out.println(e.getMessage());
        }
    }
}

