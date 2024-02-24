package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class EncryptDecryptRSAController {

    @Autowired

    EncryptDecryptService encryptDecryptService;

    @GetMapping("/createKeys")
    @RolesAllowed(value = "USER")
    public void createPrivatePublickey() {
        encryptDecryptService.createKeys();
    }

    @PostMapping("/encrpyt")
    @RolesAllowed(value = "USER")
    public String encryptMessage(@RequestBody String plainString) {
        return encryptDecryptService.encryptMessage(plainString);
    }


    @PostMapping("/decrpyt")
    @RolesAllowed(value = "USER")
    public String decryptMessage(@RequestBody String encryptString) {
        return encryptDecryptService.decryptMessage(encryptString);
    }
}