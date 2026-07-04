class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();

        for(String s : strs) {
            String sorts = sortString(s);
            System.out.println(sorts);
            if(maps.containsKey(sorts)) {
                maps.get(sorts).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                maps.put(sortString(s), list);
            }
        }

        List<List<String>> results = new ArrayList<>();

        maps.forEach ( (k, v) -> {
                results.add(v);
            }  
        );

        return results;
    }

    public String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
