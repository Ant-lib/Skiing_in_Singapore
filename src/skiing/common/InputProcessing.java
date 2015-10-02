/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skiing.common;

import common.exceptions.SimpleException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Ant
 */
public class InputProcessing {
    
    /**
     * Getting path to a file
     * 
     * @return input file
     * @throws SimpleException
     */
    public static File processFile() throws SimpleException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter path to file: ");
            System.out.flush();
            try {
                String filename = scanner.nextLine();
                File file = new File(filename);
                return file;
            }
            catch (java.util.InputMismatchException e) {
                throw new SimpleException("Error during processing file path");
            }
        }
    }
    
    /**
     * Read graph size from input file and creating graph Array
     * 
     * @param br
     * @return Integer[][] graph for specified size
     * @throws IOException
     * @throws NumberFormatException
     * @throws SimpleException
     */
    public static Integer[][] getGraphSize(BufferedReader br) throws IOException, NumberFormatException, SimpleException {
        String sCurrentLine = "";
        Integer[][] graph = null;

        try {
            sCurrentLine = br.readLine();
            String[] tokens =  sCurrentLine.split(" ");
            Integer row =  Integer.valueOf(tokens[0]);
            Integer col =  Integer.valueOf(tokens[1]);
            graph = new Integer[row][col];
        } catch (Exception e) {
            throw new SimpleException("Error during getting graph size");
        }
        return graph;
    }
    
    /**
     * Process graph saved in a file
     * 
     * @param br
     * @param grid
     * @throws IOException
     * @throws NumberFormatException
     */
    public static void processGraph(BufferedReader br, Integer[][] grid) throws IOException, NumberFormatException, SimpleException {
        String sCurrentLine = null;
        int count = 0;
        
        try {
            sCurrentLine = br.readLine();

            while (sCurrentLine != null) {
                String[] tokens =  sCurrentLine.split(" ");
                for(int i = 0; i < tokens.length; i++) {
                    grid[count][i] = Integer.valueOf(tokens[i]);
                }
                count++;
                sCurrentLine = br.readLine();
            }
        } catch (Exception e) {
            throw new SimpleException("Error during processing graph");
        }
    }
}
