package com.example.testing_tutorial_june;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int add(int x, int y) {
        return x+y;
    }

    public int subtract(int x, int y) {
        return x-y;
    }

    public int multiply(int x, int y) {
        return x*y;
    }

    public int sumManyNumbers(int ...numbers) {
        int sum = 0;
        for(int number: numbers) {
            sum += number;
        }
        return sum;
    }

    public boolean isEven(int x) {
        return x%2==0;
    }
}
