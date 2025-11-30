package com.chatbot.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.chatbot.model.Message;

public class FileSaver {

    public static void saveChat(File file, List<Message> messages) throws IOException {

        try (FileOutputStream fos = new FileOutputStream(file)) {

            String header = "--- CHAT EXPORT ---\nDate: " + java.time.LocalDate.now() + "\n\n";
            fos.write(header.getBytes(StandardCharsets.UTF_8));

            for (Message msg : messages) {
                String line = msg.toLogFormat() + "\n";
                fos.write(line.getBytes(StandardCharsets.UTF_8));
            }

            String footer = "\n--- END OF LOG ---";
            fos.write(footer.getBytes(StandardCharsets.UTF_8));
        }
    }
}
