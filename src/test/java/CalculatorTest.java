import org.junit.*;
import org.mockito.MockedStatic;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class CalculatorTest {
    private Calculator calculator;
    private static MockedStatic<Calculator> mockedCalculator;

    @BeforeClass
    public static void beforeClass() {
        mockedCalculator = mockStatic(Calculator.class);
    }

    @AfterClass
    public static void afterClass() {
        mockedCalculator.close();
    }

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