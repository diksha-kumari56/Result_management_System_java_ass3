# 🎓 Student Result Management System (Java)

A simple **menu-driven Java application** to manage student results using:

* Custom Exceptions
* Exception Handling (InputMismatchException)
* Arrays
* Basic OOP Concepts
* Console-based User Interaction

This program allows adding students, validating marks, calculating averages, and checking pass/fail status.

---

## ✨ Features

### ✅ Add Student

* Accepts roll number, name, and marks for 3 subjects
* Validates marks using **custom InvalidMarksException**
* Ensures marks are between 0–100

### ✅ Show Student Details

* Search student by roll number
* Displays:

  * Roll number
  * Name
  * Marks
  * Average
  * Pass/Fail status (average ≥ 33 = Pass)

### ✅ Exception Handling

* Handles wrong input types
* Handles invalid marks
* Handles missing students

### ✅ User-Friendly Menu

```
1. Add Student
2. Show Student Details
3. Exit
```

---

## 🧠 System Structure

### **Classes**

| Class                   | Description                                     |
| ----------------------- | ----------------------------------------------- |
| `InvalidMarksException` | Custom exception for invalid marks              |
| `Student`               | Model class storing student info & logic        |
| `ResultManager`         | Main class handling menu, input, and operations |

---

## 📌 Mark Validation Rule

Marks must be between **0 and 100** for all subjects.
If not, program throws:

```
InvalidMarksException: Invalid marks for subject X: [value]
```

---

## 📊 Result Calculation

* **Average** = (m1 + m2 + m3) / 3
* **Result**:

  * Pass → average ≥ 33
  * Fail → average < 33

---

## ▶️ How to Run

1. Save your file as **ResultManager.java**
2. Compile:

```
javac ResultManager.java
```

3. Run:

```
java ResultManager
```

---

## 🧪 Sample Flow

```
===== Student Result Management System =====
1. Add Student
2. Show Student Details
3. Exit
Enter your choice: 1
Enter Roll Number: 101
Enter Student Name: Riya
Enter marks for subject 1: 78
Enter marks for subject 2: 85
Enter marks for subject 3: 90
Student added successfully.
```

---

## 🔍 Sample Output for Search

```
Roll Number: 101
Student Name: Riya
Marks: 78 85 90
Average: 84.33
Result: Pass
```

---
