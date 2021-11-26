package com.aurionpro.userfavourite.encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;




public class EncryptorImpl implements Encryptor, EncryptionKeyManager {

    private Encoding encoding;

    private EncryptionAlgorithm algorithm;

    private Cipher encryptCipher;

    private Cipher decryptCipher;
    
    private static final int OFFSET = 0;
    
    private static final int SEED_LENGTH = 32;

    private static EncryptorImpl instance = new EncryptorImpl(); 
    
    public static EncryptorImpl getInstance(){
		return instance;
	}

    private Key key;

	private SecretKeyFactory keyFactory;
    
    public EncryptorImpl() {
        setEncoding(Encoding.UTF8);
        setAlgorithm(EncryptionAlgorithm.DES);
        try {
			keyFactory = SecretKeyFactory.getInstance(algorithm.toString());
		} catch (NoSuchAlgorithmException ignore) {
		}
        byte [] seed = "aurionpro2014".getBytes();
        key = generateKey(seed);
    }

    public void setEncoding(Encoding encoding) {
        this.encoding = encoding;
    }

    public void setAlgorithm(EncryptionAlgorithm algorithm)  {
        this.algorithm = algorithm;
    }

    public String encrypt(String data) throws EncryptionException {
    	synchronized( this ) {
        try {
            encryptCipher = getEncryptCipher();
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);

            // Encode the string into bytes using utf-8/utf-16
            byte[] utf = data.getBytes(encoding.toString());

            // Encrypt
            byte[] encryptedData = encryptCipher.doFinal(utf);

            // Encode bytes to base64 to get a string
            return new sun.misc.BASE64Encoder().encode(encryptedData);

        } catch (javax.crypto.BadPaddingException e) {
            throw new EncryptionException(e);
        } catch (IllegalBlockSizeException e) {
            throw new EncryptionException(e);
        } catch (UnsupportedEncodingException e) {
            throw new EncryptionException(e);
        } catch (InvalidKeyException e) {
            throw new EncryptionException(e);
        } 
    	}
    }

    
    private Cipher getEncryptCipher() throws EncryptionException {
        if (encryptCipher == null) {
            try {
                encryptCipher = Cipher.getInstance(algorithm.toString());
            } catch (javax.crypto.NoSuchPaddingException e) {
                throw new EncryptionException(e);
            } catch (java.security.NoSuchAlgorithmException e) {
                throw new EncryptionException(e);
            }
        }
        return encryptCipher;
    }
    
    public  String decrypt(String encryptedData) throws EncryptionException {
    	synchronized( this ) {
    		try {
    	
            decryptCipher = getDecryptCipher();
            decryptCipher.init(Cipher.DECRYPT_MODE, key);

            // Decode base64 to get bytes
            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
            byte[] decodedData = decoder.decodeBuffer(encryptedData);

            // Decrypt
            byte[] originalData = decryptCipher.doFinal(decodedData);

            return new String(originalData, encoding.toString());
        } catch (javax.crypto.BadPaddingException e) {
            throw new EncryptionException(e);
        } catch (IllegalBlockSizeException e) {
            throw new EncryptionException(e);
        } catch (UnsupportedEncodingException e) {
            throw new EncryptionException(e);
        } catch (java.io.IOException e) {
            throw new EncryptionException(e);
        } catch (InvalidKeyException e) {
            throw new EncryptionException(e);
        } 
    	}
    }
    
    
    
    

    private Cipher getDecryptCipher() throws EncryptionException {
        if (decryptCipher == null) {
            try {
                decryptCipher = Cipher.getInstance(algorithm.toString());
            } catch (javax.crypto.NoSuchPaddingException e) {
                throw new EncryptionException(e);
            } catch (java.security.NoSuchAlgorithmException e) {
                throw new EncryptionException(e);
            }
        }
        return decryptCipher;
    }

	public void setKey(Key key) {
		this.key = key;
	}

	public Key getKey() {
		return key;
	}
	
	private Key generateKey(byte [] seed) {
		Key key = null;
		try {
			key = keyFactory.generateSecret(new DESKeySpec(seed, OFFSET));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}
	
	/*private byte [] generateSeed() {
		RandomNumberGenerator rng = new RandomNumberGenerator(RandomNumberGenerator.Algorithm.SHA1PRNG, SEED_LENGTH);
        byte [] seed = rng.getSeed();
        try {
			do {
			    rng.nextBytes(seed);
			} while (DESKeySpec.isWeak(seed, OFFSET));
		} catch (InvalidKeyException e) {
		}
		return seed;
	}*/
	
	
	
	//Added from Paypro
	
    public  byte[] encrypt(byte[] data) throws EncryptionException {
    	synchronized( this ) {
        try {
            encryptCipher = getEncryptCipher();
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);            

            // Encrypt
            byte[] encryptedData = encryptCipher.doFinal(data);
            
            return encryptedData;

        } catch (javax.crypto.BadPaddingException e) {
            throw new EncryptionException(e);
        } catch (IllegalBlockSizeException e) {
            throw new EncryptionException(e);
        } catch (InvalidKeyException e) {
            throw new EncryptionException(e);
        } 
    	}
    }

    public byte[] decrypt(byte[] encryptedData) throws EncryptionException, RemoteException {
    	synchronized( this ) {
        try {
            decryptCipher = getDecryptCipher();
            decryptCipher.init(Cipher.DECRYPT_MODE, key);             
            byte[] originalData = decryptCipher.doFinal(encryptedData);

            return originalData;
        } catch (javax.crypto.BadPaddingException e) {
            throw new EncryptionException(e);
        } catch (IllegalBlockSizeException e) {
            throw new EncryptionException(e);
        } catch (InvalidKeyException e) {
            throw new EncryptionException(e);
        } 
    	}
    }
}
