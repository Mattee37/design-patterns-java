# Flyweight Pattern

## Intent

Use sharing to support large numbers of fine-grained objects efficiently.

## Problem

Your application needs to create a huge number of similar objects, consuming too much memory.

## Solution

Share the common (intrinsic) state between objects and pass the unique (extrinsic) state to methods when needed.

## Diagram

```mermaid
classDiagram
    class TreeType {
        <<interface>>
        +name: string
        +color: string
        +texture: string
        +draw(x, y): void
    }

    class TreeFactory {
        -treeTypes: Map~string, TreeType~$
        +getTreeType(name, color, texture): TreeType$
        +getTypeCount(): number$
    }

    class Tree {
        -x: number
        -y: number
        -type: TreeType
        +draw(): void
    }

    TreeFactory ..> TreeType : creates/reuses
    Tree o-- TreeType : references
```

## Our Example

We implement a forest with shared tree types:

- **`TreeType.java`**: Interface (shared intrinsic state), implemented by the package-private `TreeTypeImpl` record
- **`TreeFactory.java`**: Manages shared types, `Tree.java` holds unique position
- **`FlyweightDemo.java`**: Creates many trees with few shared types

## Memory Optimization

```mermaid
flowchart TB
    subgraph "Without Flyweight (8 objects)"
        T1[Tree: Oak, green, rough, x:10, y:20]
        T2[Tree: Oak, green, rough, x:30, y:40]
        T3[Tree: Oak, green, rough, x:50, y:60]
        T4[Tree: Pine, dark, smooth, x:70, y:80]
    end

    subgraph "With Flyweight (6 objects)"
        TT1[TreeType: Oak]
        TT2[TreeType: Pine]
        TR1[Tree: x:10, y:20] --> TT1
        TR2[Tree: x:30, y:40] --> TT1
        TR3[Tree: x:50, y:60] --> TT1
        TR4[Tree: x:70, y:80] --> TT2
    end
```

## Key Concepts

- **Intrinsic state**: Shared data stored in flyweight (name, color, texture)
- **Extrinsic state**: Unique data stored in context (x, y position)

## When to Use

- When your app uses a large number of objects
- When storage costs are high because of the quantity of objects
- When most object state can be made extrinsic
- When many objects can be replaced by few shared objects

## Run

```bash
mvn -q compile exec:java -Dexec.mainClass=com.mattee37.patterns.structural.flyweight.FlyweightDemo
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
