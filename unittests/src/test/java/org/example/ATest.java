package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ATest {

    @Mock
    B mockB;

    @InjectMocks
    A testAObj;

    @Test
    public void testUnaryActionWithMock() {

        assertEquals("", testAObj.stringUnaryAction(null, null));

        assertEquals("Hello World!", testAObj.stringUnaryAction("Hello World!", ""));

        String expected1 = "hello world!";
        String actual1 = testAObj.stringUnaryAction("Hello World!", "lower");

        assertEquals(expected1, actual1);

        String expected2 = "HELLO WORLD!";
        String actual2 = testAObj.stringUnaryAction("Hello World!", "upper");

        assertEquals(expected2, actual2);
        String expected3 = "!dlroW olleH";
        lenient().when(mockB.reversString("Hello World!")).thenReturn("!dlroW olleH");
        String actual3 = testAObj.stringUnaryAction("Hello World!", "reverse");

        assertEquals(expected3, actual3);
    }

    @Test
    public void testBinaryActionWithMock() {

        assertEquals("", testAObj.stringBinaryAction(null,-1,null));

        String expected1 = "AAA";
        lenient().when(mockB.repeatString("A", 3)).thenReturn("AAA");
        String actual1 = testAObj.stringBinaryAction("A", 3, "repeat");

        assertEquals(expected1, actual1);

        String expected2 = "Hello";
        String actual2 = testAObj.stringBinaryAction("Hello World!", 5, "first");

        assertEquals(expected2, actual2);

        String expected3 = "World!";
        String actual3 = testAObj.stringBinaryAction("Hello World!", 6, "last");

        assertEquals(expected3, actual3);

        lenient().when(mockB.randString(any(String.class))).thenReturn(anyString());

        assertNotNull(testAObj.stringBinaryAction("Hello World!", 3, "something"));
    }
}
