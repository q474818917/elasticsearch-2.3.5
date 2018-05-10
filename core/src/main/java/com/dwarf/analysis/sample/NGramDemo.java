package com.dwarf.analysis.sample;

import java.util.ArrayList;
import java.util.List;

public class NGramDemo {

    public static List<String> ngrams(int n, String str) {
        List<String> ngrams = new ArrayList<String>();
        str = str.replaceAll("\\pP", " ");
        String[] words = str.split("");
        for (int i = 0; i < words.length - n + 1; i++)
            ngrams.add(concat(words, i, i+n));
        return ngrams;
    }

    public static String concat(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++)
            sb.append((i > start ? "" : "") + words[i]);
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int n = 1; n <= 3; n++) {
            for (String ngram : ngrams(n, "居然是这样的... 四代秘闻，四代火影的死是个阴谋！当年到底发生了什么？"))
                System.out.println(ngram);
            System.out.println();
        }
    }
}
