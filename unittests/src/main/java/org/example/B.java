package org.example;

import lombok.Data;

@Data
public class B implements IB {
    public String repeatString(String str, int number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public String reversString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public String getException(String str) {
        throw new IllegalArgumentException("Something was happen");
    }
}
