package com.temp.dionysus.commons.encrypt.impl;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.Base64Utils;

import com.temp.dionysus.commons.encrypt.Encryption;

public class AESEncryption implements Encryption {
	private Cipher cipher;
	private SecretKeySpec skeySpec;

	public AESEncryption(String key) throws GeneralSecurityException {
		this(key, "AES");
	}

	public AESEncryption(String key, String padding) throws GeneralSecurityException {
		super();
		if (key == null || key.length() < 16) {
			throw new GeneralSecurityException("Key length Error: " + key);
		}
		if (key.length() >= 32) {
			key = key.substring(0, 32);
		}
		else if (key.length() >= 16) {
			key = key.substring(0, 16);
		}
		cipher = Cipher.getInstance(padding);
		skeySpec = new SecretKeySpec(key.getBytes(), padding);
	}

	@Override
	public String encrypt(String text) throws GeneralSecurityException {
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

		byte[] encrypted = cipher.doFinal(text.getBytes());
		return Base64Utils.encodeToString(encrypted);
	}

	@Override
	public String decrypt(String encryptedText) throws GeneralSecurityException {
		byte[] base64Decoded = Base64Utils.decodeFromString(encryptedText);

		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] original = cipher.doFinal(base64Decoded);
		String originalString = new String(original);
		return originalString;
	}

}
