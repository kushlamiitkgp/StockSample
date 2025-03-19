//package com.stock.usermgmt.service;
//
//import org.springframework.stereotype.Service;
//
//import java.security.SecureRandom;
//import java.time.LocalDateTime;
//import java.util.Random;
//
//@Service
//public class OTPService {
//    private static final Random random = new SecureRandom();
//
//    public String generateOtp() {
//        int otp = 100000 + random.nextInt(900000);
//        return String.valueOf(otp);
//    }
//
//    public LocalDateTime getOtpExpiry() {
//        return LocalDateTime.now().plusMinutes(5);
//    }
//}
