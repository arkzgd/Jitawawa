package com.ihaveaname.java.leetcode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Utils {
  public static Integer[] sort(Integer[] input) {
    Arrays.sort(input, Integer::compareTo);

    return input;
  }

  public static Integer sum(Integer[] input, int fixed, int left, int right) {
    return input[fixed] + input[left] + input[right];
  }

  public static Integer sum(int[] input, int fixed, int left, int right) {
    return input[fixed] + input[left] + input[right];
  }

  public static int[] readNumbersFromTxtFile(String fileName) throws IOException {
    String line = readSmallTextFile(fileName);
    String[] numbers = line.split(",");
    int[] input = new int[numbers.length];
    int idx = 0;
    for (String num : numbers) {
      input[idx++] = Integer.parseInt(num.trim());
    }

    return input;
  }

  public static String readSmallTextFile(String fileName) throws IOException {
    Path path = Paths.get(fileName);
    return Files.readAllLines(path, StandardCharsets.UTF_8).stream().collect(Collectors.joining());
  }
}
