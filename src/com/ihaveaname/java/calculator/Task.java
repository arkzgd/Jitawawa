package com.ihaveaname.java.calculator;

public interface Task<T extends TaskResult, P extends TaskParameters> {
  T run(P parameters);
}
