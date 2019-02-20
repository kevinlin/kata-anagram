package com.zuhlke.kata;
import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.time.StopWatch;

public class FastAnagram {

    private final Map<String, List<String>> anagramMap;

    public static void main(String[] arges) {
        List<String> words = DictionaryReader.read("wordlist.txt");

        StopWatch sw = new StopWatch();
        sw.start();
        FastAnagram anagram = new FastAnagram(words);

        words.forEach(word -> {
            List<String> anagrams = anagram.getAnagramsFor(word);
            if (!anagrams.isEmpty()) {
                System.out.println(word + " " + String.join(" ", anagrams));
            }
        });

        sw.stop();
        System.out.println("Word looked up: " + words.size());
        System.out.println("Time taken (ms): " + sw.getTime());
    }

    public FastAnagram(List<String> dictionary) {
        anagramMap = dictionary.stream().collect(Collectors.groupingBy(this::convertToSortedWord, Collectors.toList()));
    }

    // aab -> aba, baa,
    private String convertToSortedWord(String word) {
        return Stream.of(word.split("")).sorted().map(String::valueOf).collect(joining());
    }

    public List<String> getAnagramsFor(String word) {
        String sortedWord = convertToSortedWord(word);

        if (!anagramMap.containsKey(sortedWord)) {
            return new ArrayList<>();
        }
        return anagramMap.get(sortedWord).stream().filter(w -> !w.equals(word)).collect(Collectors.toList());
    }
}
