package com.iit.lab7.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MathOps {
    private Integer a;
    private Integer b;

    public MathOps(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public int add() {
        return a + b;
    }


    public int subtract() {
        return a - b;
    }


    public int multiply() {
        return a * b;
    }


    public double divide() {
        return (double)a /(double) b;
    }



}
