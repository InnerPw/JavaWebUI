package ru.geekbrains.webui.lesson4;

import ru.geekbrains.webui.lesson4.Triangle;
import ru.geekbrains.webui.lesson4.MyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {
    @Test
    void test() throws MyException {
        Triangle exampleClass = new Triangle();
        Assertions.assertEquals(97,exampleClass.someMethod(10,20,20));
        Assertions.assertThrows(MyException.class,()-> exampleClass.someMethod(-10,20,15));
    }

    @ParameterizedTest
    @CsvSource({ "10,20,20,97","60,70,50,1470","12,30,24,137"})
    void testWithCsvSource(int a, int b, int c, long result) throws MyException {
        Triangle exampleClass = new Triangle();
        Assertions.assertEquals(result,exampleClass.someMethod(a,b,c));

    }

    @ParameterizedTest
    @CsvSource({ "-10,20,25","-100, 200, 320","1,-2, 1"})
    void testWithCsvSourceN(int a, int b, int c) throws MyException {
        Triangle exampleClass = new Triangle();
        Assertions.assertThrows(MyException.class,()-> exampleClass.someMethod(a,b,c));

    }
}
