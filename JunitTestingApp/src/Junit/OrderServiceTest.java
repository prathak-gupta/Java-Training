package Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderServiceTest {

	OrderService os = new OrderService();
	@Test
	void testInsufficentStock()
	{
		IllegalArgumentException ie = assertThrows(IllegalArgumentException.class, ()->{
			os.placeOrder(25);
		});
	}
	
	@Test
	void testTotalPrice()
	{
		assertEquals(100, os.calPrice(10, 10));
	}
	
	@Test
	void testTotalWithZero()
	{
		assertEquals(0,os.calPrice(10, 0));
	}
	
	@Test
	void testMultiThread()
	{
		Thread t1 = new Thread(()->{
			os.placeOrder(2);
		});
		
		Thread t2 = new Thread(()->{
			os.placeOrder(1);
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(7, os.getStock());
	}
	
	@ParameterizedTest
	@CsvSource({
        "10.0, 9, 90.0",
        "150.0, 3, 450.0",  
        "200.0, 1, 200.0",  
        "50.0, 4, 200.0"  
	})
	void testCsvParameterize(double price, int quantity, double expected)
	{
        assertEquals(expected, os.calPrice(price, quantity));
	}
	
	
	@Test
	void testTimeout() {
		assertTimeout(java.time.Duration.ofMillis(1000), ()->{
			os.placeOrder(1);
			Thread.sleep(2);
		});
	}
}
