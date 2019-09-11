package com.example.swordoffer;

import java.util.HashMap;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Sword51_IsNumberic {
    public boolean isNumeric(char[] str) {
        int eIndex = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '0' && i == 0) {
                return false;
            }
            if (str[i] >= '0' && str[i] <= '9') {
                continue;
            }
            if (str[i] == '+' || str[i] == '-') {
                if (i != 0) {
                    return false;
                }
            }
            if (str[i] == 'E' || str[i] == 'e') {
                if (eIndex != -1) {
                    return false;
                }
                if (i == str.length - 1) {
                    return false;
                }
                eIndex = i;
            }



        }

    }
}
