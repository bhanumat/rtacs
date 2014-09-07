/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.util;

import java.util.Date;

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
}
