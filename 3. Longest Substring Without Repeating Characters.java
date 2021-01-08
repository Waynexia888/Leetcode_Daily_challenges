// time: O(n); space: O(256)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // two pointer (slidding window)
        // 1. maintain a sliding window [start, i], making sure that each char 
        //    in such window, its frequency is 1 (without repeating chars)
        // 2. when one char frequency > 1, there is repeating char, then move 
        //    pointer start to find the next window.
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        int[] map = new int[256];
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            while (map[s.charAt(i)] > 1) {
                map[s.charAt(start)]--;
                start++;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
////////////follow up///////
// 本题能否使用char[] map = new char[256]？？
// 不能，因为我们需要指针i来遍历string s；
////////////////////////////

// time: O(n); space: O(n), hashmap method as following:

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // maintains a sliding window [start...i]
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}

