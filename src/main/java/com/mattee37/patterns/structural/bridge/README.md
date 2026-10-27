# Bridge Pattern

## Intent

Decouple an abstraction from its implementation so that the two can vary independently.

## Problem

You have a class hierarchy that grows in two dimensions (e.g., shapes and colors), leading to a class explosion.

## Solution

Separate the abstraction (what) from the implementation (how) by using composition instead of inheritance.

## Diagram

```mermaid
classDiagram
    class Device {
        <<interface>>
        +isEnabled(): boolean
        +enable(): void
        +disable(): void
        +getVolume(): number
        +setVolume(volume): void
    }

    class TV {
        -on: boolean
        -volume: number
        +isEnabled(): boolean
        +enable(): void
        +disable(): void
        +getVolume(): number
        +setVolume(volume): void
    }

    class Radio {
        -on: boolean
        -volume: number
        +isEnabled(): boolean
        +enable(): void
        +disable(): void
        +getVolume(): number
        +setVolume(volume): void
    }

    class RemoteControl {
        #device: Device
        +togglePower(): void
        +volumeUp(): void
        +volumeDown(): void
    }

    Device <|.. TV
    Device <|.. Radio
    RemoteControl o-- Device : controls
```

## Our Example

We implement a remote control system that can work with different devices:

- **`Device.java`**: Defines the `Device` interface
- **`TV.java`** / **`Radio.java`**: Device implementations
- **`RemoteControl.java`**: Abstraction that works with any device
- **`BridgeDemo.java`**: Same remote controls different devices

## Key Benefit

```mermaid
flowchart TB
    subgraph Without Bridge
        RC1[TVRemote] --> TV1[TV]
        RC2[RadioRemote] --> R1[Radio]
        RC3[TVAdvancedRemote] --> TV2[TV]
        RC4[RadioAdvancedRemote] --> R2[Radio]
    end

    subgraph With Bridge
        RC[RemoteControl] --> D[Device]
        D --> TV[TV]
        D --> Radio[Radio]
    end
```

## When to Use

- When you want to avoid permanent binding between abstraction and implementation
- When both abstraction and implementation should be extensible by subclassing
- When you have a class explosion from combining multiple dimensions

## Run

```bash
mvn -q compile exec:java -Dexec.mainClass=com.mattee37.patterns.structural.bridge.BridgeDemo
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
