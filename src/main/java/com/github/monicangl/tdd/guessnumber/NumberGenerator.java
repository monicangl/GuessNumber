package com.github.monicangl.tdd.guessnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class NumberGenerator {
    public Vector<Integer> generateNumbers() {
        Vector<Integer> numbers = new Vector<>(0);
        List list = new ArrayList();
        Random random = new Random();
        while (true) {
            int number = random.nextInt(10);
            if (!list.contains(number)) {
                list.add(number);
                numbers.insertElementAt(number, numbers.size());
            }
            if (numbers.size() == 4) {
                break;
            }
        }

        return numbers;
    }
}
