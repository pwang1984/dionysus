package temp.dionysus.commons.encrypt.impl;

import org.junit.Assert;
import org.junit.Test;

public class AESEncryptionTest {
	String invalidKey = "123456789012345";
	String[] keys = {
			"1234567890123456",
			"1234567890123456789012345678901",
			"12345678901234567890123456789012",
			"123456789012345678901234567890123",
	};

	String[] testString = {
			"zxcvbnm,./",
			"1erqwetgvfczadsfq2ef asdbqweoprj .,nqwesad",
			"zasdfq xcvazxc\"sdf qweASfasef KJK;lk",
			"`1234567890-=~!@#$%^&*()_+qwertyuiop[]\\QWERTYUIOP{}|asdfghjkl;'ASDFGHJKL:\"zxcvbnm,./ZXCVBNM<>? "
	};

	@Test(expected = Exception.class)
	public void testEncryptShortKey() throws Exception {
		AESEncryption aes = new AESEncryption(invalidKey);
	}

	@Test
	public void testEncryptAndDecrypt() throws Exception {
		for (String key : keys) {
			AESEncryption aes = new AESEncryption(key);
			for (String test : testString) {
				String encrypted = aes.encrypt(test);
				Assert.assertEquals(test, aes.decrypt(encrypted));
			}
		}
	}

}
