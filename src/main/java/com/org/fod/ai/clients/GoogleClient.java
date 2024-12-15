package com.org.fod.ai.clients;

import com.org.fod.ai.clients.models.responses.GenerateContentResponse;

public interface GoogleClient {
    GenerateContentResponse generateContent(String text);

    String generateTextAndImage(String text,String base64Image);
}
