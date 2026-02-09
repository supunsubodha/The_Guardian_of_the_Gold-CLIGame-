🛡️ The Guardian of the Gold
A Java console-based strategy game where you play as a government agent protecting an ancient treasure from a thief named Magnus. Navigate through traps, avoid Magnus, and reach the treasure before he does.

🎮 Game Overview
You control a guardian agent on a 10×10 grid map
Each level has:

  Traps (x)
  
  A hidden treasure (💰)
  
  A moving enemy (Magnus 🦹🏽)

Magnus follows predefined movement paths

If Magnus reaches the treasure or catches you → Game Over

Progress and levels are saved using a database

🧩 Features

🗺️ Multiple handcrafted levels

🤖 Enemy movement logic (Magnus AI paths)

💾 Persistent save system ( MySQL)

🔊 Sound effects & background music

🎨 Colored console output

👤 Multiple users + default user

♻️ Auto-reset and level progression

🛠️ Technologies Used

Java (JDK 8+)

JDBC

SQLite / MySQL

Console-based UI

Java Sound API


▶️ How to Run

1️⃣ Clone the repository

git clone https://github.com/your-username/guardian-of-the-gold.git
cd guardian-of-the-gold

2️⃣ Compile

javac *.java

3️⃣ Run

java Main


💾 Database Setup

No setup required

Table auto-created on first run


🎯 Controls

| Key | Action     |
| --- | ---------- |
| W   | Move Up    |
| S   | Move Down  |
| A   | Move Left  |
| D   | Move Right |


❌ Game Over Conditions

You step on a trap 💣

Magnus reaches the treasure 💰

Magnus catches you 🦹🏽


🏆 Level Completion

Reach the treasure before Magnus

Progress saved automatically

New level unlocked

📄 License

This project is open-source and free to use for learning purposes.
