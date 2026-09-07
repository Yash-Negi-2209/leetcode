class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            freq[ch-'a']--;
        }
        for (int count : freq){
            if (count != 0){
                return false;
            }
        }
        return true;

        // if (s.length() != t.length()){
        //     return false;
        // }
        // Map<Character, Integer> map = new HashMap<>();
        // for(int i=0; i<s.length(); i++){
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        // }
        // for(int i=0; i<t.length(); i++){
        //     char ch = t.charAt(i);
        //     if(map.containsKey(ch)){
        //         int count = map.get(ch);
        //         if (count==1){
        //             map.remove(ch);
        //         }
        //         else {
        //             count--;
        //             map.remove(ch);
        //             map.put(ch, count);
        //         }
        //     }
        // }
        // return map.isEmpty()? true : false;

        // --------------------------------------------------------------------------------

        // Or simply we can use the sort function:
        // char ch1[] = s.toCharArray();
        // char ch2[] = t.toCharArray();
        // Arrays.sort(ch1);
        // Arrays.sort(ch2);
        // return Arrays.equals(ch1, ch2);
    }
}