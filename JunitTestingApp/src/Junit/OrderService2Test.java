package Junit;
 
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
 
public class OrderService2Test {
	private OrderService2 os2;
	@BeforeEach
	public void setup() {
		os2 = new OrderService2();
	}
 
	@Test
	public void testCalPrice_ValidInputs() {
		double price = 100.00;
		int quantity = 2;
		double expected = price * quantity * (1 - os2.getDiscount());
		assertEquals(expected, os2.calPrice(price, quantity));
	}
	@Test
    void testPlaceOrderSufficientStock() {
        boolean result = os2.placeOrder(5);
        assertTrue(result);
        assertEquals(5, os2.getStock());
    }
	// test with quantity 0
	@Test
	public void testCalPrice_InvalidInputs() {
		double price = 100.00;
		int quantity = 0;
		double expected = price * quantity * (1 - os2.getDiscount());
		assertEquals(expected, os2.calPrice(price, quantity));
	}
	// test with price 0
	@Test
	public void testCalPrice_InvalidInputs2() {
		double price = 100.00;
		int quantity = 0;
		double expected = price * quantity * (1 - os2.getDiscount());
		assertEquals(expected, os2.calPrice(price, quantity));
	}
//	// test with price negative
//	@Test
//	public void testCalPrice_InvalidInputs3() {
//		double price = -100.00;
//		int quantity = 0;
//		double expected = price * quantity * (1 - os2.getDiscount());
//		assertEquals(expected, os2.calPrice(price, quantity));
//	}
//	
//	// test with quantity negative
//	@Test
//	public void testCalPrice_InvalidInputs4() {
//		double price = 100.00;
//		int quantity = -9;
//		double expected = price * quantity * (1 - os2.getDiscount());
//		assertEquals(expected, os2.calPrice(price, quantity));
//	}
	// edge case - quantity same as stock
	@Test
	public void testCalPrice_InvalidInputs5() {
		double price = 100.00;
		int quantity = os2.getStock();
		double expected = price * quantity * (1 - os2.getDiscount());
		assertEquals(expected, os2.calPrice(price, quantity));
	}
	// edge case - quantity just below stock
	@Test
	public void testCalPrice_InvalidInputs6() {
		double price = 100.00;
		int quantity = os2.getStock() - 1;
		double expected = price * quantity * (1 - os2.getDiscount());
		assertEquals(expected, os2.calPrice(price, quantity));
	}

	// ------------------------- Exceptional Cases ----------------------- 
 
