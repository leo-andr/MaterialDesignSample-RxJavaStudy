package demo.test.com.testdemo.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringUntil {

    // 验证是否是手机号
    public static boolean isMobileNum(String mobiles) {
//		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
//		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(14[57])|(17[0])|(17[7])|(18[0,0-9]))\\d{8}$");
        Pattern p = Pattern.compile("^1([3,9][0-9]|4[579]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * Description 邮箱
     */
    public static boolean isEmail(String aEmail) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)"
                + "|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(aEmail);
        return m.matches();
    }

    /**
     * Description QQ
     */
    public static boolean isQQNum(String qqNum) {
        String str = "^[1-9]\\d{4,14}$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(qqNum);
        return m.matches();
    }

    /**
     * Description 网址
     */
    public static boolean isWebsite(String website) {
//		String str = "^([a-zA-z]+://[^s]*)|([w,W]{3}+.[^s]*)$";
        String str = "^(?=^.{3,255}$)[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(website);
        return m.matches();
    }

    /**
     * Description 传真
     */
    public static boolean isMobile(String mobile) {
        String str = "^[+]{0,1}(\\d){1,3}[ ]?([-]?((\\d)|[ ]){1,12})+$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    /**
     * 座机号正则判断
     */
    public static boolean isPhone(String phone) {
        String str = "^\\d{3}-\\d{8}|\\d{4}-\\d{7}|\\d{11}$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * 验证一个字符是否是汉字
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 验证一个字符串中是否含有汉字
     */
    public static boolean isCNMark(String str) {

        char[] cs = str.toCharArray();

        ArrayList<Boolean> list = new ArrayList<Boolean>();

        for (int i = 0; i < cs.length; i++) {
            if (isChinese(cs[i])) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        if (list.contains(false)) {
            return false;

        } else {
            return true;
        }
    }

    /**
     * 字符串编码转换的实现方法
     *
     * @param str        待转换编码的字符串
     * @param oldCharset 原编码
     * @param newCharset 目标编码
     * @throws UnsupportedEncodingException
     * @return"ISO-8859-1", "utf-8"
     */
    public static String changeCharset(String str) throws UnsupportedEncodingException {
        if (str != null && !str.equals("") && !str.equals("null")) {
            byte[] bs = str.getBytes("ISO-8859-1");
            return new String(bs, "utf-8");
        }
        return "";
    }

    public static String changeCharsetISO(String str) throws UnsupportedEncodingException {
        if (str != null && !str.equals("") && !str.equals("null")) {
            byte[] bs = str.getBytes("utf-8");
            return new String(bs, "ISO-8859-1");
        }
        return "";
    }

    /**
     * 去掉空格 换行 反斜等等
     *
     * @param text
     * @return
     */
    public static String trimAll(String text) {
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(text);
        return m.replaceAll("");

    }

    /**
     * 检查字符串图片是否null
     *
     * @param text
     * @return
     */
    public static boolean isEmptyImage(String text) {
        if (text == null || text.equals("") || text.equals("/assets/1_mini.jpg"))
            return true;
        return false;

    }

    /**
     * 检查字符串是否null
     *
     * @param text
     * @return
     */
    public static boolean isEmpty(String text) {
        if (text == null || text.equals("") || text.equals("null"))
            return true;
        return false;

    }

    /**
     * 税务识别号正则判断
     */
    public static boolean isTfn(String num) {//正则校验为15或者17或者18或者20位字母、数字组成
        String str = "^[a-zA-Z0-9]{15,20}$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(num);
        return m.matches();
    }

    /**
     * 输入格式
     *
     * @param str 不允许输入空格
     */
    public static String stringFilterSpace(String str) throws PatternSyntaxException {
        // 只允许字母和数字
//        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        String regEx = "";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    /**
     * 输入格式
     *
     * @param str 不允许特殊字符 只允许字母和数字
     */
    public static String stringFilterLetterNumber(String str) throws PatternSyntaxException {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    /**
     * 保留小数点后的两位小数
     *
     * @param number
     * @return
     */
    public static boolean isOnlyPointTwoNumber(String number) {
        Pattern pattern = Pattern.compile("^\\d+\\.?\\d{0,2}$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    /**
     *  是否是表情
     * @param codePoint
     * @return boolean
     */
    public static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));

    }

}
