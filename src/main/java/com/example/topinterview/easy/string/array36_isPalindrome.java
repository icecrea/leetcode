package com.example.topinterview.easy.string;

/**
 * @description: 验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * @author: icecrea
 * @create: 2019-03-12 19:54
 **/
public class array36_isPalindrome {
    /**
     * 用java自带的方法解决 注意大小写，非数字字母的过滤，以及equals使用string类型的才有重写.
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        return s.equalsIgnoreCase(sb.reverse().toString());
    }

    /**
     * 上面方法更简单的处理 对[^A-Za-z0-9] 进行替换为空，然后反转比较
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

    /**
     * 头指针和尾指针依次比较。注意空串过滤，以及字母数字的判断
     * @param s
     * @return
     */
    public boolean isPalindrome3(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}
