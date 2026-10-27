# Facade Pattern

## Intent

Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

## Problem

A complex subsystem has many interdependent classes, making it difficult for clients to use correctly.

## Solution

Create a facade class that provides a simple interface to the complex subsystem, coordinating the subsystem objects.

## Diagram

```mermaid
classDiagram
    class HomeTheaterFacade {
        -tv: TV
        -sound: SoundSystem
        -player: StreamingPlayer
        -lights: Lights
        +watchMovie(movie): void
        +endMovie(): void
    }

    class TV {
        +on(): void
        +off(): void
    }

    class SoundSystem {
        +on(): void
        +off(): void
        +setVolume(level): void
    }

    class StreamingPlayer {
        +on(): void
        +off(): void
        +play(movie): void
        +stop(): void
    }

    class Lights {
        +dim(level): void
        +on(): void
    }

    HomeTheaterFacade o-- TV
    HomeTheaterFacade o-- SoundSystem
    HomeTheaterFacade o-- StreamingPlayer
    HomeTheaterFacade o-- Lights
```

## Our Example

We implement a home theater system facade:

- **`Subsystems.java`**: Individual components (`TV`, `SoundSystem`, `StreamingPlayer`, `Lights`), package-private
- **`HomeTheaterFacade.java`**: Simplifies complex operations
- **`FacadeDemo.java`**: Client uses simple `watchMovie()` and `endMovie()` methods

## Simplification

```mermaid
sequenceDiagram
    participant Client
    participant Facade
    participant Lights
    participant TV
    participant Sound
    participant Player

    Client->>Facade: watchMovie("The Matrix")
    Facade->>Lights: dim(10%)
    Facade->>TV: on()
    Facade->>Sound: on()
    Facade->>Sound: setVolume(50)
    Facade->>Player: on()
    Facade->>Player: play("The Matrix")
```

Without the facade, the client would need to call 6 methods on 4 different objects!

## When to Use

- When you want to provide a simple interface to a complex subsystem
- When there are many dependencies between clients and implementation classes
- When you want to layer your subsystems

## Run

```bash
mvn -q compile exec:java -Dexec.mainClass=com.mattee37.patterns.structural.facade.FacadeDemo
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
