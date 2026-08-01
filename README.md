# XSKCore

A custom core plugin for PaperMC, built from scratch in Java.

XSKCore is my personal Minecraft server plugin focused on learning software engineering, plugin development, and building production-quality server features without relying on existing core plugins.

---

## ✨ Features

### Authentication
- Register/Login system
- Persistent accounts using YAML
- Login required after every reconnect
- Player movement locked until login

### Gameplay
- Starter kit (first join only)
- `/back` command
- Death location saving
- Welcome messages

---

## 🛠 Tech Stack

- Java 21
- Maven
- Paper API 1.20.4
- Git
- YAML Configuration

---

## 📂 Project Structure

```
src/
 ├── commands/
 ├── data/
 ├── listeners/
 ├── managers/
 └── resources/
```

---

## 🚀 Planned Features

### Authentication
- [x] Register/Login
- [x] Persistent accounts
- [ ] SHA-256 password hashing
- [ ] Password change command
- [ ] Failed login protection
- [ ] Login timeout

### Player Utilities
- [x] Starter Kit
- [x] Death Coordinates
- [x] /back
- [ ] Homes
- [ ] Warps
- [ ] RTP

### Economy
- [ ] Economy System
- [ ] Daily Rewards
- [ ] Shops

### Administration
- [ ] Permissions
- [ ] Staff Tools
- [ ] Moderation Commands
- [ ] GUI Menus

### Storage
- [x] YAML
- [ ] SQLite
- [ ] MySQL Support

---

## 📖 Learning Goals

This project is being built to improve my understanding of:

- Java
- Object-Oriented Programming
- Event-driven programming
- File persistence
- Software architecture
- Version control with Git
- Minecraft plugin development

---

## ⚡ Build

```bash
mvn clean package
```

The compiled plugin will be located in:

```
target/XSKCore-1.0.0.jar
```

---

## 🎮 Compatibility

- Minecraft 1.20.4
- PaperMC

---

## 📜 License

This project is currently intended for personal learning and development.