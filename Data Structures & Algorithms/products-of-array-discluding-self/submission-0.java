class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        Map<Integer, Integer> prefix = new HashMap<>();

        int product = 1;

        for(int i = 0; i < nums.length; i++) {
            product *= nums[i];
            prefix.put(i, product);
        }

        for(int i = 0; i < nums.length - 1; i++) {
            int prefixI = 1;
            if(i > 0) prefixI = prefix.get(i - 1);

            for(int j = i + 1; j < nums.length; j++) {
                prefixI *= nums[j];
            }

            result[i] = prefixI;
        }

        result[nums.length - 1] = prefix.get(nums.length - 2);

        return result;
    }
}  
