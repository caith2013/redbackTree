package com.optimum;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLen = 0;
        int start = 0; // left side of sliding window

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (lastSeen.containsKey(c) && lastSeen.get(c) >= start) {
                start = lastSeen.get(c) + 1;
            }

            lastSeen.put(c, i);
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
       // System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
       // System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        //System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring("avabcbb"));
    }
}

