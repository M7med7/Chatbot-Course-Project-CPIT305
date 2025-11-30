🤖 JavaFX Gemini Chatbot

A desktop chatbot application built with Java 21 and JavaFX, integrated with the Google Gemini AI model.

This project demonstrates core software engineering concepts including Multithreading, File I/O Streams, MVC Architecture, and Exception Handling.

🚀 Key Features (Course Requirements)

1. Concurrency & Multithreading

Problem: Network requests to AI APIs are slow and block the main thread, freezing the UI.

Solution: Implemented javafx.concurrent.Task to offload API calls to a background worker thread.

Result: The UI remains responsive (buttons clickable, window movable) while the bot is "thinking."

2. File I/O & Persistence

Problem: Chat history is lost when the application closes.

Solution: Implemented a "Save Conversation" feature using FileOutputStream (Byte Streams).

Result: Users can export their chat session to a local text file.

3. Exception Handling

Implementation: Robust try-catch blocks wrap all critical operations (Network calls, File writing).

Feedback: User-friendly Alert dialogs display specific errors (e.g., "Internet Disconnected" or "Disk Full") instead of crashing the app.

🛠 Tech Stack

Language: Java 21

Frontend: JavaFX (FXML)

Build Tool: Maven

AI Integration: LangChain4j (Google Gemini 1.5 Flash)

IDE: Visual Studio Code / IntelliJ IDEA

📂 Project Structure (MVC)

src/main/java/com/chatbot/
├── controller/
│   └── ChatController.java  # Handles UI events & Threading logic
├── model/
│   └── Message.java         # Data object for chat history
├── service/
│   └── GeminiService.java   # Handles API connection logic
├── util/
│   └── FileSaver.java       # Handles File Output Streams
├── Main.java                # Application Entry Point


⚙️ Setup & Installation

Prerequisites

Java JDK 21

Maven 3.x

1. Clone the Repository

git clone [https://github.com/yourusername/javafx-gemini-chatbot.git](https://github.com/yourusername/javafx-gemini-chatbot.git)
cd javafx-gemini-chatbot


2. Configure API Key

Important: This project requires a Google Gemini API Key. Use an environment variable to keep it secure.

Mac / Linux:

export GEMINI_API_KEY="your_api_key_here"


Windows (PowerShell):

$env:GEMINI_API_KEY="your_api_key_here"


3. Run the Application

Use Maven to handle dependencies and launch the JavaFX runtime:

mvn clean javafx:run


📸 Usage

Launch the app.

Type a message in the input field and press Enter or click Send.

Wait for the Gemini AI response.

Click "Save Conversation to File" to export the current session to a .txt file.

📝 License

This project is for educational purposes.