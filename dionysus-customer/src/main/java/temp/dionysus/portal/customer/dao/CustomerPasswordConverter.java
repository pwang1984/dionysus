package temp.dionysus.portal.customer.dao;

import java.security.GeneralSecurityException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import temp.dionysus.commons.encrypt.Encryption;
import temp.dionysus.commons.encrypt.impl.AESEncryption;

@Converter
public class CustomerPasswordConverter implements AttributeConverter<String, String> {
	private final static String CUSOMTER_PASSWORD_ENCRYPT_KEY = "d7w59j34?0qww@($E?#HD$^)%?i36=-0";

	//TODO: investigate using Dependency Injection.
	private Encryption encryption;

	public CustomerPasswordConverter() throws GeneralSecurityException {
		super();
		encryption = new AESEncryption(CUSOMTER_PASSWORD_ENCRYPT_KEY);
	}

	public CustomerPasswordConverter(Encryption encryption) {
		super();
		this.encryption = encryption;
	}

	public String convertToDatabaseColumn(String attribute) {
		try {
			return encryption.encrypt(attribute);
		} catch (Exception e) {
			return "";
		}
	}

	public String convertToEntityAttribute(String dbData) {
		try {
			return encryption.decrypt(dbData);
		} catch (Exception e) {
			return "";
		}
	}

}
