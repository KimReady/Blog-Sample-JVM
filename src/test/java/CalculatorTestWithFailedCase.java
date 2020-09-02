import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class CalculatorTestWithFailedCase {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testStaticAdd() {
        // given
        when(Calculator.add(anyInt(), anyInt())).thenReturn(100);

        // when
        int sum = Calculator.add(10, 20);

        // then
        assertEquals(100, sum);
    }

    @Test
    public void testMultiply() {
        // when
        int result = calculator.multiply(2, 5);

        // then
        assertEquals(10, result);
    }
}