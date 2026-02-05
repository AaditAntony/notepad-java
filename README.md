📝 Notepad Backend API
A basic Spring Boot backend for a Notepad Application that supports user registration, login, and CRUD operations for notes.

🚀 Features
✅ User Management
Register a user using username and password.

Login validation using username and password.

No email, JWT, or session features included (simple in-memory validation for now).

✅ Note Management
Create a note with a title and content, linked to a user.

Get all notes for a specific user.

Update a note (by ID).

Delete a note (by ID).

🛠️ Technologies Used
Java 17

Spring Boot

Spring Data JPA

MySQL

Lombok

📂 Project Structure

src/
├── controller/
│   ├── UserController.java
│   └── NoteController.java
├── model/
│   ├── User.java
│   └── Note.java
├── repository/
│   ├── UserRepository.java
│   └── NoteRepository.java
├── service/
│   ├── UserService.java
│   └── NoteService.java

code
code
