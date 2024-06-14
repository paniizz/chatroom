# Simple Console Chat Room

This project is a simple console-based chat room implemented using Java. The server receives messages from clients and broadcasts them to all connected clients.

## Contents

- [Features](#features)
- [Requirements](#requirements)
- [Installation and Setup](#installation-and-setup)
- [Usage](#usage)
- [License](#license)

## Features

- Multiple clients can connect to the server and chat with each other.
- Each client can choose a unique username.
- Messages from each client are broadcasted to all other connected clients.
- Notification when a user joins or leaves the chat.

## Requirements

- Java Development Kit (JDK) 8 or higher

## Installation and Setup

### Server

1. Compile the `ChatServer.java` file:
    ```sh
    javac ChatServer.java
    ```

2. Run the server:
    ```sh
    java ChatServer
    ```

### Client

1. Compile the `ChatClient.java` file:
    ```sh
    javac ChatClient.java
    ```

2. Run the client:
    ```sh
    java ChatClient
    ```

## Usage

1. Start the server by following the steps in the [Server](#server) section. The server will start listening for client connections on port `1234`.

2. Open multiple terminal windows and run the client in each by following the steps in the [Client](#client) section. Each client will prompt you to enter a username.

3. After entering the username, each client will be connected to the chat server and will receive messages from other clients. You can type and send messages which will be broadcasted to all connected clients.

### Example

```sh
# Terminal 1
Enter your username: User1
Connected to chat server
User1: Hello everyone!

# Terminal 2
Enter your username: User2
Connected to chat server
User1: Hello everyone!
User2: Hi User1!

# Terminal 3
Enter your username: User3
Connected to chat server
User1: Hello everyone!
User2: Hi User1!
User3: Hey guys!
