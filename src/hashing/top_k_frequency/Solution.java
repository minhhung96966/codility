package hashing.top_k_frequency;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                int currentValue = hashMap.get(nums[i]);
                hashMap.put(nums[i], currentValue + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            list.add(entry.getValue());
        }

        list.sort(Collections.reverseOrder());

        for (int value : list) {
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue().equals(value)) {
                    sortedMap.put(entry.getKey(), value);
                }
            }
        }
        System.out.println(sortedMap);


        int[] result = new int[k];
        int count = 1;

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            result[count - 1] = entry.getKey();

            if (count == k) {
                break;
            }

            count ++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(new Solution().topKFrequent(nums, 2)));


    }
}
