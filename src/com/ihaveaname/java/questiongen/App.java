package com.ihaveaname.java.questiongen;

import java.util.Random;

public class App {

    private static void multiplication(Integer upperBound, Integer cols, Integer rows) {

        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String left = String.format("%3d", random.nextInt(upperBound + 1));
                String right = String.format("%-3d", random.nextInt(upperBound + 1));

                if (j < cols - 1)
                    System.out.print(left + " * " + right + " = ______\t");
                else
                    System.out.println(left + " * " + right + " = ______");
            }

            if (i < rows - 1)
                System.out.println();
        }
    }

    public static void main(String[] args) {
        multiplication(100, 4, 20);
    }
}
