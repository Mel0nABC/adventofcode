package com.ejemplo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(mul)\\((\\d+),(\\d+)\\)|(hola)| ");
        Matcher matcher = pattern.matcher("hola que haces mul(5,4) vale");

        while (matcher.find()) {

            if (matcher.group().equals(" ")) {
                System.out.println("-" + matcher.group(0) + "-");
            }

            // System.out.println(matcher.group(0));
            // System.out.println(matcher.group(1));
            // System.out.println(matcher.group(2));
            // System.out.println(matcher.group(3));
        }
    }

}
