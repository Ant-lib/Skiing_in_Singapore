/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skiing.common;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ant
 */
public class Moves {
    public final Map<String, String> possibleRunsMap;

    public Moves() {
        this.possibleRunsMap = new HashMap<>();
    }
    
    /**
     * Calculate max run for the side
     * 
     * @param graph - whole graph map
     * @param side - travel direction
     * @param row - row index
     * @param col - column index
     * @return longest run from the current start index
     */
    public String getSideRun(Integer[][] graph, String side, int row, int col)
    {
        String run = "";
        switch (side) {
            case "west":
            {
                int direction = col-1;
                if(direction >= 0 && graph[row][direction] < graph[row][col]) {
                    String skiStep = row + " " + direction;
                    if(possibleRunsMap.containsKey(skiStep))
                        run = possibleRunsMap.get(skiStep);
                    else
                        run = LongestRunCalc.getLongestRun(graph, row, direction);
                }
                break;
            }
            case "north":
            {
                int direction = row-1;
                if(direction >= 0 && graph[direction][col] < graph[row][col]) {
                    String skiStep = direction + " " + col;
                    if(possibleRunsMap.containsKey(skiStep))
                        run = possibleRunsMap.get(skiStep);
                    else
                        run =  LongestRunCalc.getLongestRun(graph, direction, col);
                }
                break;
            }
            case "east":
            {
                int direction = col+1;
                if(direction < graph[0].length && graph[row][direction] < graph[row][col]) {
                    String skiStep = row + " " + direction;
                    if(possibleRunsMap.containsKey(skiStep))
                        run = possibleRunsMap.get(skiStep);
                    else
                        run = LongestRunCalc.getLongestRun(graph, row, direction);
                }
                break;
            }
            case "south":
            {
                int direction = row+1;
                if(direction < graph.length && graph[direction][col] < graph[row][col]) {
                    String skiStep = direction + " " + col;
                    if(possibleRunsMap.containsKey(skiStep))
                        run = possibleRunsMap.get(skiStep);
                    else
                        run = LongestRunCalc.getLongestRun(graph, direction, col);
                }
                break;
            }
        }
        return run;
    }
}
