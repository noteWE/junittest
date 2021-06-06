package org.example;

import lombok.Data;

import java.util.Locale;

@Data
public class A {

    private B cl;

    public A(B cl) {
        this.cl = cl;
    }

    public String stringUnaryAction(String str, String action) {

        if (str == null || action == null) {
            return "";
        }

        if (action == "lower") {
            return str.toLowerCase(Locale.ROOT);
        }
        if (action == "upper") {
            return str.toUpperCase(Locale.ROOT);
        }
        if (action == "reverse") {
            return cl.reversString(str);
        } else {
            return str;
        }
    }

    public String stringBinaryAction(String str, int number, String action) {
        String returned = "";

        if (str == null || action == null || number < 0) {
            return returned;
        }

        if (action == "repeat") {
            returned = cl.repeatString(str, number);
        }
        if (action == "first") {
            returned = str.substring(0, number);
        }
        if (action == "last") {
            returned = str.substring(number);
        }
        return returned;
    }
}
