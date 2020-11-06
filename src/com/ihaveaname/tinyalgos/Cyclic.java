package com.ihaveaname.tinyalgos;

import java.util.ArrayList;
import java.util.List;

public class Cyclic {

    private List<Integer> two_n_1;

    public Cyclic(int n) {
        two_n_1 = gen_two_n_1(n);
    }

    public List<Integer> gen_two_n_1(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            result.add(i);

        for (int i = n - 2; i > 0; i--)
            result.add(i);

        return result;
    }

    public int for_two_n_1(int n, int of) {
        return two_n_1.get(of % two_n_1.size());
    }
}
