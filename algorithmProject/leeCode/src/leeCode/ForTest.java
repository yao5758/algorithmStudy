package leeCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ForTest {
    public static void main(String[] args) {
//        char[]  s= {'h','e','l','l','o'};
//        //char[] s = [];
//        int n = s.length;
//        for (int left = 0, right = n - 1; left < right; ++left, --right) {
//            char tmp = s[left];
//            s[left] = s[right];
//            s[right] = tmp;
//        }
//        System.out.println(s);

    }

    /*
    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
        示例：
        s = "leetcode"
        返回 0
        s = "loveleetcode"
        返回 2
     */
    @Test
    public void firstUniqChar() {
        String s = "loveleetcode";
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            System.out.println(frequency);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                System.out.println(i);
            }
        }

    }
    /*
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
示例1:
输入: s = "anagram", t = "nagaram"
输出: true
示例 2:
输入: s = "rat", t = "car"
输出: false
     */
    @Test
    public void isAnagram() {
        String s = "anagram", t = "nagaram";
       /* //特判，长度不同必定不是
        if (s.length()!=t.length()) return false;
        //两个字符串排序后是否相等
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1,array2);*/
        int[] ints = new int[26];
        // s全部存到哈希表中
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i)-'a']++;


            System.out.println(s.charAt(i)-'a');
            System.out.println("--------------------");
            System.out.println(ints[s.charAt(i)-'a']);
            System.out.println();

        }


    }

}
