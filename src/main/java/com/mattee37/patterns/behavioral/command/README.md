# Command Pattern

## Intent

Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

## Problem

You need to decouple the object that invokes an operation from the one that performs it, and support undo/redo.

## Solution

Create command objects that encapsulate the action and its parameters, with `execute()` and `undo()` methods.

## Diagram

```mermaid
classDiagram
    class Command {
        <<interface>>
        +execute(): void
        +undo(): void
    }

    class WriteCommand {
        -editor: TextEditor
        -text: String
        +execute(): void
        +undo(): void
    }

    class TextEditor {
        -content: String
        +write(text): void
        +deleteLast(count): void
        +print(): void
    }

    class CommandHistory {
        -history: Deque~Command~
        +execute(command): void
        +undo(): void
    }

    Command <|.. WriteCommand
    WriteCommand o-- TextEditor
    CommandHistory o-- Command
```

## Our Example

We implement a text editor with undo:

- **`Command.java`**: Defines the `Command` interface
- **`TextEditor.java`**, **`WriteCommand.java`**, **`CommandHistory.java`**: Receiver, concrete command, and invoker
- **`CommandDemo.java`**: Demonstrates writing and undoing

## Undo Flow

```mermaid
sequenceDiagram
    participant Client
    participant History
    participant Command
    participant Editor

    Client->>History: execute(WriteCommand("Hello"))
    History->>Command: execute()
    Command->>Editor: write("Hello")
    Note right of Editor: content = "Hello"

    Client->>History: execute(WriteCommand(" World"))
    History->>Command: execute()
    Command->>Editor: write(" World")
    Note right of Editor: content = "Hello World"

    Client->>History: undo()
    History->>Command: undo()
    Command->>Editor: deleteLast(6)
    Note right of Editor: content = "Hello"
```

## When to Use

- When you want to parameterize objects with operations
- When you need to queue, specify, and execute requests at different times
- When you need undo/redo functionality
- When you want to log changes for crash recovery

## Run

```bash
mvn -q compile exec:java -Dexec.mainClass="com.mattee37.patterns.behavioral.command.CommandDemo"
```

## Diagrams

### Class
![Class diagram](diagrams/class.png)

### State
![State diagram](diagrams/state.png)

### Sequence
![Sequence diagram](diagrams/sequence.png)

### Use Case
![Use case diagram](diagrams/usecase.png)
