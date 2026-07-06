class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        int productPrefix = 1;
        int productSuffix = 1;

        for(int i = 0; i < nums.length; i++) {
            productPrefix *= nums[i];
            prefix[i] = productPrefix;

            productSuffix *= nums[nums.length - 1 - i];
            suffix[nums.length - 1 - i] =  productSuffix;
        }

        for(int i = 0; i < nums.length; i++) {
            int prefixValue = 1;
            if(i > 0) prefixValue = prefix[i - 1];
            int suffixValue = 1;
            if(i < nums.length - 1) suffixValue = suffix[i + 1];

            result[i] = prefixValue * suffixValue;
        }

        return result;
    }
}  
