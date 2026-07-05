class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0) return "";
 
        List<String> arr = new ArrayList<>();

        for(String s : strs) {
            if(s.equals("")) {
                arr.add("ô");
            } else arr.add(s);
        }

        return String.join("ê", arr);
    }

    public List<String> decode(String str) {
        List<String> arr = new ArrayList<>();

        if(str.equals("")) return arr;

        String[] arrs = str.split("ê");

        for(String s : arrs) {
            if(s.equals("ô")) {
                arr.add("");
            } else arr.add(s);
        }

        return arr;
    }
}
