package com.example.demo;

/**
 * User: jennie
 * Date: 2017/9/6
 * Time: 18:33
 */
public class RoundGlyph extends Glyph {

    private int radius=1;

    public RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph(),radius="+radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(),radius="+radius);
    }
}
