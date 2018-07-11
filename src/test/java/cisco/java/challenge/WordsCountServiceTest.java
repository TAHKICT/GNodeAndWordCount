package cisco.java.challenge;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordsCountServiceTest {

    String text = "one two three three";

    @Test
    public void shouldCountOnlyUniqueWords(){
        assertEquals(3, WordsCountService.countWords(text).size());
    }

    @Test
    public void shouldHasRightWordQuantity(){
        Map<String, Integer> map = WordsCountService.countWords(text);
        assertTrue(1 == map.get("one"));
        assertTrue(1 == map.get("two"));
        assertTrue(2 == map.get("three"));
    }
}
