package co.micol.prj;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassEncryptTest {
	@Test
	public void test() {
		// Create an encoder with strength 16(Example 9. BCryptPasswordEncoder)
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String result = encoder.encode("1111");
		String result2 = encoder.encode("1111");
		System.out.println(result);
		System.out.println(result2);
//		matches method() => equal와 같은 기능, equals를 쓸수없기 때문에 비교할 때는 matches 사용하기
		assertTrue(encoder.matches("1111", result));
	}
}
