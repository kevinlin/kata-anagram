package com.zuhlke.kata;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.time.StopWatch;

public class Anagram {

    public static void main(String[] arges) {
        List<String> words = DictionaryReader.read("wordlist.txt");

        Anagram anagram = new Anagram(words);
        StopWatch sw = new StopWatch();
        sw.start();

        words.forEach(word -> {
            List<String> anagrams = anagram.getAnagramsFor(word);

            if (!anagrams.isEmpty()) {
                System.out.println(word + " " + String.join(" ", anagrams));
            }
        });

        sw.stop();
        System.out.println("Time taken (ms): " + sw.getTime());
    }

    private List<String> dictionary;

    public Anagram(List<String> dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> getAnagramsFor(String word) {

        return dictionary.stream().filter(w -> w.length() == word.length()).filter(w -> isAnagram(word, w)).filter(w -> !w.equals(word)).collect(Collectors.toList());
    }

    private boolean isAnagram(String w1, String w2) {
        List<Character> w1Chars = w1.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());
        List<Character> w2Chars = w2.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());

        return IntStream.range(0, w1Chars.size()).allMatch(i -> w1Chars.get(i).equals(w2Chars.get(i)));
    }

}