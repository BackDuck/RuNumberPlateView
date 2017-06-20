package com.example.nurshat.runumberplateview;

import java.util.regex.Pattern;

/**
 * Created by Nurshat on 17.05.2017.
 */

public class ETFilter {
    private Pattern[] temp;
    public static int symbolCount;

    public ETFilter(String temp) {
        parseTemp(temp.toUpperCase());
        symbolCount = temp.length();
    }

    private void parseTemp(String temp) {
        this.temp = new Pattern[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            switch (temp.charAt(i)) {
                case 'K':
                    this.temp[i] = Pattern.compile("^[АВЕКМНОРСТУХавекмнорстух]$");
                    break;
                case 'L':
                    this.temp[i] = Pattern.compile("^[a-zA-Z]$");
                    break;
                case 'N':
                    this.temp[i] = Pattern.compile("^[0-9]$");
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }
    }

    public String filter(CharSequence c) {
        String result = "";
        if (c.length() <= temp.length) {
            for (int i = 0; i < c.length(); i++) {
                if (temp[i].matcher(String.valueOf(c.charAt(i))).matches()) {
                    result += c.charAt(i);
                } else {
                    break;
                }
            }
        } else {
            result = String.valueOf(c.subSequence(0, temp.length));
        }
        return result;
    }

}
