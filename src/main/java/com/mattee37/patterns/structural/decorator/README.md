# Decorator Pattern

## Intent

Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

## Problem

You need to add behavior to individual objects without affecting other objects of the same class, and subclassing would create too many combinations.

## Solution

Wrap the original object with decorator objects that add new behavior while delegating to the wrapped object.

## Diagram

```mermaid
classDiagram
    class Coffee {
        <<interface>>
        +cost(): number
        +description(): string
    }

    class SimpleCoffee {
        +cost(): number
        +description(): string
    }

    class CoffeeDecorator {
        <<abstract>>
        #coffee: Coffee
        +cost(): number
        +description(): string
    }

    class MilkDecorator {
        +cost(): number
        +description(): string
    }

    class SugarDecorator {
        +cost(): number
        +description(): string
    }

    Coffee <|.. SimpleCoffee
    Coffee <|.. CoffeeDecorator
    CoffeeDecorator <|-- MilkDecorator
    CoffeeDecorator <|-- SugarDecorator
    CoffeeDecorator o-- Coffee : wraps
```

## Our Example

We implement a coffee ordering system with add-ons:

- **`Coffee.java`**: Defines the `Coffee` interface
- **`SimpleCoffee.java`** and decorators (`MilkDecorator`, `SugarDecorator`, `WhippedCreamDecorator`) extending `CoffeeDecorator`
- **`DecoratorDemo.java`**: Builds decorated coffees with cumulative pricing

## Decorator Chain

```mermaid
flowchart LR
    A[SimpleCoffee<br/>$2.00] --> B[+ Milk<br/>$0.50]
    B --> C[+ Sugar<br/>$0.25]
    C --> D[+ Whipped Cream<br/>$0.75]
    D --> E[Total: $3.50]
```

## Key Usage

```java
Coffee coffee = new SimpleCoffee();                     // $2.00
coffee = new MilkDecorator(coffee);                     // $2.50
coffee = new SugarDecorator(coffee);                    // $2.75
coffee = new WhippedCreamDecorator(coffee);             // $3.50
```

## When to Use

- When you need to add responsibilities to objects dynamically
- When extension by subclassing is impractical
- When you need to combine multiple behaviors flexibly

## Run

```bash
mvn -q compile exec:java -Dexec.mainClass=com.mattee37.patterns.structural.decorator.DecoratorDemo
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
