package edu.ifrs.conhecimentoatravesvideos.functions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public final class Functions {
    public static String convertToMd5(String str) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update((str).getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
