package com.org.fod.ai.services;

import org.springframework.web.multipart.MultipartFile;

public interface GeminiService {

    String generateContent(String text);

    String textAndImage(String text, MultipartFile mPartFile);
}
