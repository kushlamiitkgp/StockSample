package com.stock.usermgmt.service;

public interface PasswordService {

    String enCryptPwd(String abc);

    String deCryptPwd(String abc);

    boolean matchPassword(String plainPasswordFromWeb, String encodePwdFromDb);
}
