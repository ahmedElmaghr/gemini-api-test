package com.org.fod.ai.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class FileEncoding {

    public static String encodeBase64FromResourceFilePath(String filePath) {
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(new File(filePath));
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            return encodedString;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encodeBase64FromBytes(MultipartFile mpartFile) {
        try{
        byte[] fileContent  = mpartFile.getBytes();
        return  Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
