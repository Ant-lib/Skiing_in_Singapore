/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skiing.common;

/**
 *
 * @author Ant
 */
public class LongestRunCalc {
    
    /**
     * Get the longest run on the whole resort
     * 
     * @param graph - whole graph map
     * @return longest run of the graph
     */
        public String[] getLongestRun(Integer[][] graph) {
        Moves mvs = new Moves();
        String maxRunList = "";
        
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                String returnRun = getLongestRun(graph, i, j);
                
                // Check which drop is better (longest + steepest)
                if(returnRun.length() == maxRunList.length()) {
                    int returnListDrop = Integer.parseInt(returnRun.substring(returnRun.length()-1, returnRun.length())) - Integer.parseInt(returnRun.replaceAll("\\s+","").substring(0, 1));
                    int maxRunListDrop = Integer.parseInt(maxRunList.substring(maxRunList.length()-1, maxRunList.length())) - Integer.parseInt(maxRunList.replaceAll("\\s+","").substring(0, 1));
                    if(returnListDrop > maxRunListDrop)
                        maxRunList = returnRun;
                } else if(returnRun.length() > maxRunList.length()) {
                    maxRunList = returnRun;
                }
            }
        }
        
        String[] results =  maxRunList.substring(1).split(" ");
        mvs.possibleRunsMap.clear();
        
        return results;
    }

    /**
     * Check all sides run and return longest
     * 
     * @param graph - whole graph map
     * @param row - row index
     * @param col - column index
     * @return longest run for the ride
     */
        public static String getLongestRun(Integer[][] graph, int row, int col) {
        Moves mvs = new Moves();
        String longestRunForTheRide = "";
        
        String westRun = mvs.getSideRun(graph, "west", row, col);
        String northRun = mvs.getSideRun(graph, "north", row, col);
        String eastRun = mvs.getSideRun(graph, "east", row, col);
        String southRun = mvs.getSideRun(graph, "south", row, col);
        
        if(northRun.length() > westRun.length())
            longestRunForTheRide = northRun;
        else
            longestRunForTheRide = westRun;

        if(eastRun.length() > longestRunForTheRide.length())
            longestRunForTheRide = eastRun;

        if(southRun.length() > longestRunForTheRide.length())
            longestRunForTheRide = southRun;
        
        longestRunForTheRide += " " + graph[row][col];
        mvs.possibleRunsMap.put(row + " " + col, longestRunForTheRide);
        return longestRunForTheRide;
    }
}
