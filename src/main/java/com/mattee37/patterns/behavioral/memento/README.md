# Memento Pattern

## Intent

Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this state later.

## Problem

You need to save and restore the previous state of an object without exposing its implementation details.

## Solution

Create memento objects that store snapshots of the originator's state, managed by a caretaker.

## Diagram

```mermaid
classDiagram
    class Memento {
        <<interface>>
        +getState(): String
        +getDate(): String
    }

    class EditorMemento {
        -state: String
        -date: Instant
        +getState(): String
        +getDate(): String
    }

    class Editor {
        -content: String
        +type(text): void
        +getContent(): String
        +save(): Memento
        +restore(memento): void
    }

    class History {
        -mementos: Deque~Memento~
        +push(memento): void
        +pop(): Optional~Memento~
    }

    Memento <|.. EditorMemento
    Editor ..> EditorMemento : creates
    History o-- Memento : stores
```

## Our Example

We implement a text editor with save/restore:

- **`Memento.java`**: Defines the `Memento` interface
- **`Editor.java`**: `Editor` (originator) and the package-private `EditorMemento` record — only the Editor creates and reads its snapshots
- **`History.java`**: `History` (caretaker)
- **`MementoDemo.java`**: Demonstrates saving and restoring states

## State Flow

```mermaid
sequenceDiagram
    participant Editor
    participant History
    participant Memento

    Editor->>Editor: type("Hello")
    Editor->>Memento: save()
    Memento-->>History: push
    Note right of History: ["Hello"]

    Editor->>Editor: type(" World")
    Editor->>Memento: save()
    Memento-->>History: push
    Note right of History: ["Hello", "Hello World"]

    Editor->>Editor: type("!!!")
    Note right of Editor: "Hello World!!!"

    History-->>Memento: pop()
    Memento->>Editor: restore()
    Note right of Editor: "Hello World"
```

## Roles

| Role | Class | Responsibility |
|------|-------|----------------|
| **Originator** | `Editor` | Creates and restores from mementos |
| **Memento** | `EditorMemento` | Stores state snapshot |
| **Caretaker** | `History` | Manages memento lifecycle |

## When to Use

- When you need to save/restore an object's state (undo/redo, checkpoints)
- When direct access to state would violate encapsulation
- When you need to implement rollback functionality

## Run

```bash
mvn -q compile exec:java -Dexec.mainClass="com.mattee37.patterns.behavioral.memento.MementoDemo"
```
