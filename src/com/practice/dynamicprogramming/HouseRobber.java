package com.practice.dynamicprogramming;

//state expression
// rob(i) = maxof(rob(i-2)+currentValue , rob(i-1))

import java.util.Arrays;

public class HouseRobber {


    //recursive top down
    public int rob(int[] nums){
        return rob(nums,nums.length - 1);
    }

    private int rob(int[] nums,int i){
        if(i < 0) return 0;
        return Math.max(rob(nums,i-2)+nums[i],rob(nums,i-1));
    }

    //recursive + memo

    int [] memo;
    public int robM(int[] nums){
        memo = new int[nums.length+1];
        Arrays.fill(memo,-1);
        return robM(nums,nums.length - 1);
    }

    public int robM(int[] nums,int i){
        if(i<0)return 0;
        if(memo[i]>=0){
            return memo[i];
        }
        int result = Math.max(robM(nums,i-2)+nums[i],robM(nums,i-1));
        memo[i] = result;
        return result;
    }

//tabulation (iterative bottom up)
public int robT(int[] nums){
        if(nums==null || nums.length==0)return 0;

        int[] tab = new int[nums.length+1];
        tab[0]=0;
        tab[1]=nums[0];
        for(int i=1;i<nums.length;i++){
            int val = nums[i];
            tab[i+1] = Math.max(tab[i],tab[i-1]+val));
        }

        return tab[nums.length];
}

//tabulation (iterative bottom up) only 2 variables
public int robTE(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int prev1 = 0;
        int prev2 = 0;
        for(int num: nums){
            int tmp = prev1;
            prev1=Math.max(prev2+num,prev1);
            prev2=tmp;
        }
        return prev1;
}



}
