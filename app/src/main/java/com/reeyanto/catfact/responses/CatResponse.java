package com.reeyanto.catfact.responses;

public class CatResponse {

    String fact;
    int length;

    public CatResponse(String fact, int length) {
        this.fact = fact;
        this.length = length;
    }

    public String getFact() {
        return fact;
    }

    public int getLength() {
        return length;
    }
}
