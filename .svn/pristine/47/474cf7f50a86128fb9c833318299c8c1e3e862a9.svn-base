package com.aurionpro.beneficiary.encryption;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;


public class EncryptUtils {

	
	private static Map<Long, String> IdMap = new HashMap<Long, String>();
	
	private EncryptUtils() {
	}

	public static Long decryptId(String encryptedId) {
		Long id = null;

		if (encryptedId == null || encryptedId.equals(""))
			return null;

		if (encryptedId.equals("0"))
			return 0L;

		try {
			Encryptor encryptor = EncryptorImpl.getInstance();
			id = Long.parseLong(encryptor.decrypt(encryptedId));
		} catch (NumberFormatException e) {
			System.out.println("decryptId number format : " + encryptedId + " >>> " + e.getMessage());
			// This is possibly a security breach.
			throw e;
		} catch (EncryptionException e) {
			// This is possibly a security breach.
			System.out.println("decryptId encryption : " + encryptedId);
		}
		return id;
	}

	public static String encryptId(Long id) {
		String encryptValue = null;
		if(id != null && id.longValue() < 5000L) {
			encryptValue = IdMap.get(id);
		}
		if(encryptValue == null) {
			Encryptor encryptor = EncryptorImpl.getInstance();
			try {
				String encryptedId = encryptor.encrypt(id.toString());
				IdMap.put(id, encryptedId);
				return encryptedId;
			} catch (EncryptionException e) {
			}
		}
		return encryptValue;
	}

	public static Key getKey() {
		EncryptionKeyManager encryptionKeyManager = EncryptorImpl.getInstance();
		return encryptionKeyManager.getKey();
//		System.out.println("EncryptUtils.getKey() " + key);
//		return key;
	}

	public static void setKey(Key key) {
		EncryptionKeyManager encryptionKeyManager = EncryptorImpl.getInstance();
		encryptionKeyManager.setKey(key);
//		System.out.println("EncryptUtils.setKey() " + key.getBytes());
	}

	public static String getVersion(String encryptedId) {
		return encryptedId.split(",")[1];
	}

	public static String getId(String encryptedId) {
		return encryptedId.split(",")[0];
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(EncryptUtils.decryptId("v3oZ9v1525Q="));
	//	EncryptUtils.encryptId(id);
	}
}
