class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int productPrefix = 1;
        int productSuffix = 1;

        for(int i = 0; i < n; i++) {
            productPrefix *= nums[i];
            prefix[i] = productPrefix;

            productSuffix *= nums[n - 1 - i];
            suffix[n - 1 - i] =  productSuffix;
        }

        for(int i = 0; i < n; i++) {
            int prefixValue = 1;
            if(i > 0) prefixValue = prefix[i - 1];
            int suffixValue = 1;
            if(i < n - 1) suffixValue = suffix[i + 1];

            result[i] = prefixValue * suffixValue;
        }

        return result;
    }
}  
