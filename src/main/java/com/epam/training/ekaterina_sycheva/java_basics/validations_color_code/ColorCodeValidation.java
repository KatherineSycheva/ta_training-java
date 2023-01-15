package com.epam.training.ekaterina_sycheva.java_basics.validations_color_code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color == null) return false;
        String regex = "^#([A-Fa-f0-9]{3})([A-Fa-f0-9]{3})?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(color);
        return matcher.matches();
    }
}





