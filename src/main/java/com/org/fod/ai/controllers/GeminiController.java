package com.org.fod.ai.controllers;


import com.org.fod.ai.services.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("gemini")
public class GeminiController {

    private final GeminiService geminiService;

    @Autowired
    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/generate")
    public ResponseEntity<String> generateContent(@RequestParam String text) {
        String response = geminiService.generateContent(text);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/image")
    public ResponseEntity<String> textAndImage(@RequestParam("text") String text,
                                                @RequestParam("file") MultipartFile file) {
        String response = geminiService.textAndImage(text, file);
        return ResponseEntity.ok(response);
    }
}
