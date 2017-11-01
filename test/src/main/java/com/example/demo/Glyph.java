package com.example.demo;

/**
 * User: jennie
 * Date: 2017/9/6
 * Time: 18:21
 */
public class Glyph {
    void draw(){
        System.out.println("Glyph.draw()");
    }
    public Glyph(){
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}
