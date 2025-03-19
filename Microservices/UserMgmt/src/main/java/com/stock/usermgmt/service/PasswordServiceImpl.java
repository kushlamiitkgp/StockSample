package com.stock.usermgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String enCryptPwd(String incomingPwd){
        // Encrypt the password
        String encryptedPassword = passwordEncoder.encode(incomingPwd);
        return  encryptedPassword;
    }


    public String deCryptPwd(String dbPwd){
        return "";
    }

    public boolean matchPassword(String plainPasswordFromWeb, String encodedPwdFromDb){
        if(passwordEncoder.matches(plainPasswordFromWeb, encodedPwdFromDb))
            return true;
        return false;
    }

}
