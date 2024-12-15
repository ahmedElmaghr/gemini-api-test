package com.org.fod.ai.clients.builder;

import com.org.fod.ai.clients.models.requests.GenerateContentRequestBody;
import com.org.fod.ai.clients.models.commons.Content;
import com.org.fod.ai.clients.models.commons.Part;

import java.util.ArrayList;
import java.util.List;

public class ModelFactory {

    public static GenerateContentRequestBody buildGenerateContentRequestBody(String text){
        GenerateContentRequestBody body = new GenerateContentRequestBody();
        List<Content> contents = new ArrayList<>();
        Content content = new Content();
        List<Part> parts = new ArrayList<>();
        Part part = new Part();
        part.setText(text);
        parts.add(part);
        content.setParts(parts);
        contents.add(content);
        body.setContents(contents);
        return body;
    }
}
