package com.zuhlke.kata;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class DictionaryReaderTest {

    @Test
    public void givenDictionaryFile_returnsListOfStrings() {
        // given
        String filename = "test-dict.txt";

        // when
        List<String> words = DictionaryReader.read(filename);

        // then
        assertEquals(2, words.size());
    }

}
