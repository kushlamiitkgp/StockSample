//package com.stock.usermgmt.rest;
//
//import com.stock.usermgmt.service.OTPService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//public class OtpController {
//
//    @Autowired
//    private OTPService otpService;
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    private Map<String, String> otpStorage = new HashMap<>();
//
//    @PostMapping("/send-otp")
//    public String sendOtp(@RequestParam String email) {
//        String otp = otpService.generateOtp();
//        otpStorage.put(email, otp);
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(email);
//        message.setSubject("Your OTP Code");
//        message.setText("Your OTP code is: " + otp);
//        mailSender.send(message);
//
//        return "OTP sent successfully!";
//    }
//
//    @PostMapping("/verify-otp")
//    public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
//        if (otpStorage.containsKey(email) && otpStorage.get(email).equals(otp)) {
//            otpStorage.remove(email);
//            return "OTP verified successfully!";
//        }
//        return "Invalid OTP!";
//    }
//}
