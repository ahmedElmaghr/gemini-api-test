package com.org.fod.ai.clients.models.responses;

import com.org.fod.ai.clients.models.commons.Content;
import lombok.Data;

@Data
public class Candidate {
    private Content content;
    private String finishReason;
    private Integer index;
    //...

}
