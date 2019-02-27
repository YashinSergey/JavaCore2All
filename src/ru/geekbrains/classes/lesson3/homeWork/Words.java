package ru.geekbrains.classes.lesson3.homeWork;

import java.util.HashMap;
import java.util.Map;

public class Words {

    public void createArr() {
        String[] words = {"табурет", "набег", "особняк", "танк", "кинжал", "гонг", "пыль", "очерк", "краб",
                "купон", "шторм", "досье", "молекула", "афиша", "гонг", "врач", "краб", "танк", "пожар", "краб"};


        Map<String, Integer> hm = new HashMap<>();
        for (String word : words) {
            hm.put(word,hm.getOrDefault(word, 0)+1);
        }
        System.out.println(hm);
    }
}
