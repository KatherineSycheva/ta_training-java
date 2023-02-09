package com.epam.training.ekaterina_sycheva.java_basics.validations_color_code.words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {

    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (words != null && sample != null && !sample.isEmpty()) {
            int k = 0;
            for (String word : words) {
                if (word.strip().equalsIgnoreCase(sample.strip())) {
                    k++;
                }
            }
            return k;
        }
        return 0;
    }

    public static String[] splitWords(String text) {
        if (text != null && !text.isBlank()) {
            String regex = "[,.;: ?!]+";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(text);
            if (!m.matches()){
                String [] split_arr = text.strip().split(regex);
                ArrayList <String> res = new ArrayList<>();
                for (String word : split_arr) {
                    if (!word.isBlank()) res.add(word);
                }
                return res.toArray(new String[res.size()]);
            }

        }
        return null;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null) return null;
        if (path.isBlank()) return null;
        String unixreg = "^(~?/?\\.{0,2}/?)(([\\w \\.]+/)+)?(([\\w \\.]+)?)";
        String winreg = "^((C:\\\\)?(User)?\\\\?\\.{0,2}\\\\?)((([\\w \\.]+)\\\\)+)?((([\\w \\.]+))+)?";
        if (!Pattern.matches(winreg, path) && !Pattern.matches(unixreg, path)) return null;
        if ((toWin && Pattern.matches(winreg, path)) || (!toWin && Pattern.matches(unixreg, path))) {
            return path;
        } else if (toWin && !Pattern.matches(winreg, path)) {
            if (Pattern.matches("^~/root.*", path)) {
                path = path.replaceAll("^~/", "C:\\\\");
            } else if (Pattern.matches("^~.*", path)) {
                path = path.replaceAll("^~", "C:\\\\User");
            } else if (Pattern.matches("^/.*", path)) {
                path = path.replaceAll("^/", "C:\\\\");
            }
            path = path.replaceAll("/", "\\\\");
            return path;
        } else if (!toWin && Pattern.matches(winreg, path)) {
            if (Pattern.matches("^C:\\\\User.*", path)) {
                path = path.replaceAll("^C:\\\\User", "~");
            } else if (Pattern.matches("^C:\\\\.*", path)) {
                path = path.replaceAll("^C:\\\\", "/");
            }
            path = path.replaceAll("\\\\", "/");
            return path;
        }
        return null;
    }

    public static String joinWords(String[] words) {
        boolean blank = true;
        if (words == null) return null;
        else {
            for (String word : words) {
                if (!word.isBlank()) {
                    blank = false;
                    break;
                }
            }
        }
        if (blank) return null;
        String result;
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (String word: words) {
            if (!word.isBlank()) joiner.add(word);
        }
        result = joiner.toString();
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"", "", "", " 2 ", "3 4 5", ""};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[ 2 , 3 4 5]";
        System.out.println("Must be: " + expectedJoin);
    }
}