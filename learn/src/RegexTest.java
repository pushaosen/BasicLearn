/*
 * @projectName msyp
 * @package com.thunisoft.lxfz.util
 * @className com.thunisoft.lxfz.util.RegexTest
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
import java.util.regex.Pattern;

/**
 * RegexTest
 * @description 正则表达式测试
 * @author pushaosen
 * @version 1.1.0
 */
public class RegexTest {

//    private static Pattern patternSpecialChar = Pattern.compile("(\\%27|\\'|\"|\\+)", Pattern.CASE_INSENSITIVE);
    private static Pattern patternSpecialChar = Pattern.compile("'", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        if (patternSpecialChar.matcher("'").matches()){
            System.out.println("测试通过了");
        }
    }
}
