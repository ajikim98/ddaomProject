package com.example.ddaom.util;

    import java.security.MessageDigest;
    import java.security.NoSuchAlgorithmException;
    
    public class PasswordHashing {
    
        public static String hashPassword(String password) {
            try {
                // SHA-256 해시 함수 생성
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                // 입력값을 바이트 배열로 변환하여 해시화
                byte[] hash = digest.digest(password.getBytes());
                // 해시된 값을 16진수 문자열로 변환
                StringBuilder hexString = new StringBuilder();
                for (byte b : hash) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                return hexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
    
        public static void main(String[] args) {
            String password = "password123";
            String hashedPassword = hashPassword(password);
            System.out.println("Hashed Password: " + hashedPassword);
        }
    }
    
