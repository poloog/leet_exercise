package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    HashMap<Integer,Integer> map = new HashMap<>();
    Random rand = new Random();
    int[] nums = new int[200010];
    int idx = 0;
    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        nums[idx] = val;
        map.put(val, idx);
        idx++;
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        map.remove(val);
        nums[index] = nums[idx-1];
        map.put(nums[index],index);
        idx--;
        return true;
    }

    public int getRandom() {
        return nums[rand.nextInt(idx)];
    }
}

class test{
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.remove(0);
        boolean param_2 = obj.remove(0);
        boolean param_3 = obj.insert(0);
        int param_4 = obj.getRandom();
        boolean param_5 = obj.remove(0);
        boolean param_6 = obj.insert(0);

    }
}

