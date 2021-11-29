package com.aurionpro.beneficiary.encryption;

import java.security.Key;


public interface EncryptionKeyManager {
	public abstract void setKey(Key key);
	public abstract Key getKey();
}