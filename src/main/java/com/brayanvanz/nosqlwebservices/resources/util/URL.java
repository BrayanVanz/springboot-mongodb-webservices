package com.brayanvanz.nosqlwebservices.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class URL {

    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static LocalDate convertDate(String text, LocalDate defaultValue) {
        try {
            return LocalDate.parse(text);
        } catch (DateTimeParseException e) {
            return defaultValue;
        }
    }
}
