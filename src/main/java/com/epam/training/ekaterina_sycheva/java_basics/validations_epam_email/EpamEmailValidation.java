package com.epam.training.ekaterina_sycheva.java_basics.validations_epam_email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null) return false;
        String regex = "^[A-za-z]+_[A-Za-z]+([1-9]+)?@epam.com";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}





