# 💬 Telegram Lite (Java Spring Boot)

![Java](https://img.shields.io/badge/Java-17%2B-orange) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green) ![MongoDB](https://img.shields.io/badge/MongoDB-Atlas-forestgreen) ![Docker](https://img.shields.io/badge/Docker-Ready-blue)

A robust, real-time private messaging application built with **Java Spring Boot** and **WebSockets**. It features a modern **Dark Mode UI**, persistent chat history via **MongoDB**, and is containerized with **Docker** for easy deployment.

![App Screenshot](https://via.placeholder.com/800x400?text=Upload+Your+App+Screenshot+Here)

## ✨ Key Features

*   **⚡ Real-Time Messaging:** Instant delivery using **WebSockets** (STOMP protocol).
*   **🔒 1-on-1 Private Chat:** Click on any user from the sidebar to start a private conversation.
*   **💾 Persistent History:** Messages are saved in **MongoDB Atlas** so they never get lost.
*   **🌙 Dark Mode UI:** A clean, Telegram-inspired dark interface for comfortable chatting.
*   **👤 User System:** Simple Login and Registration system.
*   **🐳 Dockerized:** Fully configured `Dockerfile` for cloud deployment (Render, AWS, etc.).

## 🛠️ Technology Stack

*   **Backend:** Java 17, Spring Boot 3 (Web, WebSocket, Data MongoDB)
*   **Database:** MongoDB Atlas (Cloud NoSQL)
*   **Frontend:** HTML5, CSS3, Vanilla JavaScript (SockJS, Stomp.js)
*   **Build Tool:** Maven
*   **Deployment:** Docker

## 🚀 How to Run Locally

### Prerequisites
*   Java 17 or higher
*   Maven (Optional, wrapper included)
*   A MongoDB Atlas Connection String

### 1. Clone the Repository
```bash
git clone https://github.com/YOUR_USERNAME/simple-chat.git
cd simple-chat