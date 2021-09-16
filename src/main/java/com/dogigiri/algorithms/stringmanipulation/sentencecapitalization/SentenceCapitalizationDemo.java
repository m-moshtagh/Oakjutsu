package com.dogigiri.algorithms.stringmanipulation.sentencecapitalization;

public class SentenceCapitalizationDemo {
    public String capitalize(String input) {
        if(input == null || input.isBlank())
            return "";
        var sentenceWords = input.strip().split("\\s+");
        for(var i = 0; i < sentenceWords.length; i++)
            sentenceWords[i] = sentenceWords[i].substring(0,1).toUpperCase()
                    + sentenceWords[i].substring(1).toLowerCase();
        return "'" + String.join(" ", sentenceWords) + "'";
    }
}
