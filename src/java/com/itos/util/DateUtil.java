/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author ITOS
 */
public class DateUtil {

    protected static Logger log = Logger.getLogger(DateUtil.class);
    /**
     * Check if input string is in "yyyyMM" date format
     *
     * @param date input string
     * @return <code>true</code> if input string is in "yyyyMM" date format,
     * <code>false</code> if input string is in other format
     */
    //HttpUtils.getEnvValue("COMMON_FORMAT_DATETIME_DDMMYYYY_DISPLAY")
    private static final String COMMON_FORMAT_DATETIME_DDMMYYYY_DISPLAY = "dd-MM-yyyy";
    public static final String COMMON_FORMAT_DATETIME_YYYYMMDD1 = "yyyy-MM-dd";
    public static final String COMMON_FORMAT_DATETIME_YYYYMMDD_FOR_FILENAME = "yyyy-MM-dd_HHmmss";
    public static final String COMMON_FORMAT_DATETIME_YYYYMMDD2 = "yyyy/MM/dd";
    public static final String COMMON_FORMAT_DATETIME_DDMMYYYY1 = "dd-MM-yyyy";
    public static final String COMMON_FORMAT_DATETIME_DDMMYYYY2 = "dd/MM/yyyy";
    //HttpUtils.getEnvValue("COMMON_FORMAT_DATETIME_DISPLAY")
    private static final String COMMON_FORMAT_DATETIME_DISPLAY = "dd/MM/yyyy HH:mm:ss";
    private static final String COMMON_FORMAT_DATETIME_DISPLAY2 = "dd-MM-yyyy HH:mm:ss";
    //HttpUtils.getEnvValue("COMMON_FORMAT_DATETIME_DB")
    private static final String COMMON_FORMAT_DATETIME_DB = "yyyy-MM-dd HH:mm:ss";
    //HttpUtils.getEnvValue("COMMON_FORMAT_DATETIME_DDMMYYYYHHMMSSS")
    private static final String COMMON_FORMAT_DATETIME_DDMMYYYYHHMMSSS = "ddMMyyyyHHmmssS";
    private static final String COMMON_FORMAT_DATETIME_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    private static final String COMMON_FORMAT_DATE_STATUS = "EEE, MMMMM d, yyyy";
    private static final String COMMON_FORMAT_TIME_STATUS = "hh:mm aaa";
    private static final SimpleDateFormat ddMMyyyy = new SimpleDateFormat(COMMON_FORMAT_DATETIME_DDMMYYYY_DISPLAY, new Locale("en", "EN"));
    private static final SimpleDateFormat ddMMyyyyHHmmss = new SimpleDateFormat(COMMON_FORMAT_DATETIME_DISPLAY, new Locale("en", "EN"));
    private static final SimpleDateFormat ddMMyyyyHHmmss2 = new SimpleDateFormat(COMMON_FORMAT_DATETIME_DISPLAY2, new Locale("en", "EN"));
    private static final SimpleDateFormat yyyyMMddHHMISS = new SimpleDateFormat(COMMON_FORMAT_DATETIME_DB, new Locale("en", "EN"));
    private static final SimpleDateFormat ddMMyyyyHHmmssS = new SimpleDateFormat(COMMON_FORMAT_DATETIME_DDMMYYYYHHMMSSS, new Locale("en", "EN"));
    private static final SimpleDateFormat yyyyMMddHHmmssFile = new SimpleDateFormat(COMMON_FORMAT_DATETIME_YYYYMMDDHHMMSS, new Locale("en", "EN"));
    private static final SimpleDateFormat DateStatus = new SimpleDateFormat(COMMON_FORMAT_DATE_STATUS, new Locale("en", "EN"));
    private static final SimpleDateFormat TimeStatus = new SimpleDateFormat(COMMON_FORMAT_TIME_STATUS, new Locale("en", "EN"));
    private static final SimpleDateFormat yyyyMMddTH = new SimpleDateFormat("yyyyMMdd", new Locale("th", "TH"));
    private static final SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd", new Locale("en", "EN"));
    private static final SimpleDateFormat yyyyMM = new SimpleDateFormat("yyyyMM", new Locale("en", "EN"));
    private static final String[] shortDay = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    private static final SimpleDateFormat HHmmss = new SimpleDateFormat("HHmmss", new Locale("en", "EN"));
    private static final SimpleDateFormat yyyy = new SimpleDateFormat("yyyy", new Locale("en", "EN"));
    private static final SimpleDateFormat yyyyMM_TH = new SimpleDateFormat("yyyyMM", new Locale("th", "TH"));
    private static final SimpleDateFormat yyyy_MM_ddTH = new SimpleDateFormat("yyyy-MM-dd", new Locale("th", "TH"));

