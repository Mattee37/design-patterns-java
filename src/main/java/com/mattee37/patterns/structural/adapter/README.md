# Adapter Pattern

## Intent

Convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.

## Problem

You have a class with an interface that doesn't match what your client code expects, and you can't modify the original class.

## Solution

Create an adapter class that wraps the incompatible object and translates calls to the expected interface.

## Diagram

```mermaid
classDiagram
    class MediaPlayer {
        <<interface>>
        +play(filename): void
    }

    class LegacyAudioPlayer {
        <<interface>>
        +playMp3(filename): void
    }

    class OldMp3Player {
        +playMp3(filename): void
    }

    class AudioPlayerAdapter {
        -legacyPlayer: LegacyAudioPlayer
        +play(filename): void
    }

    LegacyAudioPlayer <|.. OldMp3Player
    MediaPlayer <|.. AudioPlayerAdapter
    AudioPlayerAdapter o-- LegacyAudioPlayer : wraps
```

## Our Example

We adapt a legacy MP3 player to a modern media player interface:

- **`MediaPlayer.java`**: New interface clients expect
- **`LegacyAudioPlayer.java`** + **`OldMp3Player.java`**: The old class we can't modify
- **`AudioPlayerAdapter.java`**: Wraps the legacy player
- **`AdapterDemo.java`**: Client uses the new interface seamlessly

## Flow

```mermaid
sequenceDiagram
    Client->>AudioPlayerAdapter: play("song.mp3")
    AudioPlayerAdapter->>OldMp3Player: playMp3("song.mp3")
    OldMp3Player-->>AudioPlayerAdapter: plays audio
    AudioPlayerAdapter-->>Client: done
```

## When to Use

- When you want to use an existing class but its interface doesn't match what you need
- When you need to create a reusable class that cooperates with unrelated classes
- When integrating with third-party or legacy code

## Run

```bash
mvn -q compile exec:java -Dexec.mainClass=com.mattee37.patterns.structural.adapter.AdapterDemo
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
