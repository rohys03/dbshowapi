package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.dbshowapi.DbShowApiMapper;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class ServerInfoCommandLineRunner implements CommandLineRunner {

    @Autowired
    DbShowApiMapper dbShowApiMapper;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("==== DBShowApi Server && DB Info ====");

        String envKeys[] = {"host", "ip_address", "server_host", "db_name", "instance_name" , "session_user"};

        for (String envKey : envKeys) {
            System.out.println("== " + envKey.toUpperCase() + ": " + dbShowApiMapper.selectUserEnv("userenv", envKey));
        }

        System.out.println("==== Encryption String ====");
        getEncryptString();

        getDecryptString();
    }

    public void getEncryptString () {

        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword("purple");

        String[] stringList = {"dauser", "dauser#1004"};

        for (String string2 : stringList) {

            String enc2 = pbeEnc.encrypt(string2); //암호화 할 내용
            System.out.println("== encrypt["+string2+"] = " + enc2); //암호화 한 내용을 출력

            String des2 = pbeEnc.decrypt(enc2);
            System.out.println("== decrypt["+string2+"] = " + des2);
        }

    }
    public void getDecryptString () {

        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword("purple");

        String[] stringList = {"IZXxvwjYprSzwzGeSj5H6nU8IST02+U/5k9GmXSqWxn+cO5GKRb9fTYeccPSE/Rbs2pTsCqmXxg=", "UdKSqNMY+zgn6S1JtqtNCpYewWzZm5o9ZVQYVdkINidqvOFNSFWsyPQ4IUqD/XanUTiTX/CEo8c="};

        for (String string2 : stringList) {

            String des2 = pbeEnc.decrypt(string2);
            System.out.println("== decrypt["+string2+"] = " + des2);
        }

    }
}
