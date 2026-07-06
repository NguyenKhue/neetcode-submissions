class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        Map<Integer, Integer> prefix = new HashMap<>();
        Map<Integer, Integer> suffix = new HashMap<>();

        int productPrefix = 1;
        int productSuffix = 1;

        for(int i = 0; i < nums.length; i++) {
            productPrefix *= nums[i];
            prefix.put(i, productPrefix);

            productSuffix *= nums[nums.length - 1 - i];
            suffix.put(nums.length - 1 - i, productSuffix);
        }

        for(int i = 0; i < nums.length; i++) {
            int prefixValue = 1;
            if(i > 0) prefixValue = prefix.get(i - 1);
            int suffixValue = 1;
            if(i < nums.length - 1) suffixValue = suffix.get(i + 1);

            result[i] = prefixValue * suffixValue;
        }

        return result;
    }
}  
