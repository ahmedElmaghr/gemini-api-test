package com.org.fod.ai.services;

import com.org.fod.ai.clients.GoogleClient;
import com.org.fod.ai.clients.models.responses.GenerateContentResponse;
import com.org.fod.ai.utils.FileEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GeminiServiceImpl implements GeminiService {

    private final GoogleClient googleClient;

    @Autowired
    public GeminiServiceImpl(GoogleClient googleClient) {
        this.googleClient = googleClient;
    }

    @Override
    public String generateContent(String text) {
        GenerateContentResponse response = googleClient.generateContent(text);
        return response.getCandidates().get(0).getContent().getParts().get(0).getText();
    }

    @Override
    public String textAndImage(String text, MultipartFile mPartFile) {
        String base64File = FileEncoding.encodeBase64FromBytes(mPartFile);
        return googleClient.generateTextAndImage(text,base64File);
    }
}