    @Test
    public void placeOrderBeyondStock() {
        int quantity = os2.getStock() + 1;
        assertThrows(IllegalArgumentException.class, () -> {
            os2.placeOrder(quantity);
        });
    }
	@Test
    public void setStockNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            os2.setStock(-5);
        });
	}
	@Test
    public void setDiscountInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            os2.setDiscount(1.5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            os2.setDiscount(-0.5);
        });
	}
	@Test
    public void TestCalPrice_NegativePrice() {
        double price = -100.00;
        int quantity = 2;
        assertThrows(IllegalArgumentException.class, () -> {
            os2.calPrice(price, quantity);
        });
    }
	@Test
    public void TestCalQuant_NegativePrice() {
        double price = 100.00;
        int quantity = -2;
        assertThrows(IllegalArgumentException.class, () -> {
            os2.calPrice(price, quantity);
        });
    }
	// ------------------------ Parameterized Cases ---------------------

	@ParameterizedTest
    @CsvSource({
        "100.0, 2, 180.0",
        "150.0, 3, 405.0",  
        "200.0, 1, 180.0",  
        "50.0, 4, 180.0"    
    })    
    void testCalPriceParamCsv(double price, int quantity, double expected) {
        assertEquals(expected, os2.calPrice(price, quantity));
	}
 
	@ParameterizedTest
    @ValueSource(ints = {1, 4, 7, 10})
    void testDiffQuant(int quantity) {
        double price = 100.0;
        double expected = price * quantity * (1 - os2.getDiscount());
        assertEquals(expected, os2.calPrice(price, quantity));
	}
	@ParameterizedTest
    @ValueSource(ints = {11, 13, 15})
    void testBoundary(int quantity) {
        double price = 100.0;
        double expected = price * quantity * (1 - os2.getDiscount());
        assertEquals(expected, os2.calPrice(price, quantity));
	}
	@ParameterizedTest
    @ValueSource(doubles = {-0.5, 1.5, 2.0})
    void testInvalidDiscount(double discount) {
        assertThrows(IllegalArgumentException.class, () -> {
            os2.setDiscount(discount);
        });
    }
	// ------------------------ Negative Values ------------------------
	@ParameterizedTest
    @ValueSource(ints = {-5, -10, -15})
	void testInvalidStock(int stock) {
        assertThrows(IllegalArgumentException.class, () -> {
            os2.setStock(stock);
        });
	}
	@ParameterizedTest
    @CsvSource({
        "-200.0, 3",
        "-70.0, -8",
        "-500, -2",
        "10.0, -7"    
    })    
    void testNegPriceNegQuant(double price, int quantity) {
        assertThrows(IllegalArgumentException.class, () -> {
            os2.calPrice(price, quantity);
        });
	}
	
	@ParameterizedTest
    @CsvSource({
        "-0.5",
        "1.5",
        "2.0"
    })
    void testInvalidDiscounts(double discount) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
            () -> os2.setDiscount(discount), "Should throw exception for setting invalid discount");
        assertEquals("Discount should be between 0 to 1", thrown.getMessage());
    }
	// -------------------------- Method Source -----------------------
	
	// method for sourcing..
	
	static Stream<Integer> stockValues()
	{
		return Stream.of(0,10,20,30,40);
	}
	
	static Stream<Arguments> testMultArguments()
	{
		return Stream.of(
				org.junit.jupiter.params.provider.Arguments.of(100.00, 2, 180.00)
				, org.junit.jupiter.params.provider.Arguments.of(100.00,3,270.00)
				, org.junit.jupiter.params.provider.Arguments.of(100.00,4,360.00)
				);
	}
	
	@ParameterizedTest
	@MethodSource("testMultArguments")
	void testStockPriceMA(double price, int qty, double expected)
	{
		assertEquals(expected, os2.calPrice(price, qty));
	}
	
	
	@ParameterizedTest
	@MethodSource("stockValues")
	void testMethodSource(int n)
	{
		os2.setStock(n);
		assertEquals(n, os2.getStock());
	}
	
	
	@ParameterizedTest
	@MethodSource("boundaryOrderValues")
	void testBoundaryOrderPlace(int number) {
	    assertThrows(IllegalArgumentException.class, () -> {
	        os2.placeOrder(number);
	    });
	}
 
	static Stream<Integer> boundaryOrderValues() {
		return Stream.of(11, 13, 15);
	}

	static Stream<Double> invalidDiscountValues() {
		return Stream.of(-0.5, 1.5, 2.0);
	}
	
	@ParameterizedTest
	@MethodSource("invalidDiscountValues")
	void testInvalidDiscountsMA(double number) {
	    assertThrows(IllegalArgumentException.class, () -> {
	        os2.setDiscount(number);
	    });
	}
 
	static Stream<Arguments> negPriceAndQuantity() {
		return Stream.of(
				Arguments.of(100.0, -5),
				Arguments.of(-100.0, 5),
				Arguments.of(-50.0, -2)
				);
	}

	@ParameterizedTest
	@MethodSource("negPriceAndQuantity")
	void testNegPriceNegQuan(double price, int quantity) {
	    assertThrows(IllegalArgumentException.class, () -> {
	        os2.calPrice(price, quantity);
	    });
	}
	
	// -------------------------- BeforeAll, AfterAll, Disabled, AfterEach --------------------
	
	@BeforeAll
    public static void beforeAllTests() {
        System.out.println("@beforeAllTests - runs once early for all tests");
    }
 
    @AfterAll
    public static void afterAllTests() {
        System.out.println("@afterAllTests - runs once after all tests");
    }
    @AfterEach
    public void afterEachTest() {
        System.out.println("@afterEachTest - runs after every test");
    }

    @Test
    @Disabled("Test disabled for demonstration purposes")
    public void testDisabled() {
        System.out.println("This test is disabled and will not run");
    }

 
}