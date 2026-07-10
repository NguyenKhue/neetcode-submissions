class Solution {
    public int maxArea(int[] heights) {
        int max = 0;

        int i = 0;
        int j = heights.length - 1;

        while(i < j) {
            int area = Math.min(heights[i], heights[j]) * (j - i);
            max = Math.max(max, area);

            if(heights[i] >= heights[j]) j--;
            else i++;
        }

        return max;
    }
}
