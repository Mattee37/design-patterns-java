# Strategy Pattern

## Intent

Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

## Problem

You need to use different variants of an algorithm within an object and switch between them at runtime.

## Solution

Extract each algorithm into separate classes with a common interface, and let the context delegate to a strategy object.

## Diagram

```mermaid
classDiagram
    class PaymentStrategy {
        <<interface>>
        +pay(amount): void
    }
    
    class CreditCardPayment {
        -cardNumber: String
        +pay(amount): void
    }
    
    class PayPalPayment {
        -email: String
        +pay(amount): void
    }
    
    class CryptoPayment {
        -wallet: String
        +pay(amount): void
    }
    
    class ShoppingCart {
        -strategy: PaymentStrategy
        +setPaymentMethod(strategy): void
        +checkout(amount): void
    }
    
    PaymentStrategy <|.. CreditCardPayment
    PaymentStrategy <|.. PayPalPayment
    PaymentStrategy <|.. CryptoPayment
    ShoppingCart o-- PaymentStrategy
```

## Our Example

We implement a checkout system with multiple payment methods:

- **`PaymentStrategy.java`**: The `PaymentStrategy` interface
- **`CreditCardPayment.java`**, **`PayPalPayment.java`**, **`CryptoPayment.java`**: payment strategies
- **`ShoppingCart.java`**: context that delegates to the current strategy
- **`StrategyDemo.java`**: Demonstrates switching payment methods

## Runtime Switching

```mermaid
sequenceDiagram
    participant Cart
    participant CreditCard
    participant PayPal
    participant Crypto
    
    Cart->>CreditCard: setPaymentMethod()
    Cart->>CreditCard: checkout($100)
    CreditCard-->>Cart: "Paid $100 with card"
    
    Cart->>PayPal: setPaymentMethod()
    Cart->>PayPal: checkout($50)
    PayPal-->>Cart: "Paid $50 via PayPal"
    
    Cart->>Crypto: setPaymentMethod()
    Cart->>Crypto: checkout($200)
    Crypto-->>Cart: "Paid $200 with crypto"
```

## Strategy vs State

| Strategy | State |
|----------|-------|
| Algorithms are interchangeable | Behavior changes with state |
| Client chooses the strategy | State changes itself |
| Strategies are independent | States know about each other |

## When to Use

- When you have many related classes that differ only in behavior
- When you need different variants of an algorithm
- When you want to avoid conditional statements for selecting behavior
- When an algorithm uses data clients shouldn't know about

## Run

```bash
mvn -q compile exec:java -Dexec.mainClass=com.mattee37.patterns.behavioral.strategy.StrategyDemo
```
