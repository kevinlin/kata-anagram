package com.zuhlke.kata;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AnagramTest {

    @Test
    public void dictWith2_Anagrams_0_Other_returns1_Anagram() {
        List<String> dictionary = Arrays.asList("aba", "aab");
        Anagram anagram = new Anagram(dictionary);

        List<String> anagrams = anagram.getAnagramsFor("aba");

        assertEquals(1, anagrams.size());
        assertEquals("aab", anagrams.get(0));
    }

    @Test
    public void dictWith3_Anagrams_1_OtherDiffLength_return2_Anagrams() {
        // given
        List<String> dictionary = Arrays.asList("boaster", "boaters", "borates", "abc");
        Anagram anagram = new Anagram(dictionary);

        // when
        List<String> anagrams = anagram.getAnagramsFor("borates");

        // then
        assertEquals(2, anagrams.size());
        assertTrue(anagrams.contains("boaster"));
        assertTrue(anagrams.contains("boaters"));
    }

    @Test
    public void dictWith3_Anagrams_1_OtherSameLength_return2_Anagrams() {
        // given
        List<String> dictionary = Arrays.asList("boaster", "boaters", "borates", "abccdef");
        Anagram anagram = new Anagram(dictionary);

        // when
        List<String> anagrams = anagram.getAnagramsFor("borates");

        // then
        assertEquals(2, anagrams.size());
        assertTrue(anagrams.contains("boaster"));
        assertTrue(anagrams.contains("boaters"));
    }

    @Test
    public void dictWith0_Anagrams_sameLength_matchingLetters_return0_Anagrams() {
        // given
        List<String> dictionary = Arrays.asList("aabb", "abbb", "aaab");
        Anagram anagram = new Anagram(dictionary);

        // when
        List<String> anagrams = anagram.getAnagramsFor("aabb");

        // then
        assertEquals(0, anagrams.size());
    }

}
