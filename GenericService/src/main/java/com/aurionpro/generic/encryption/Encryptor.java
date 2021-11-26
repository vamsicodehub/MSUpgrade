package com.aurionpro.generic.encryption;

public interface Encryptor  {
	public String encrypt(final String data) throws EncryptionException;
	public String decrypt(String encryptedData) throws EncryptionException;
	
}
