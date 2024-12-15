package com.org.fod.ai.clients.models.requests;

import com.org.fod.ai.clients.models.commons.Content;
import lombok.Data;

import java.util.List;

@Data
public class GenerateContentRequestBody {

    private List<Content> contents;
}
