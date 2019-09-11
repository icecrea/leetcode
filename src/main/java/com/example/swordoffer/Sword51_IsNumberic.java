package com.example.swordoffer;

import org.junit.Test;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Sword51_IsNumberic {
    public boolean isNumeric(char[] str) {
        int eIndex = -1;
        int minusIndex = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '0' && i == 0) {
                return false;
            }
            if (str[i] >= '0' && str[i] <= '9') {
                continue;
            }
            if (str[i] == '+' || str[i] == '-') {
                if (i == 0) {
                    continue;
                } else if (eIndex != -1 && i == eIndex + 1) {
                    continue;
                }
                return false;
            }
            if (str[i] == '.') {
                if (minusIndex != -1) {
                    return false;
                }
                if (eIndex != -1 && i > eIndex) {
                    return false;
                }
                minusIndex = i;
                continue;
            }

            if (str[i] == 'E' || str[i] == 'e') {
                if (eIndex != -1) {
                    return false;
                }
                if (i == str.length - 1) {
                    return false;
                }
                eIndex = i;
                continue;
            }
            if (str[i] < '0' || str[i] > '9') {
                return false;
            }

        }
        return true;

    }


    /**
     * 正则表达式
     * @param str
     * @return
     */
    public boolean isNumeric2(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }


    @Test
    public void test() {
        String s = "123.45e+6";
        s = "12e+5.4";
        char[] charArr = s.toCharArray();
        isNumeric(charArr);
    }

}
