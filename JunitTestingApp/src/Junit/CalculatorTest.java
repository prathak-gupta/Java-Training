package Junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	@Test
	void testAdd() {
		Calculator cal = new Calculator();
		
		assertEquals(10, cal.add(5, 5));
//		fail("Not yet implemented");
	}

	@Test
	void testSub() {
		Calculator cal = new Calculator();
		
		assertEquals(0, cal.sub(5, 5));
//		fail("Not yet implemented");
	}
	
	@Test
	void testConditionT()
	{
		Calculator cal = new Calculator();
		assertTrue(cal.add(2, 9)>0);
	}
	
	
	@Test
	void testConditionF()
	{
		Calculator cal = new Calculator();
		assertFalse(cal.sub(2, 9)>0);
	}
	
	@Test
	void testNull()
	{
		Calculator cal = new Calculator();		
		assertNull(null, cal.add(null, null));
	}
	
	@Test
	void testNotNull()
	{
		Calculator cal = new Calculator();		
		assertNotNull(null, cal.add(6, 7));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {12,15,16,17})
	void addTestParam(int number) {
		Calculator cal = new Calculator();		
		assertEquals(number+10, cal.add(number, 10));
	}
	
	@ParameterizedTest
	@CsvSource({
	"5,7,12",
	"3,6,9",
	"7,5,12",
	"8,9,17"})
	void addTestAddParam(int a, int b, int expected) {
		Calculator cal = new Calculator();		
		assertEquals(expected, cal.add(a,b));
	}
	
	@Disabled
	@Test
	void testTimeout()
	{
		Calculator cal = new Calculator();		
		assertTimeout(java.time.Duration.ofMillis(1000),()->{
			Thread.sleep(2000);
			cal.add(10);
		});
	}
	
	@Test
	void testException()
	{
		Calculator cal = new Calculator();		
		ArithmeticException e = assertThrows(ArithmeticException.class, ()->{
		cal.div(10,0);
		});
	}
	
}
