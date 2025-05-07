# Java Full Stack Social Media App 🚀

(Visit this link for frontend code -> https://github.com/Vaibhav4228/frontend)

Welcome to a revolutionary opportunity in the world of social media! This Java Full Stack Social Media App is meticulously crafted using modern, robust technologies including:

**Frontend**: React.js, Redux, Tailwind CSS, Material UI (MUI)  
**Backend**: Spring Boot, Spring Security, Swagger (OpenAPI)  
**Database**: MySQL  
**Cloud Services**: Cloudinary for media storage  

---

## 🔥 Unleash Innovation

This project is a powerful, production-ready social media platform that brings together seamless functionality and sleek design. The source code lays the foundation for a rich user experience and supports future scalability.

---

## 🚀 Key Features

- **Create & Engage**: Users can create posts, like, comment, and save them.
- **Real-Time Chat**: Engage in instant messaging with live chat support.
- **Security at Core**: Authentication & authorization using Spring Security.
- **Reels Feature**: Create and view short video content (Reels).
- **Profile Management**: Update profile information with ease.
- **Forgot Password**: Secure password reset flow.

---

## 📘 API Documentation (Swagger)

- Base URL: `http://localhost:5454`
- Swagger UI: [http://localhost:5454/swagger-ui/index.html](http://localhost:5454/swagger-ui/index.html)
- OpenAPI JSON: [http://localhost:5454/v3/api-docs](http://localhost:5454/v3/api-docs)

---

## 📌 API Endpoints Overview

### 🧑‍💼 User Controller

| Method | Endpoint | Description |
|--------|----------|-------------|
| PUT | `/api/users/update` | Update user profile |
| PUT | `/api/users/follow/{followUserId}` | Follow another user |
| GET | `/api/users/{id}` | Get user by ID |
| GET | `/api/users/search` | Search users |
| GET | `/api/users/profile` | Get current user's profile |

### 📝 Post Controller

| Method | Endpoint | Description |
|--------|----------|-------------|
| PUT | `/api/posts/{postId}/save` | Save or unsave a post |
| PUT | `/api/posts/like/{postId}` | Like or unlike a post |
| GET | `/api/posts` | Get all posts |
| POST | `/api/posts` | Create a new post |
| GET | `/api/posts/{postId}` | Get post by ID |
| GET | `/api/posts/user/{userId}` | Get all posts by a user |
| DELETE | `/api/posts/delete/{postId}` | Delete a post |

### 💬 Comment Controller

| Method | Endpoint | Description |
|--------|----------|-------------|
| PUT | `/api/comments/like/{commentId}` | Like or unlike a comment |
| POST | `/api/comments/{postId}` | Add a comment to a post |

### 🔐 Reset Password Controller

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/reset-password` | Send reset password email |
| POST | `/reset-password/reset` | Reset the password |

### 🔑 Auth Controller

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/signup` | Register new user |
| POST | `/auth/signin` | Login user |

### 📖 Story Controller

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/stories/create` | Create a new story |
| GET | `/api/stories/{userId}` | Get stories by user |
| GET | `/api/stories/all` | Get all stories |

### 🎥 Reels Controller

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/reels` | Get all reels |
| POST | `/api/reels` | Create a new reel |
| GET | `/api/reels/user/{userId}` | Get user reels |

### ✉️ Message Controller

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/messages` | Send a message |
| GET | `/api/messages/chat/{chatId}` | Get messages in chat |
| DELETE | `/api/messages/delete/{messageId}` | Delete a message |

### 💬 Chat Controller

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/chats/single` | Create/get single chat |
| GET | `/api/chats/{chatId}` | Get chat by ID |
| GET | `/api/chats/user` | Get all user chats |

### 🏠 Home Controller

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Health check/home |

---

## 🧩 Schemas Used

- User, UserDto, UserProfileDto
- Post, PostDto
- Comment, CommentDto
- Story, StoryDto
- Reels, ReelsDto
- SendMessageRequest, MessageDto
- ChatDto, SingleChatRequest
- LoginRequest, AuthResponse, ApiResponse
- ResetPasswordRequest

---

## 💡 Future Enhancements

- Push Notifications
- Image compression and optimization
- AI-based content suggestions

---

## 🛠️ Tech Stack

- **Frontend**: React, Redux, Tailwind CSS, MUI  
- **Backend**: Spring Boot, Spring Security  
- **Database**: PostgresSQl  
- **Media**: Cloudinary  
- **Docs**: Swagger (OpenAPI 3.0)
- **Deployemnt**: Docker hub and kubernates Clusters (docker pull vaibhav990/vsocial-backend, and docker pull vaibhav990/vsocial-frontend)

---

## 👏 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 📄 License

This project is open-source. You may use, modify, and distribute it freely with attribution.

---
