/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.util;

import java.text.ParseException;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;

/**
 *
 * @author bhanumat.w
 */
public class TestDateTime {
    public static void main (String ...args) throws ParseException {
        Date d = DateUtils.parseDate("09/27/2014", "dd/M/yyyy");
        System.out.println(d);
    }
}
