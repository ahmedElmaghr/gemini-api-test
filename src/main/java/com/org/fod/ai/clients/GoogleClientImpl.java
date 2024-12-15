package com.org.fod.ai.clients;

import com.org.fod.ai.clients.models.requests.GenerateContentRequestBody;
import com.org.fod.ai.clients.models.responses.GenerateContentResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URI;

import static com.org.fod.ai.clients.builder.ModelFactory.buildGenerateContentRequestBody;

@Service
public class GoogleClientImpl implements GoogleClient {
    private final RestClient restClient;
    @Value("${google.api.gemini.pro.url}")
    private String uriGeminiPro;
    @Value("${google.api.gemini.pro.vision.url}")
    private String uriGeminiProVision;
    @Value("${google.api.gemini.key}")
    private String googleApiKey;
    private static final String GENERATE_DOCUMENT = "generateContent";

    @Autowired
    public GoogleClientImpl() {
        this.restClient = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory()) // Setting the request factory to use Apache HttpComponents HttpClient for HTTP requests
                .defaultHeader("Content-Type", "application/json") // Adding a default header to all requests made by the RestClient
                //.requestInterceptor(myCustomInterceptor) // Adding a request interceptor to the RestClient to intercept and modify requests
                .build(); // Building the RestClient instance

    }

    public GenerateContentResponse generateContent(String text) {
        GenerateContentRequestBody requestBody = buildGenerateContentRequestBody(text);
        JSONObject requestBodyAsJson = new JSONObject(requestBody);

        return restClient.post()
                .uri(URI.create(uriGeminiPro + ":" + GENERATE_DOCUMENT + "?key=" + googleApiKey))
                .body(requestBodyAsJson.toString())
                .retrieve()
                .toEntity(GenerateContentResponse.class)
                .getBody();
    }

    @Override
    public String generateTextAndImage(String text,String Base64) {
        String jsonBody = "{ 'contents':[ { 'parts':[ {'text': '" + text + "'}, { 'inline_data': { 'mime_type':'image/jpeg', 'data': '"+Base64+"' } } ] } ] }";

        return restClient.post()
                .uri(URI.create(uriGeminiProVision + ":" + GENERATE_DOCUMENT + "?key=" + googleApiKey))
                .body(jsonBody)
                .retrieve()
                .toEntity(String.class)
                .getBody();
    }
}
