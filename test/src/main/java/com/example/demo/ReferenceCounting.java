package com.example.demo;

/**
 * User: jennie
 * Date: 2017/9/6
 * Time: 17:18
 */
public class ReferenceCounting {

    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composings = {new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared), new Composing(shared)};
        for (Composing composing : composings) {
            composing.dispose();
        }
    }
}
