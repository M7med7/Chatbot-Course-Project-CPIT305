package com.chatbot.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.chatbot.model.Message;
import com.chatbot.service.GeminiService;
import com.chatbot.util.FileSaver;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class ChatController {

    @FXML
    private TextArea chatArea;
    @FXML
    private TextField inputField;
    @FXML
    private Button sendButton;

    private final GeminiService geminiService;

    private final List<Message> messageHistory = new ArrayList<>();

    public ChatController() {
        this.geminiService = new GeminiService();
    }

    @FXML
    public void onSendClick() {
        String userText = inputField.getText().trim();
        if (userText.isEmpty()) {
            return;
        }

        Message userMsg = new Message("You", userText);
        messageHistory.add(userMsg);
        appendMessage(userMsg);

        inputField.clear();
        sendButton.setDisable(true);

        Task<String> apiTask = new Task<>() {
            @Override
            protected String call() throws Exception {
                return geminiService.getResponse(userText);
            }
        };

        apiTask.setOnSucceeded(event -> {
            String aiResponse = apiTask.getValue();
            Message botMsg = new Message("Gemini", aiResponse);
            messageHistory.add(botMsg);
            appendMessage(botMsg);
            sendButton.setDisable(false);
        });

        apiTask.setOnFailed(event -> {
            Throwable error = apiTask.getException();
            showAlert("Connection Error", "Could not reach Gemini: " + error.getMessage());
            sendButton.setDisable(false);
        });

        new Thread(apiTask).start();
    }

    @FXML
    public void onSaveClick() {
        if (messageHistory.isEmpty()) {
            showAlert("Info", "No messages to save yet!");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Chat History");
        fileChooser.setInitialFileName("chat_log.txt");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File file = fileChooser.showSaveDialog(sendButton.getScene().getWindow());

        if (file != null) {
            try {
                FileSaver.saveChat(file, messageHistory);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Chat saved successfully to:\n" + file.getAbsolutePath());
                alert.showAndWait();

            } catch (IOException e) {
                showAlert("Save Error", "Could not save file: " + e.getMessage());
            }
        }
    }

    private void appendMessage(Message msg) {
        Platform.runLater(() -> {
            chatArea.appendText(msg.getSender() + ": " + msg.getContent() + "\n\n");
        });
    }

    private void showAlert(String title, String content) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setContentText(content);
            alert.showAndWait();
        });
    }
}
