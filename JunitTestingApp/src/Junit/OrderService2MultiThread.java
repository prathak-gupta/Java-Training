package Junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class OrderService2MultiThread {

	private OrderService2 mto2;
	
	@BeforeEach
	public void setUp()
	{
		mto2 = new OrderService2();
	}
	
	@Test
	public void testPlaceOrderMT()
	{
		int t_count =10;
		ExecutorService exe = Executors.newFixedThreadPool(t_count);
		CountDownLatch latch = new CountDownLatch(t_count);
//		int ii=0,j=10;
		
		for(int i=0; i < t_count; i++)
		{
			exe.execute(()->{
				mto2.placeOrder(1);
				latch.countDown();
			});
//			System.out.println(ii++ +" "+j--);
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exe.shutdown();
		assertEquals(0,mto2.getStock());
	}
	
	
	
//	@Test
//	public void testPlaceOrderMultiThread() throws InterruptedException {
//		int threadCount=10;
//		ExecutorService executor=Executors.newFixedThreadPool(threadCount);
//		CountDownLatch latch = new CountDownLatch(threadCount);
//		for(int i=0;i<10;i++) {
//			executor.execute(()->{
//				try {
//					mto2.placeOrder(1);
//				} catch(Exception Ignored) {
//				}
//				latch.countDown();
//			});
//		}
//		latch.await(); // wait for all threads to finish
//		executor.shutdown();
//		assertEquals(0,mto2.getStock());
//	}
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
