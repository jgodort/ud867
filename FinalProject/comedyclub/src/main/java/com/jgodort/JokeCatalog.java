package com.jgodort;

import java.util.Random;

public class JokeCatalog {

    private static final String[] jokeCatalog = new String[]{
            "Can a kangaroo jump higher than a house? Of course, a house doesn´t jump at all.",
            "Doctor: \"I´m sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                    "\n" +
                    "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\"\n" +
                    "\n" +
                    "Doctor: \"Nine.\"\n" +
                    "\n",
            " Anton, do you think I´m a bad mother?" +
                    "\n" +
                    "My name is Paul",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "What is the difference between a snowman and a snowwoman?\n" +
                    " - " +
                    "Snowballs.",
            "My wife´s cooking is so bad we usually pray after our food."

    };

    public JokeCatalog() {

    }

    public String tellMeAJoke() {
        Random rand = new Random();
        int index = 0;
        index = rand.nextInt(jokeCatalog.length);
        if (index < jokeCatalog.length) {
            return jokeCatalog[index];
        }
        return "";
    }
}
