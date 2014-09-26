/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.util;

import java.util.Date;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author ITOS
 */
public class MiscUtil {

    public static String getNull(String value) {
        if (null == value || "null".equals(value) || value.isEmpty()) {
            return "";
        }
        return value.trim();
    }

    public static int getInt(String value) {
        if (null == value || "null".equals(value) || value.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    public static char getChar(String value) {
        if (null == value || "null".equals(value) || value.isEmpty()) {
            return ' ';
        }
        return value.charAt(0);
    }

    public static Date getDate(String value, String stringFormat) {
        if (null == value || "null".equals(value) || value.isEmpty()) {
            return null;
        }
        return DateUtil.String2Date(value, stringFormat);
    }

    public static String getParameter(String value) {
        String parameter = "";
        value = value.trim();
        int point = value.indexOf(".");
        parameter = value.substring(point + 1, value.length());
        if (value.contains("_")) {
            String str = WordUtils.capitalizeFully(parameter, '_');
            String str2 = str.replaceAll("_", "");
            String str3 = str2.substring(0, 1).toLowerCase() + str2.substring(1, str2.length());
            return str3;
        } else {
            return parameter;
        }
    }
}
