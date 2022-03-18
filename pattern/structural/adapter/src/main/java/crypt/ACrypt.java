package crypt;

public class ACrypt implements Crypt {

    public void encrypt(String text) {
        System.out.println("#CryptA#encrypt()");
    }

    public void decrypt(String text) {
        System.out.println("#CryptA#decrypt()");
    }
}
