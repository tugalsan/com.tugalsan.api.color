package com.tugalsan.api.color.client;

public record TGS_Color(int r, int g, int b) {

    public static TGS_Color of(int r, int g, int b) {
        return new TGS_Color(r, g, b);
    }
}
