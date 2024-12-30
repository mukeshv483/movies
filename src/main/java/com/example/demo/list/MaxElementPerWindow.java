package com.example.demo.list;

import java.util.*;

/**
 * @author Mukesh Verma
 */
public class MaxElementPerWindow {

    public static void main(String[] args) {
        int windowSize = 3;
        int nums[] = {1, 3, 4, 8, 6, 3, 12, 87};
       // System.out.println(findMaxPerWindow(nums, windowSize));
        System.out.println(findMaxPerWindow(nums, windowSize));
    }

    private static List<Integer> findMaxPerWindowHeap(int[] nums, int windowSize) {
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(windowSize);
        List<Integer> result = new ArrayList<>();
        for(int n:nums){
            maxHeap.add(n);
            if(maxHeap.size()>windowSize){
                maxHeap.poll();
            }

            result.add(maxHeap.peek());
        }
        return  result;
    }

    private static List<Integer> findMaxPerWindow(int[] nums, int windowSize) {
        List<Integer> result = new ArrayList<>();
        if (Objects.nonNull(nums) && nums.length < windowSize) {
            return result;
        }
        Deque<Integer> queue = new ArrayDeque<>();

        int end = 0;

        for (end = 0; end < nums.length; end++) {
            if (end < windowSize-1) {
                cleanUp(nums, queue, end);
                queue.addLast(end);
                continue;
            }
            cleanUp(nums,queue,end);
            if(!queue.isEmpty() && queue.peekFirst() <=(end-windowSize)){
                queue.removeFirst();
            }
            queue.addLast(end);

            if(!queue.isEmpty()){
                result.add(nums[queue.getFirst()]);
            }

        }
        return result;
    }

    private static void cleanUp(int[] nums, Deque<Integer> queue, int end) {
        while (!queue.isEmpty() && nums[end] >= nums[queue.getLast()] ) {
            queue.removeLast();
        }
    }

}
