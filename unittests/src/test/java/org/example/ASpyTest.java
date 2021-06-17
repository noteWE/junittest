package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ASpyTest {

    @Spy
    B spyB;

    @InjectMocks
    A testAObj;

    @Test
    public void testUnaryAction() {

        String expected = "!dlroW olleH";

        when(spyB.reversString("Hello World!")).thenReturn("!dlroW olleH");

        String actual = testAObj.stringUnaryAction("Hello World!", "reverse");

        assertEquals(expected, actual);

        verify(spyB, atLeast(1)).reversString("Hello World!");
    }

    @Test
    public void testBinaryAction() {
        assertEquals("", testAObj.stringBinaryAction(null,-1,null));

        assertThrows(IllegalArgumentException.class, () -> testAObj.stringBinaryAction("Hello World!",2,""));

        String expected1 = "AAA";

        when(spyB.repeatString("A", 3)).thenReturn("AAA");

        String actual1 = testAObj.stringBinaryAction("A", 3, "repeat");

        assertEquals(expected1, actual1);

        verify(spyB, atLeast(1)).repeatString("A", 3);
    }
}
