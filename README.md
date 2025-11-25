# Counter App (package: `com.CounterApp`)

A simple Jetpack Compose Android application that demonstrates independent counters with adjustable starting values. This app uses clean state management and modern Compose UI elements.

---

## ✨ Features

* Three **independent counters** arranged in a column
* Each counter has:

  * A **TextField** to set the starting value
  * A **"+" button** to increment
  * A **"-" button** to decrement
* Fully state-driven using `remember` and `mutableStateOf`
* Simple and beginner‑friendly structure

---

## 📂 Project Structure

```
app/src/main/java/com/CounterApp/
  ├─ MainActivity.kt       # Entry point
  ├─ CounterScreen.kt      # Composable UI for individual counters
  └─ ui/theme/Theme.kt     # Material theme setup
```

---

## ▶️ How to Run

1. Open the project in **Android Studio**.
2. Make sure Compose is enabled (default in new projects).
3. Run the app on an emulator or physical device.
4. Use the text fields to enter starting values and press + or - to adjust each counter.

---

## 📘 Example UI (Concept)

Each counter row looks like this:

```
[ - ]   [  TextField (value)  ]   [ + ]
```

Three such rows are stacked using a Column.

---

## 🛠️ Dependencies

* Jetpack Compose
* Material3 UI Components
* Kotlin

All included automatically with the Compose Activity template.

---

## 📄 License

This example is free for personal or educational use.
