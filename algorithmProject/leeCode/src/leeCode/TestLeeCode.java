package leeCode;


import com.sun.deploy.util.StringUtils;

import java.util.*;

public class TestLeeCode {
    public static void rotate1(int[] nums, int k) {
        int[] num = new int[]{1,2,3,4,5,6,7};
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];

        }
        System.arraycopy(newArr, 0, nums, 0, n);

    }

    //    public static void main(String[] args) {
////        System.out.println(2%5);
////        System.out.println(3%8);
////        System.out.println(3%7);
////        System.out.println(6%5);
//        int[] num = new int[]{1,2,3,4,5,6,7};
//        TestLeeCode.rotate(num,3);
//
//    }
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
    public void replaceSpace(){

    }

//    public static void main(String[] args) {
////        String s  =  "we are happy";
////        System.out.println(s.replaceAll("\\s+","%20"));
////
////        int[] nums = new int[]{1,2,3,4,5};
////        System.out.println(nums.length/2);
//
//    }

    //二分查找
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int min;
        while (left<=right){
            min = (left+right)/2;
            if(nums[min]==target){
                return min;
            }else if(nums[min]>target){
                right = min -1;
            }else{
                left = min-1;
            }
        }
        return -1;
    }
    //搜索插入位置
    public static int searchInsert(int[] nums, int target) {
        int left =0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    //有序数组的平方
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
//        for (int i = 0;i<nums.length;i++){
//            ans[i]=nums[i]*nums[i];
//        }
//        Arrays.sort(ans);
        return ans;
    }
    //旋转数组
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];

        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /*我们以 n=7n=7，k=3k=3 为例进行如下展示：*/
    //操作	                    结果
    //原始数组	                1~2~3~4~5~6~7
    //翻转所有元素	            7~6~5~4~3~2~1
    //翻转 [0, k%n - 1]区间的元素	5~6~7~4~3~2~1
    //翻转 [k%n, n - 1]区间的元素	5~6~7~1~2~3~4

    //旋转数组-进阶
    public void rotates(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
    //    public int[] reversePrint(ListNode head) {
//
//    }
    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
    //输入: [0,1,0,3,12]
    //输出: [1,3,12,0,0]
    public static void main(String[] args) {
//        int[] nums = new int[]{0,1,0,3,12};
//        moveZeroes(nums);
        // char[] s = {'h','e','l','l','o'};
//        String s = "Let's take LeetCode contest";
//        //reverseWords(s);
//        System.out.println(reverseWordsjinjie(s));
        String s = "abcabcab";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    //abcabcab     pwwkew
    public static int lengthOfLongestSubstring1(String s) {
        int answer = 0;
        Set set = new HashSet();
        for (int i = 0;i<s.length();i++){
            for (int y = i;y<s.length();y++){
                char an = s.charAt(y);
                boolean add = set.add(an);
                if(!add){
                    if(y-i>answer) {
                        answer = y-i;
                    }
                    break;
                }
            }
            set.clear();
        }

        return answer;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

//        public ListNode(int i, int i1, int i2, int i3, int i4, int i5) {
//        }
    }
    public static ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    //反转字符串中的单词 III -- 进阶方法
    public static String reverseWordsjinjie(String s){
        StringBuffer answer = new StringBuffer();
        int i = 0;
        while(i<s.length()){
            int start = i;
            while (i<s.length()&&s.charAt(i)!= ' '){
                i++;
            }
            for (int x = start;x<i;x++){
                answer.append(s.charAt(start+i-1-x));
            }
            answer.append(" ");
            i++;
        }
        return String.valueOf(answer);
    }
    //反转字符串中的单词 III -- 耗时方法
    public static String reverseWords(String s) {
        String answere = new String();
        String[] ss = s.split(" ");
        for(int i = 0;i<ss.length;i++){
            char[] c = ss[i].toCharArray();
            reverseString(c);
            String s1 = String.valueOf(c);
            answere += " " +s1;
            System.out.println(answere);
        }
        return answere.trim();
    }
    //反转字符数组
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left < right){
            swap(s,left,right);
            left ++;
            right --;
        }

    }
    public static void swap(char[] s,int left,int right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
    public static void moveZeroes(int[] nums){
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n){
            if(nums[right]!=0){
                swap(nums,left,right);
                left ++;
            }
            right ++;
        }
    }
    public static void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}




