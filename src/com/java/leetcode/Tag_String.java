package com.java.leetcode;

import java.util.*;

public class Tag_String {

    public String replaceSpace(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                s = s.substring(0, i) + "%20" + s.substring(i + 1, s.length());
            }
        }
        return s;
    }

    public int firstUniqChar(String s) {
        if (s.length() == 1) return 0;
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hm.get(ch) == null) {
                hm.put(ch, 1);
            } else {
                hm.put(ch, hm.get(ch) + 1);
            }
        }
        for (char ch : hm.keySet()) {
            if (hm.get(ch) == 1) {
                return s.indexOf(ch);
            }
        }
        return -1;
    }

    public int countSegments(String s) {
        return s.split(" ").length;
    }

    // id 443
    public int compress(char[] chars) {
        if (chars.length == 0) return 0;
        if (chars.length == 1) return 2;
        List<List<Character>> arr = new ArrayList<>();
        List<Character> tmp = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (i != 0) {
                if (tmp.get(tmp.size() - 1) == chars[i]) {
                    tmp.add(chars[i]);
                } else {
                    List<Character> copy = new ArrayList<>(tmp);
                    arr.add(copy);
                    tmp.clear();
                    tmp.add(chars[i]);
                }
            } else {
                tmp.add(chars[i]);
            }
        }
        arr.add(tmp);
        char[] res = new char[2 * arr.size()];
        int i = 0;
        for (List<Character> l : arr) {
            res[i] = l.get(0);
            String num = String.valueOf(l.size());
            char[] tmpNum = num.toCharArray();
            res[i + 1] = tmpNum[0];
            i += 2;
        }
        chars = res;
        return chars.length;
    }

    public boolean repeatedSubstringPattern(String s) {
        return false;
    }

}
