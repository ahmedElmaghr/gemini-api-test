package com.org.fod.ai.clients.models.responses;

import lombok.Data;

import java.util.List;

@Data
public class GenerateContentResponse {
    private List<Candidate> candidates;
}
