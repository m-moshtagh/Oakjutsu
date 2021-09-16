package com.dogigiri.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateChecker {
    // Here we want to check if a date is in range of 1900 till 2000.
    public static boolean isBalanced(String date) {
        Pattern pattern = Pattern.compile("^((19|(2[0-9]))[0-9]{2})-(0[0-9]|1[012])-([012][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(date);
        return matcher.find();
    }
}
