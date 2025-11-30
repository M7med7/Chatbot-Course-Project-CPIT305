package com.chatbot.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class GeminiService {

    private static final String API_KEY = System.getenv("GEMINI_API_KEY");
    private static final String MODEL_NAME = "gemini-2.0-flash";

    private final ChatLanguageModel model;

    public GeminiService() {
        validateConfig();

        this.model = GoogleAiGeminiChatModel.builder()
                .apiKey(API_KEY)
                .modelName(MODEL_NAME)
                .temperature(0.7)
                .build();
    }

    private void validateConfig() {
        if (API_KEY == null || API_KEY.isBlank()) {
            throw new IllegalStateException("CRITICAL: GEMINI_API_KEY environment variable is not set. "
                    + "Check Run Configuration in IntelliJ.");
        }
    }

    public String getResponse(String userMessage) {
        try {
            return model.generate(userMessage);
        } catch (Exception e) {
            // Rethrowing as RuntimeException to be handled by the Controller's task.
            throw new RuntimeException("Gemini API Handshake failed", e);
        }
    }
}
