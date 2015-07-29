package temp.dionysus.log;

import org.junit.Test;

public class LogServiceTest {

	@Test(expected = NullPointerException.class)
	public void testNullPointer() {
		throwNullPointer();
	}

	private void throwNullPointer2() {
		throw new NullPointerException("Null Pointer Test");
	}

	private void throwNullPointer() {
		throwNullPointer2();
	}

	@Test(expected = Error.class)
	public void testError() {
		throwError();
	}

	private void throwError() {
		throw new Error("Error Test");
	}

	public int testReturnIntWithInt(int i) {
		return 1 + i;
	}

	public String testReturnStrWithStr(String str) {
		return "test " + str;
	}

	@Test
	public void test() {
		LogServiceTest test = new LogServiceTest();
		test.testReturnIntWithInt(5);
		test.testReturnStrWithStr("abc");
	}

}
