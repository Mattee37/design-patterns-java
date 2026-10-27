# Prototype Pattern

## Intent

Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.

## Problem

You need to create copies of existing objects without depending on their concrete classes, or when object creation is expensive.

## Solution

Implement a `clone()` method in your objects that returns a copy of the object.

## Diagram

```mermaid
classDiagram
    class Prototype~T~ {
        <<interface>>
        +clone(): T
    }

    class Document {
        +title: string
        +content: string
        +author: string
        +clone(): Document
        +print(): void
    }

    Prototype~Document~ <|.. Document

    Document ..> Document : clones
```

## Our Example

We implement a document cloning system:

- **`Prototype.java`**: Defines the generic `Prototype<T>` interface
- **`Document.java`**: Implements `Document` class with `clone()` method
- **`PrototypeDemo.java`**: Creates a template and clones it for different contracts

## Usage Flow

```mermaid
flowchart LR
    A[Template Document] -->|clone| B[Contract for John]
    A -->|clone| C[Contract for Jane]
    A -->|unchanged| A
```

## When to Use

- When object creation is more expensive than copying
- When you need to create objects similar to existing ones
- When you want to reduce the number of subclasses

## Run

Run `com.mattee37.patterns.creational.prototype.PrototypeDemo#main`.

## Diagrams

### Class
![Class diagram](diagrams/class.png)

### State
![State diagram](diagrams/state.png)

### Sequence
![Sequence diagram](diagrams/sequence.png)

### Use Case
![Use case diagram](diagrams/usecase.png)
