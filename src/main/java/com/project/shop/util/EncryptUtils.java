package com.project.shop.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * 加密工具类，提供SHA256哈希功能
 */
public class EncryptUtils {

    /**
     * 使用SHA256算法对字符串进行哈希
     * @param input 输入字符串
     * @return 哈希后的字符串（Base64编码）
     */
    public static String sha256Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

    /**
     * 生成随机盐值
     * @return 盐值（Base64编码）
     */
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    /**
     * 使用盐值对字符串进行SHA256哈希
     * @param input 输入字符串
     * @param salt 盐值
     * @return 哈希后的字符串（Base64编码）
     */
    public static String sha256HashWithSalt(String input, String salt) {
        return sha256Hash(input + salt);
    }

    /**
     * 验证密码是否匹配
     * @param inputPassword 输入的密码
     * @param storedHash 存储的哈希值
     * @param salt 盐值
     * @return 是否匹配
     */
    public static boolean verifyPassword(String inputPassword, String storedHash, String salt) {
        String hashedInput = sha256HashWithSalt(inputPassword, salt);
        return hashedInput.equals(storedHash);
    }
}