    public static boolean isDateyyyyMM(String date) {
        if (StringUtils.isNumeric(date)) {
            if (date == null || date.length() != 6) {
                return false;
            }
        } else {
            //log.debug("Date is not Numeric");
            return false;
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyyMM", new Locale("en", "EN"));
        df.setLenient(false);
        try {
            //log.debug("DateUtil : isDateyyyyMM - " + date + " - Validate ...");
            if (!date.equalsIgnoreCase("")) {
                df.parse(date);
            }
            //log.debug("DateUtil : isDateyyyyMM - " + date + " - Pass");
            return true;
        } catch (Exception e) {
            //log.debug("DateUtil : isDateyyyyMM - " + date + " - Fail");
            log.error(e);
            return false;  //invalid format
        }
    }

    /**
     * Check if input string is in "yyyyMMdd" date format
     *
     * @param date input string
     * @return <code>true</code> if input string is in "yyyyMMdd" date format,
     * <code>false</code> if input string is in other format
     */
    public static boolean isDateyyyyMMdd(String date) {
        if (date == null || date.length() != 8) {
            return false;
        }
        try {
            Number n2 = new BigDecimal(date.substring(4, 6));
            int month = n2.intValue();
            //log.debug("month:" + month);
            if (month > 12 || month < 1) {
                return false;
            }
            Number n3 = new BigDecimal(date.substring(6));
            int day = n3.intValue();
            //log.debug("day:" + day);
            if (day >= 1 && day <= 31) {
                Number n1 = new BigDecimal(date.substring(0, 4));
                Calendar c = Calendar.getInstance(new Locale("en", "EN"));
                c.set(Calendar.YEAR, n1.intValue());
                c.set(Calendar.MONTH, month - 1);
                int max = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                if (day > max) {
                    //log.debug("Parse failed " + date);
                    return false;
                } else {
                    //log.debug("Parse success " + date);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            //log.error("Cannot parse " + date);
            log.error(e);
            return false;
        }
    }

    /**
     * Check if input string is in "yyyyMMdd" date format with delemiter
     *
     * @param date input string
     * @param delimiter delimiter of input string date
     * @return <code>true</code> if input string is in "yyyyMMdd" date format,
     * <code>false</code> if input string is in other format
     */
    public static boolean isDateyyyyMMdd(String date, char delimiter) {
        if (date == null || date.length() != 10) {
            return false;
        }
        String[] d = StringUtils.split(date, "" + delimiter);
        //log.debug("d[" + d.length + "]" + d[0]);
        try {
            Number n2 = new BigDecimal(d[1]);
            int month = n2.intValue();
            //log.debug("month=" + month);
            if (month > 12 || month < 1) {
                return false;
            }
            Number n3 = new BigDecimal(d[2]);
            int day = n3.intValue();
            //log.debug("day=" + day);
            if (day <= 31 && day >= 1) {
                Number year = new BigDecimal(d[0]);
                //log.debug("year=" + year.intValue());
                Calendar c = Calendar.getInstance(new Locale("en", "EN"));
                c.set(Calendar.YEAR, year.intValue());
                c.set(Calendar.MONTH, month - 1);
                //log.debug("c=" + c);
                int max = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                if (day > max) {
                    //log.debug("Invalid day " + date);
                    return false;
                } else {
                    //log.debug("Valid day " + date);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            //log.error("Cannot parse " + date);
            log.error(e);
            return false;
        }
    }

    /**
     * Check if input string is in "ddMMyyyy" date format with delemiter
     *
     * @param date input string
     * @param delimiter delimiter of input string date
     * @return <code>true</code> if input string is in "yyyyMMdd" date format,
     * <code>false</code> if input string is in other format
     */
    public static boolean isDateddMMyyyy(String date, char delimiter) {
        if (date == null || date.length() != 10) {
            return false;
        }
        String[] d = StringUtils.split(date, "" + delimiter);
        //log.debug("d[" + d.length + "]" + d[0]);
        try {
            Number n2 = new BigDecimal(d[1]);
            int month = n2.intValue();
            //log.debug("month=" + month);
            if (month > 12 || month < 1) {
                return false;
            }
            Number n3 = new BigDecimal(d[0]);
            int day = n3.intValue();
            //log.debug("day=" + day);
            if (day <= 31 && day >= 1) {
                Number year = new BigDecimal(d[2]);
                //log.debug("year=" + year.intValue());
                Calendar c = Calendar.getInstance(new Locale("en", "EN"));
                c.set(Calendar.YEAR, year.intValue());
                c.set(Calendar.MONTH, month - 1);
                //log.debug("c=" + c);
                int max = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                if (day > max) {
                    //log.debug("Invalid day " + date);
                    return false;
                } else {
                    //log.debug("Valid day " + date);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            //log.error("Cannot parse " + date);
            log.error(e);
            return false;
        }
    }

    /**
     * Check <code>dateFrom</code> and <code>dateTo</code> are invalid interval
     *
     * @param dateFrom begin date
     * @param dateTo end date
     * @return <code>true</code> if dates are valid interval, <code>false</code>
     * if dates are invalid interval
     */
    public static boolean checkIntervalDate(String dateFrom, String dateTo) {
        if ((dateFrom != null && !dateFrom.equals("") && StringUtils.isNumeric(dateFrom) && DateUtil.isDateyyyyMM(dateFrom)) && (dateTo != null && !dateTo.equals("") && StringUtils.isNumeric(dateTo) && DateUtil.isDateyyyyMM(dateTo))) {
            int packFrom = Integer.parseInt(dateFrom);
            int packTo = Integer.parseInt(dateTo);
            if (packFrom > packTo) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Convert "yyyyMM" format input string to <code>Date</code>
     *
     * @param yyyyMM input string
     * @return converted date, if format is not correct it will return
     * <code>null</code>
     */
    public static Date parseyyyyMM(String yyyyMM) {
        Date output = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMM", new Locale("en", "EN"));
        if (isDateyyyyMM(yyyyMM)) {
            try {
                output = df.parse(yyyyMM);
            } catch (Exception e) {
                log.error(e);
            }
        }
        return output;
    }

    /**
     * Convert "yyyyMMdd" format input string to <code>Date</code>
     *
     * @param yyyyMMdd input string
     * @return converted date, if format is not correct it will return
     * <code>null</code>
     */
    public static Date parseyyyyMMdd(String yyyyMMdd) {
        Date output = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd", new Locale("en", "EN"));
        if (isDateyyyyMMdd(yyyyMMdd)) {
            try {
                output = df.parse(yyyyMMdd);
            } catch (Exception e) {
                log.error(e, e);
            }
        }
        return output;
    }

    /**
     * Convert "yyyyMMdd" format with delimiter input string to
     * <code>Date</code>
     *
     * @param yyyyMMdd input string
     * @param delimiter delimiter of input string date
     * @return converted date, if format is not correct it will return
     * <code>null</code>
     */
    public static Date parseyyyyMMdd(String yyyyMMdd, char delimiter) {
        Date output = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy" + delimiter + "MM" + delimiter + "dd", new Locale("en", "EN"));
        if (isDateyyyyMMdd(yyyyMMdd, delimiter)) {
            try {
                output = df.parse(yyyyMMdd);
            } catch (Exception e) {
                log.error(e);
            }
        }
        return output;
    }

    /**
     * Convert date to "yyyyMM" format string
     *
     * @param date requested convert date
     * @return "yyyyMM" format string of <code>date</code>, <code>null</code> if
     * input <code>date</code> is <code>null</code>
     */
    public static String formatDateyyyyMM(Date date) {
        if (date != null) {
            return yyyyMM.format(date);
        }
        return null;
    }

    /**
     * Convert date to "yyyyMMdd" format string
     *
     * @param date requested convert date
     * @return "yyyyMMdd" format string of <code>date</code>, <code>null</code>
     * if input <code>date</code> is <code>null</code>
     */
    public static String formatDateddMMyyyy(Date date) {
        if (date != null) {
            return ddMMyyyy.format(date);
        }
        return "";
    }

    public static String formatDateddMMyyyyHHmmss(Date date) {
        if (date != null) {
            return ddMMyyyyHHmmss.format(date);
        }
        return "";
    }

    /**
     * Convert date to "yyyy/MM/dd HH:mm:ss" format string
     *
     * @param date requested convert date
     * @return "yyyy/MM/dd HH:mm:ss" format string of <code>date</code>,
     * <code>null</code> if input <code>date</code> is <code>null</code>
     */
    public static String formatDateyyyyMMddHHMISS(Date date) {
        if (date != null) {
            return yyyyMMddHHMISS.format(date);
        }
        return "";
    }

    public static String formatDateyyyyMMdd(Date date) {
        if (date != null) {
            return yyyy_MM_dd.format(date);
        }
        return "";
    }

    /**
     * Get short day of week by day number of week, 0 = Monday
     *
     * @param day day number of week
     * @return short day of week in string, <code>null</code> if
     * <code>day</code> is <code>null</code>
     */
    public static String getShortDayOfWeek(Integer day) {
        String dayStr = null;
        if (day != null) {
            dayStr = shortDay[day.intValue()];
            //log.debug("day=" + day + ":" + dayStr);
        }
        return dayStr;
    }

    /**
     * @see <code>isDateyyyyMMdd</code>
     */
    public static boolean checkFormatyyyyMMdd(String yyyyMMdd) {
        return isDateyyyyMMdd(yyyyMMdd);
        /*
         * Date output = null; SimpleDateFormat df = new
         * SimpleDateFormat("yyyyMMdd", new Locale("en","EN")); df.setLenient(
         * false ); try { if(!yyyyMMdd.equalsIgnoreCase("")){ output =
         * df.parse(yyyyMMdd); } return true; } catch(Exception e) { return
         * false; //invalid format }
         */
    }

    /**
     * @see <code>isDateyyyyMM</code>
     */
    public static boolean checkFormatyyyyMM(String yyyyMM) {
        /*
         * Date output = null; SimpleDateFormat df = new
         * SimpleDateFormat("yyyyMM", new Locale("en","EN")); df.setLenient(
         * false ); try { if(!yyyyMM.equalsIgnoreCase("")){ output =
         * df.parse(yyyyMM); } return true; } catch(Exception e) { return false;
         * //invalid format }
         */
        return isDateyyyyMM(yyyyMM);
    }

    /**
     * Check two dates are same month
     *
     * @param d1 first date
     * @param d2 second date
     * @return <code>true</code> if two input dates are in same month,
     * <code>false</code> if two input dates are different month
     */
    public static boolean equalsMonth(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance(new Locale("en", "EN"));
        c1.setTime(d1);
        Calendar c2 = Calendar.getInstance(new Locale("en", "EN"));
        c2.setTime(d2);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        if (year1 == year2 && month1 == month2) {
            return true;
        }
        return false;
    }

    /**
     * Get month <code>Date</code> from input <code>date</code>
     *
     * @param prodDate input date
     * @return month of <code>prodDate</code>
     */
    public static Date getMonth(Date prodDate) {
        Calendar c = Calendar.getInstance(new Locale("en", "EN"));
        c.setTime(prodDate);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * Calculate month interval between dates
     *
     * @param first first month
     * @param last last month
     * @return interval (from <CODE>last</CODE>) in month
     */
    public static int diffMonth(Date first, Date last) {
        if (first == null || last == null) {
            return -1;
        }

        long interval = last.getTime() - first.getTime();
        Date d3 = new Date(interval);
        Calendar c3 = Calendar.getInstance(new Locale("en", "EN"));
        c3.setTime(d3);

        int monthInterval = c3.get(Calendar.MONTH);
        return monthInterval;

    }

    public static Date getCurrentDate() {
        Date dt = new Date();
        try {
            dt = (Date) yyyyMMddHHMISS.parse(yyyyMMddHHMISS.format(dt));
        } catch (ParseException e) {
            log.error(e);
        }
        return dt;
    }

    public static java.sql.Date getCurrentDateSql() {
        return new java.sql.Date(getCurrentDate().getTime());
    }

    public static java.sql.Date getDateSql(Date value) {
        return null == value ? null : new java.sql.Date(value.getTime());
    }

    public static java.sql.Timestamp getTimestamp(Date value) {
        return null == value ? null : new java.sql.Timestamp(value.getTime());
    }

    public static String getCurrentDateTimeString() {
        return ddMMyyyyHHmmssS.format(getCurrentDate());
    }

    public static String getCurrentDateTimeStringFile() {
        return yyyyMMddHHmmssFile.format(getCurrentDate());
    }

    public static String getDateddMMyyyyHHmmss() {
        Date dt = new Date();
        if (dt != null) {
            return ddMMyyyyHHmmss2.format(dt);
        }
        return null;
    }

    public static String ddMMyyyyToyyyyMMddd(String ddMMyyyy) {

        String yyyyMMddd[] = ddMMyyyy.split("-");
        return yyyyMMddd[2] + "-" + yyyyMMddd[1] + "-" + yyyyMMddd[0];
    }

    /**
     * Get current date in "yyyy" format string
     *
     * @return current date in "yyyy" format string
     */
    public static String getCurrentyyyy() {
        Calendar c = Calendar.getInstance(new Locale("en", "EN"));
        return yyyy.format(c.getTime());
    }

    /**
     * Get current date in "yyyyMMdd" format string
     *
     * @return current date in "yyyyMMdd" format string
     */
    public static String getCurrentyyyyMMdd() {
        Calendar c = Calendar.getInstance(new Locale("en", "EN"));
        return yyyyMMddTH.format(c.getTime());
    }

    /**
     * Get current date in "yyyyMMdd" format string
     *
     * @return current date in "yyyyMMdd" format string
     */
    public static String getCurrentHHmmss() {
        Calendar c = Calendar.getInstance(new Locale("en", "EN"));
        return HHmmss.format(c.getTime());
    }

    /**
     * Get current date in "date" format string
     *
     * @return current date in "EEE, MMMMM d, yyyy" format string
     */
    public static String getDateStatus(Date d1) {
        try {
            return DateStatus.format(d1);
        } catch (Exception e) {
            log.error(e);
            return "";
        }
    }

    /**
     * Get current date in "String date" format string
     *
     * @return current date in "hh:mm aaa" format string
     */
    public static String getTimeStatus(Date d1) {
        try {
            return TimeStatus.format(d1);
        } catch (Exception e) {
            log.error(e);
            return "";
        }
    }

    public static int DateDiff(Calendar pStartDate, Calendar pEndDate) throws Exception {
        int dayDiff = 0;
        try {
            GregorianCalendar gc1 = new GregorianCalendar(pStartDate.get(Calendar.YEAR), pStartDate.get(Calendar.MONTH), pStartDate.get(Calendar.DATE), pStartDate.get(Calendar.HOUR), pStartDate.get(Calendar.MINUTE), pStartDate.get(Calendar.SECOND));
            GregorianCalendar gc2 = new GregorianCalendar(pEndDate.get(Calendar.YEAR), pEndDate.get(Calendar.MONTH), pEndDate.get(Calendar.DATE), pEndDate.get(Calendar.HOUR), pEndDate.get(Calendar.MINUTE), pEndDate.get(Calendar.SECOND));
            dayDiff = (int) ((gc1.getTimeInMillis() - gc2.getTimeInMillis()) / (24 * 60 * 60 * 1000));
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
        return dayDiff;
    }

    public static Calendar setCalendar(String str_date, String format) {
        DateFormat formatter;
        Date date = null;
        Calendar cal = Calendar.getInstance(new Locale("en", "EN"));
        try {
            formatter = new SimpleDateFormat(format);
            date = (Date) formatter.parse(str_date);
            cal.setTime(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            log.error(e);
        }
        return cal;
    }

    public static Date getCurrentDateOnMonthControl(int day, int setMonth, String control) {
        Calendar cal = Calendar.getInstance(new Locale("en", "EN"));
        //Date dt = new Date();
        try {
            cal.set(Calendar.DATE, day);
            if ("-".equals(control)) {
                cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - setMonth);
            } else {
                cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + setMonth);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return cal.getTime();
    }

    /**
     * Get current date in "yyyyMM" format string @Thai
     *
     * @return current date in "yyyyMM" format string @Thai
     */
    public static String getCurrentyyyyMMTH() {
        Calendar c = Calendar.getInstance(new Locale("en", "EN"));
        return yyyyMM_TH.format(c.getTime());
    }

    /**
     * Get current date in "yyyy-MM-dd" format string @Thai
     *
     * @return current date in "yyyy-MM-dd" format string @Thai
     */
    public static String getCurrentyyyy_MM_ddTH() {
        Calendar c = Calendar.getInstance(new Locale("en", "EN"));
        return yyyy_MM_ddTH.format(c.getTime());
    }

    public static String getCurrentyyyyMMddTH() {
        Calendar c = Calendar.getInstance(new Locale("en", "EN"));
        return yyyyMMddTH.format(c.getTime());
    }

    public static String DateFolder() {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", new Locale("en", "EN"));
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String datenewformat = formatter.format(today);
        return datenewformat;
    }

    public static String TimeFolder() {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hhmmss", new Locale("en", "EN"));
        //SimpleDateFormat formatter = new SimpleDateFormat("hhmmss");
        String datenewformat = formatter.format(today);
        return datenewformat;
    }

    public static String TimeAllFolder() {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hhmmssSSS", new Locale("en", "EN"));
        //SimpleDateFormat formatter = new SimpleDateFormat("hhmmssSSS");
        String datenewformat = formatter.format(today);
        return datenewformat;
    }

    public static String ConvertFormat(String dateString, String stringDateFormatFrom, String stringDateFormatTo) {
        Date date = null;
        try {
            date = new SimpleDateFormat(stringDateFormatFrom).parse(dateString);
        } catch (ParseException ex) {
            log.error(ex);
        }
        String dateString2 = new SimpleDateFormat(stringDateFormatTo).format(date);
        return dateString2;
    }
    
    public static Date String2Date(String dateString, String stringDateFormat) {
        Date date = null;
        try {
            date = new SimpleDateFormat(stringDateFormat).parse(dateString);
        } catch (ParseException ex) {
            log.error(ex);
        }
        return date;
    }
    
    public static String GetDateTimeToGenerateFileName(String stringFormat) {
        String dateString2 = new SimpleDateFormat(stringFormat, new Locale("en", "EN")).format(new Date());
        return dateString2;
    }
}
