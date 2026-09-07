class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        for(int i=0; i<words.length; i++){
            char ch = pattern.charAt(i);
            String str = words[i];
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(str)){
                    return false;
                }
            }
            else if(map.containsValue(str)){
                return false;
            }
            else{
                map.put(ch, str);
            }
        }
        return true;
    }
}