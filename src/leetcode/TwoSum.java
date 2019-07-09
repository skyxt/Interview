package leetcode;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 *
 * @author skyxt
 * Created 2019-07-09 14:54
 * Email skyxt.yang@gmail.com
 */
public class TwoSum {
    /**
     * the first solution
     * @param nums
     * @param target
     * @return
     */
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1;j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    int[] ints = new int[2];
//                    ints[0] = nums[i];
//                    ints[1] = nums[j];
//                    return ints;
//                }
//            }
//        }
//        throw new IllegalArgumentException("no two sum solution");
//    }

    /**
     * the second solution
     * @param nums
     * @param target
     * @return
     */
//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target - nums[i])) {
//                return new int[]{i, map.get(target - nums[i])};
//            }
//        }
//        throw new IllegalArgumentException("no two sum solution");
//    }

    /**
     * the third solution
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(i, nums[i]);
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }
}
