# Builder Pattern

## Intent

Separate the construction of a complex object from its representation so that the same construction process can create different representations.

## Problem

You need to create complex objects with many optional parameters, and constructor telescoping becomes unwieldy.

## Solution

Extract the object construction code into a separate builder class with a fluent interface that allows step-by-step construction.

## Diagram

```mermaid
classDiagram
    class Pizza {
        +size: string
        +cheese: boolean
        +pepperoni: boolean
        +mushrooms: boolean
        +olives: boolean
    }

    class PizzaBuilder {
        -pizza: Pizza
        +setSize(size): this
        +addCheese(): this
        +addPepperoni(): this
        +addMushrooms(): this
        +addOlives(): this
        +build(): Pizza
        -reset(): void
    }

    PizzaBuilder ..> Pizza : builds
```

## Our Example

We implement a pizza builder with a fluent API:

- **`Pizza.java`**: Immutable `Pizza` record with all properties
- **`PizzaBuilder.java`**: Implements `PizzaBuilder` with chainable methods
- **`BuilderDemo.java`**: Creates different pizzas using the builder

## Key Features

```java
Pizza pizza = new PizzaBuilder()
    .setSize(Pizza.Size.LARGE)
    .addCheese()
    .addPepperoni()
    .build();
```

## When to Use

- When creating objects with many optional parameters
- When you want to create different representations of the same product
- When construction involves multiple steps that need to be executed in a specific order

## Run

Run `com.mattee37.patterns.creational.builder.BuilderDemo#main`.
