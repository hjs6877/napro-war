package com.soom.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-20 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class StringUtil  extends StringUtils {
    public final static String SEPERATOR_AMP = "&";
    public final static String SEPERATOR_COMMA = ",";
    public final static String SEPERATOR_UNDERBAR = "_";
    public final static String SEPERATOR_HYPHEN = "-";

    public static String nullToWhiteSpace(String value) {
        if (value == null) {
            value = "";
        }

        return value;
    }

    public static String whiteSpaceToNull(String value) {
        if (value != null) {
            if (value.equals("") || value.isEmpty()) {
                value = null;
            }
        }


        return value;
    }

    public static String removeSpecialCharacter(String str) {
        String result = StringUtil.nullToWhiteSpace(str).replaceAll("[\\+\\*\\^%\\$#@&!~`=\"\\?><,\\./\\\\]+", "");

        return result;
    }

    public static String[] splitBySeperator(String str, String seperator) {
        String[] splitedStr = str.split(seperator);
        return splitedStr;
    }

    /**
     * String 앞 또는 뒤를 특정문자로 지정한 길이만큼 채워주는 함수    <BR>
     * (예) pad("1234","0", 6, 1) --> "123400"   <BR>
     *
     * @param src    Source string
     * @param pad    pad string
     * @param totLen total length
     * @param mode   앞/뒤 구분 (-1:front, 1:back)
     * @return String
     */
    public static String pad(String src, String pad, int totLen, int mode) {
        String paddedString = "";
        if (src == null) return "";
        int srcLen = src.length();
        if ((totLen < 1) || (srcLen >= totLen)) return src;
        for (int i = 0; i < (totLen - srcLen); i++) {
            paddedString += pad;
        }
        if (mode == -1)
            paddedString += src; // front padding
        else
            paddedString = src + paddedString; //back padding
        return paddedString;
    }
}
