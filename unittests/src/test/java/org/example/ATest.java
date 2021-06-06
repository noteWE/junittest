package org.example;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Wrapper;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ATest {

    @Mock
    IB mockB;

    @InjectMocks
    B myB;

    B spyB = spy(new B());

    @Test
    public void testUnaryActionWithMock() {

        A testObj = new A(myB);

        Assert.assertEquals("", testObj.stringUnaryAction(null, null));

        Assert.assertEquals("Hello World!", testObj.stringUnaryAction("Hello World!", ""));

        String expected1 = "hello world!";
        String actual1 = testObj.stringUnaryAction("Hello World!", "lower");

        Assert.assertEquals(expected1, actual1);

        String expected2 = "HELLO WORLD!";
        String actual2 = testObj.stringUnaryAction("Hello World!", "upper");

        Assert.assertEquals(expected2, actual2);
        String expected3 = "!dlroW olleH";
        String actual3 = testObj.stringUnaryAction("Hello World!", "reverse");

        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void testBinaryActionWithMock() {
        A testObj = new A(myB);

        Assert.assertEquals("", testObj.stringBinaryAction(null,-1,null));

        Assert.assertEquals("", testObj.stringBinaryAction("Hello World!",2,""));

        String expected1 = "AAA";
        String actual1 = testObj.stringBinaryAction("A", 3, "repeat");

        Assert.assertEquals(expected1, actual1);

        String expected2 = "Hello";
        String actual2 = testObj.stringBinaryAction("Hello World!", 5, "first");

        Assert.assertEquals(expected2, actual2);

        String expected3 = "World!";
        String actual3 = testObj.stringBinaryAction("Hello World!", 6, "last");

        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void testUnaryAction() {

        A testObj = new A(spyB);

        String expected = "!dlroW olleH";
        String actual = testObj.stringUnaryAction("Hello World!", "reverse");

        Assert.assertEquals(expected, actual);

        verify(spyB, atLeast(1)).reversString("Hello World!");
    }

    @Test
    public void testBinaryAction() {
        A testObj = new A(spyB);

        Assert.assertEquals("", testObj.stringBinaryAction(null,-1,null));

        String actual = "";

        try {
            actual = testObj.stringBinaryAction("Hello World!",2,"");
        } catch (IllegalArgumentException exception) {
            Assert.assertEquals("Something was happen", exception.getMessage());
        }

        Assert.assertEquals("", actual);

        String expected1 = "AAA";

        String actual1 = testObj.stringBinaryAction("A", 3, "repeat");

        Assert.assertEquals(expected1, actual1);

        verify(spyB, atLeast(1)).repeatString("A", 3);
    }
}
