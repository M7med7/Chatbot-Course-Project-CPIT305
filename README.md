# 🤖 JavaFX Gemini Chatbot

A desktop chatbot application built with **Java 21** and **JavaFX**, integrated with the **Google Gemini AI model**.

This project was built as a **CPIT-305** course project to demonstrate core software engineering concepts such as **Multithreading**, **File I/O Streams**, **MVC Architecture**, and **Exception Handling**.

---

## 🚀 Key Features (Course Requirements)

### 1. Concurrency & Multithreading

**Problem:** Network requests to AI APIs are slow and freeze the UI.
**Solution:** Used `javafx.concurrent.Task` to run API calls on a background thread.
**Result:** UI stays responsive while the bot processes the request.

### 2. File I/O & Persistence

**Problem:** Chat history disappears after closing the app.
**Solution:** Added a “Save Conversation” feature using `FileOutputStream` with `try-with-resources`.
**Result:** Users can save their chat into a `.txt` file.

### 3. Exception Handling

**Implementation:** All critical operations wrapped in structured `try–catch`.
**Feedback:** Error messages shown through JavaFX `Alert` dialogs instead of crashing.

---

## 🛠 Tech Stack

| Component  | Technology                            |
| ---------- | ------------------------------------- |
| Language   | Java 21                               |
| Frontend   | JavaFX (FXML)                         |
| Build Tool | Maven                                 |
| AI Layer   | LangChain4j + Google Gemini 1.5 Flash |
| IDE        | VS Code / IntelliJ IDEA               |

---

## 📂 Project Structure (MVC)

```
src/main/java/com/chatbot/
├── controller/
│   └── ChatController.java
├── model/
│   └── Message.java
├── service/
│   └── GeminiService.java
├── util/
│   └── FileSaver.java
└── Main.java
```

---

## ⚙️ Setup & Installation

### Prerequisites

* Java **JDK 21**
* Maven **3.x**

### 1. Clone the Repository

```
git clone https://github.com/yourusername/javafx-gemini-chatbot.git
cd javafx-gemini-chatbot
```

### 2. Configure the API Key

This app requires a **Google Gemini API Key**.

#### Option A: Environment Variable (Recommended)

**Mac / Linux**

```
export GEMINI_API_KEY="your_api_key_here"
```

**Windows PowerShell**

```
$env:GEMINI_API_KEY="your_api_key_here"
```

#### Option B: Hardcode for Local Testing

Modify `GeminiService.java` (not recommended for GitHub commits).

### 3. Run the Application

```
mvn clean javafx:run
```

---

## 📸 Usage

1. Run using `mvn clean javafx:run`.
2. Type in the message box and send.
3. Wait for the Gemini response.
4. Click **Save Conversation to File** to export chat.

---

## 🧪 Course Objectives Demonstrated

| Concept            | Implementation                     | Location                       |
| ------------------ | ---------------------------------- | ------------------------------ |
| Multithreading     | `Task<String>` on worker thread    | ChatController.java            |
| File I/O           | `FileOutputStream`                 | FileSaver.java                 |
| Exception Handling | `IOException` + API error handling | GeminiService.java, Controller |
| MVC Architecture   | Clear separation                   | Project structure              |

---

## 🐛 Troubleshooting

**Issue:** `package javafx.application does not exist`
**Fix:** Run with Maven: `mvn clean javafx:run`.

**Issue:** `CRITICAL: GEMINI_API_KEY not set`
**Fix:** Set the environment variable.

**Issue:** `duplicate class: main.java.chatbot.model.Message`
**Fix:** Ensure package name is:

```
package com.chatbot.model;
```

---

## 🔒 Security Best Practices

* Store API keys using environment variables
* `.gitignore` includes `.idea/`, `.vscode/`, `target/`
* Error dialogs avoid exposing stack traces

---

## 👨‍💻 Author

**Mohammed Alharbi**
FCIT – King Abdulaziz University
CPIT-305 Project — Fall 2025

---

## 🙏 Acknowledgments

* LangChain4j
* OpenJFX
* Google Gemini API
