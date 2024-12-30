package com.example.demo.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mukesh Verma
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][]intervals={{0, 0}, {1, 18}, {1, 3}};
                //{{1, 2}, {3, 4}, {8, 8}};
                //{{1,5},{3,7},{4,6}};
        int[][]result=mergeIntervals(intervals);
        System.out.println(Arrays.deepToString(result));
//      result.stream().forEach(res->{
//          System.out.println("start: "+res[0]+ " end: "+res[1]);
//      });
    }

    private static int[][] mergeIntervals(int[][] intervals) {

        int start=intervals[0][0];
        int end=intervals[0][1];

        List<int[]>result=new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[]currentInterval=intervals[i];
            if(currentInterval[0]<=end){
                end=Math.max(end,currentInterval[1]);
            }
            else{
                result.add(new int[]{start,end});
                start=currentInterval[0];
                end=currentInterval[1];
            }

        }
        result.add(new int[]{start,end});
        return  result.toArray(new int[][]{});
    }
}
