# Observer Pattern

## Intent

Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

## Problem

You need to notify multiple objects when an object's state changes, without coupling them tightly.

## Solution

Create a subscription mechanism where observers register with a subject and get notified of changes.

## Diagram

```mermaid
classDiagram
    class Subject {
        <<interface>>
        +subscribe(observer): void
        +unsubscribe(observer): void
        +notify(message): void
    }
    
    class Observer {
        <<interface>>
        +update(message): void
    }
    
    class Newsletter {
        -subscribers: List~Observer~
        +subscribe(observer): void
        +unsubscribe(observer): void
        +notify(message): void
        +publish(article): void
    }
    
    class Subscriber {
        -name: String
        +update(message): void
    }
    
    Subject <|.. Newsletter
    Observer <|.. Subscriber
    Newsletter o-- Observer : notifies
```

## Our Example

We implement a newsletter subscription system:

- **`Observer.java`** / **`Subject.java`**: `Observer` and `Subject` interfaces
- **`Newsletter.java`** (subject) and **`Subscriber.java`** (observer)
- **`ObserverDemo.java`**: Demonstrates subscribe, publish, and unsubscribe

## Notification Flow

```mermaid
sequenceDiagram
    participant Newsletter
    participant Alice
    participant Bob
    participant Charlie
    
    Newsletter->>Newsletter: publish("TypeScript 5.0!")
    Newsletter->>Alice: update("TypeScript 5.0!")
    Newsletter->>Bob: update("TypeScript 5.0!")
    Newsletter->>Charlie: update("TypeScript 5.0!")
    
    Bob->>Newsletter: unsubscribe()
    
    Newsletter->>Newsletter: publish("Bun 1.0!")
    Newsletter->>Alice: update("Bun 1.0!")
    Newsletter->>Charlie: update("Bun 1.0!")
    Note right of Bob: Not notified
```

## Real-World Examples

- Event listeners in DOM
- RxJS Observables
- React state management
- Pub/Sub messaging systems

## When to Use

- When changes to one object require changing others, and you don't know how many
- When an object should notify others without assumptions about who they are
- When you need a broadcast communication mechanism

## Run

```bash
mvn -q compile exec:java -Dexec.mainClass=com.mattee37.patterns.behavioral.observer.ObserverDemo
```
