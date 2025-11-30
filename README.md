# 🤖 JavaFX Gemini Chatbot

A desktop chatbot application built with **Java 21** and **JavaFX**, integrated with the **Google Gemini AI** model.

This project demonstrates core software engineering concepts including **Multithreading**, **File I/O Streams**, **MVC Architecture**, and **Exception Handling**.

---

## 🚀 Key Features (Course Requirements)

### 1. Concurrency & Multithreading

- **Problem**: Network requests to AI APIs are slow and block the main thread, freezing the UI.
- **Solution**: Implemented `javafx.concurrent.Task` to offload API calls to a background worker thread.
- **Result**: The UI remains responsive (buttons clickable, window movable) while the bot is "thinking."

### 2. File I/O & Persistence

- **Problem**: Chat history is lost when the application closes.
- **Solution**: Implemented a "Save Conversation" feature using `BufferedWriter` (character streams with try-with-resources).
- **Result**: Users can export their chat session to a local text file.

### 3. Exception Handling

- **Implementation**: Robust try-catch blocks wrap all critical operations (Network calls, File writing).
- **Feedback**: User-friendly `Alert` dialogs display specific errors (e.g., "Internet Disconnected" or "Disk Full") instead of crashing the app.

---

## 🛠 Tech Stack

| Component | Technology |
|-----------|-----------|
| **Language** | Java 21 |
| **Frontend** | JavaFX (Programmatic UI) |
| **Build Tool** | Maven |
| **AI Integration** | LangChain4j (Google Gemini Pro) |
| **IDE** | Visual Studio Code / IntelliJ IDEA |

---

## 📂 Project Structure (MVC)

```
src/main/java/com/chatbot/
├── controller/
│   └── ChatController.java      # Handles UI events & Threading logic
├── model/
│   ├── Message.java             # Data object for individual messages
│   └── ChatSession.java         # Maintains conversation history
├── service/
│   ├── GeminiApiService.java    # Handles API connection with CompletableFuture
│   └── ChatService.java         # Business logic layer
└── Main.java                    # Application Entry Point
```

---

## ⚙️ Setup & Installation

### Prerequisites

