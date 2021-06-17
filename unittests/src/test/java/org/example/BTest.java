package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BTest {

    public B testBOjb;

    @BeforeEach
    public void initTestObj() {
        testBOjb = new B();
    }

    @Test
    public void testRepeatString() {
        String actual = "BBBB";
        String expected = testBOjb.repeatString("B", 4);

        assertEquals(actual, expected);
    }

    @Test
    public void testReverseString() {
        String actual = "DSAW";
        String expected = testBOjb.reversString("WASD");

        assertEquals(actual, expected);
    }

    @Test
    public void randString() {
        assertThrows(IllegalArgumentException.class, () -> testBOjb.randString("AAA"));
    }
}
