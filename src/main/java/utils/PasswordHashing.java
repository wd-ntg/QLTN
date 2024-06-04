package utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {

    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
    
    public static void main(String[] args) {
        String plain = "99999";
        String hash = "$2a$12$M2x4CTr52UK3Py3pO9neRusuIBAc90avIaKpDN1mbl2D/ZqmLPxZO";
        System.out.println(hash.length());
        System.out.println(checkPassword(plain, hash));
    }
}
