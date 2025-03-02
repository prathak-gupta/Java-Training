package Junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.suite.api.Suite;

import org.junit.platform.suite.api.SelectClasses;


@Suite
@SelectClasses({
	OrderServiceTest.class,
	OrderService2Test.class,
	OrderService2MultiThread.class
})
class OrderServiceTestSuite {

}