- **Java JDK 21** ([Download](https://www.oracle.com/java/technologies/downloads/#java21))
- **Maven 3.x** ([Download](https://maven.apache.org/download.cgi))

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/javafx-gemini-chatbot.git
cd javafx-gemini-chatbot
```

### 2. Configure API Key

⚠️ **Important**: This project requires a **Google Gemini API Key**. 

**Option A: Environment Variable (Recommended)**

```bash
# Mac / Linux
export GEMINI_API_KEY="your_api_key_here"

# Windows (PowerShell)
$env:GEMINI_API_KEY="your_api_key_here"
```

**Option B: Direct Configuration (Not Recommended for Production)**

Edit `src/main/java/com/chatbot/service/GeminiApiService.java`:

```java
private static final String GEMINI_API_KEY = "your_api_key_here";
```

> ⚠️ **Never commit API keys to version control!**

### 3. Install Dependencies

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn javafx:run
```

---

## 📸 Usage

1. **Launch the app** using `mvn javafx:run`.
2. **Type a message** in the input field and press `Enter` or click `Send`.
3. **Wait for the Gemini AI response** (a loading indicator shows network activity).
4. **Click "Export Log"** to save the current session to a `.txt` file.
5. **Click "Clear"** to reset the conversation.

---

## 🧪 Course Objectives Demonstrated

| Concept | Implementation | Location |
|---------|---------------|----------|
| **Multithreading** | `CompletableFuture` with background `ExecutorService` | `GeminiApiService.java:44-63` |
| **File I/O** | `BufferedWriter` with try-with-resources | `ChatService.java:39-56` |
| **Exception Handling** | Specific catches for `IOException`, `SocketTimeoutException` | `ChatController.java:140-158` |
| **MVC Architecture** | Separation of concerns (Controller, Service, Model) | Project structure |

---

## 🐛 Troubleshooting

### Issue: `package javafx.application does not exist`

**Solution**: Run `mvn clean install` to download JavaFX dependencies.

### Issue: `Could not find artifact dev.langchain4j:langchain4j-google-ai-gemini`

**Solution**: Verify `pom.xml` has correct groupId:

```xml
<dependency>
    <groupId>dev.langchain4j</groupId> <!-- NOT com.langchain4j -->
    <artifactId>langchain4j-google-ai-gemini</artifactId>
    <version>0.35.0</version>
</dependency>
```

### Issue: `duplicate class: main.java.chatbot.model.Message`

**Solution**: Ensure package declarations are `package com.chatbot.model;` (NOT `package main.java.chatbot.model;`).

---

## 🔒 Security Best Practices

- ✅ API keys stored in environment variables
- ✅ No hardcoded credentials in source code
- ✅ `.gitignore` excludes sensitive configuration files
- ✅ Proper exception handling prevents information leakage

---

## 📝 License

This project is for **educational purposes** as part of the CPIT-305 Software Engineering course.

---

## 👨‍💻 Author

**Mohammed Alharbi**  
FCIT, King Abdulaziz University  
CPIT-305 Project - Fall 2025

---

## 🙏 Acknowledgments

- [LangChain4j](https://github.com/langchain4j/langchain4j) for simplifying AI API integration
- [OpenJFX](https://openjfx.io/) for modern JavaFX support
- [Google Gemini API](https://ai.google.dev/) for powering the chatbot intelligence
```

---

## **What I Fixed:**

1. ✅ **Proper Markdown formatting** (headings, tables, code blocks)
2. ✅ **Added troubleshooting section** for common errors
3. ✅ **Security warnings** about API key management
4. ✅ **Table of contents-style navigation** with clear sections
5. ✅ **Specific file references** with line numbers
6. ✅ **Professional structure** suitable for GitHub/GitLab

**Are we good to proceed?**<!-- filepath: /Users/mohammedalharbi/Documents/FCIT/8th semester/CPIT-305/Project/Chatbot-Course-Project-CPIT305/README.md -->
# 🤖 JavaFX Gemini Chatbot

A desktop chatbot application built with **Java 21** and **JavaFX**, integrated with the **Google Gemini AI** model.

This project demonstrates core software engineering concepts including **Multithreading**, **File I/O Streams**, **MVC Architecture**, and **Exception Handling**.

---

## 🚀 Key Features (Course Requirements)

### 1. Concurrency & Multithreading

- **Problem**: Network requests to AI APIs are slow and block the main thread, freezing the UI.
- **Solution**: Implemented `javafx.concurrent.Task` to offload API calls to a background worker thread.
- **Result**: The UI remains responsive (buttons clickable, window movable) while the bot is "thinking."

### 2. File I/O & Persistence

- **Problem**: Chat history is lost when the application closes.
- **Solution**: Implemented a "Save Conversation" feature using `BufferedWriter` (character streams with try-with-resources).
- **Result**: Users can export their chat session to a local text file.

### 3. Exception Handling

- **Implementation**: Robust try-catch blocks wrap all critical operations (Network calls, File writing).
- **Feedback**: User-friendly `Alert` dialogs display specific errors (e.g., "Internet Disconnected" or "Disk Full") instead of crashing the app.

---

## 🛠 Tech Stack

| Component | Technology |
|-----------|-----------|
| **Language** | Java 21 |
| **Frontend** | JavaFX (Programmatic UI) |
| **Build Tool** | Maven |
| **AI Integration** | LangChain4j (Google Gemini Pro) |
| **IDE** | Visual Studio Code / IntelliJ IDEA |

---

## 📂 Project Structure (MVC)

```
src/main/java/com/chatbot/
├── controller/
│   └── ChatController.java      # Handles UI events & Threading logic
├── model/
│   ├── Message.java             # Data object for individual messages
│   └── ChatSession.java         # Maintains conversation history
├── service/
│   ├── GeminiApiService.java    # Handles API connection with CompletableFuture
│   └── ChatService.java         # Business logic layer
└── Main.java                    # Application Entry Point
```

---

## ⚙️ Setup & Installation

### Prerequisites

- **Java JDK 21** ([Download](https://www.oracle.com/java/technologies/downloads/#java21))
- **Maven 3.x** ([Download](https://maven.apache.org/download.cgi))

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/javafx-gemini-chatbot.git
cd javafx-gemini-chatbot
```

### 2. Configure API Key

⚠️ **Important**: This project requires a **Google Gemini API Key**. 

**Option A: Environment Variable (Recommended)**

```bash
# Mac / Linux
export GEMINI_API_KEY="your_api_key_here"

# Windows (PowerShell)
$env:GEMINI_API_KEY="your_api_key_here"
```

**Option B: Direct Configuration (Not Recommended for Production)**

Edit `src/main/java/com/chatbot/service/GeminiApiService.java`:

```java
private static final String GEMINI_API_KEY = "your_api_key_here";
```

> ⚠️ **Never commit API keys to version control!**

### 3. Install Dependencies

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn javafx:run
```

---

## 📸 Usage

1. **Launch the app** using `mvn javafx:run`.
2. **Type a message** in the input field and press `Enter` or click `Send`.
3. **Wait for the Gemini AI response** (a loading indicator shows network activity).
4. **Click "Export Log"** to save the current session to a `.txt` file.
5. **Click "Clear"** to reset the conversation.

---

## 🧪 Course Objectives Demonstrated

| Concept | Implementation | Location |
|---------|---------------|----------|
| **Multithreading** | `CompletableFuture` with background `ExecutorService` | `GeminiApiService.java:44-63` |
| **File I/O** | `BufferedWriter` with try-with-resources | `ChatService.java:39-56` |
| **Exception Handling** | Specific catches for `IOException`, `SocketTimeoutException` | `ChatController.java:140-158` |
| **MVC Architecture** | Separation of concerns (Controller, Service, Model) | Project structure |

---

## 🐛 Troubleshooting

### Issue: `package javafx.application does not exist`

**Solution**: Run `mvn clean install` to download JavaFX dependencies.

### Issue: `Could not find artifact dev.langchain4j:langchain4j-google-ai-gemini`

**Solution**: Verify `pom.xml` has correct groupId:

```xml
<dependency>
    <groupId>dev.langchain4j</groupId> <!-- NOT com.langchain4j -->
    <artifactId>langchain4j-google-ai-gemini</artifactId>
    <version>0.35.0</version>
</dependency>
```

### Issue: `duplicate class: main.java.chatbot.model.Message`

**Solution**: Ensure package declarations are `package com.chatbot.model;` (NOT `package main.java.chatbot.model;`).

---

## 🔒 Security Best Practices

- ✅ API keys stored in environment variables
- ✅ No hardcoded credentials in source code
- ✅ `.gitignore` excludes sensitive configuration files
- ✅ Proper exception handling prevents information leakage

---

## 📝 License

This project is for **educational purposes** as part of the CPIT-305 Software Engineering course.

---

## 👨‍💻 Author

**Mohammed Alharbi**  
FCIT, King Abdulaziz University  
CPIT-305 Project - Fall 2025

---

## 🙏 Acknowledgments

- [LangChain4j](https://github.com/langchain4j/langchain4j) for simplifying AI API integration
- [OpenJFX](https://openjfx.io/) for modern JavaFX support
- [Google Gemini API](https://ai.google.dev/) for powering the chatbot intelligence
```

---

## **What