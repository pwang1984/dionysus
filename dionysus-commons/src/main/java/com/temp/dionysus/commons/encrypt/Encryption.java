package com.temp.dionysus.commons.encrypt;

public interface Encryption {
	String encrypt(String text) throws Exception;

	String decrypt(String encryptedText) throws Exception;
}
