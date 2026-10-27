# Chain of Responsibility Pattern

## Intent

Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.

## Problem

You have multiple handlers that could process a request, and you want to decouple the sender from the specific handler.

## Solution

Create a chain of handler objects. Each handler decides whether to process the request or pass it to the next handler in the chain.

## Diagram

```mermaid
classDiagram
    class Handler {
        <<interface>>
        +setNext(handler): Handler
        +handle(request): void
    }

    class BaseHandler {
        <<abstract>>
        -nextHandler: Handler
        +setNext(handler): Handler
        +handle(request): void
    }

    class BasicSupport {
        +handle(request): void
    }

    class TechnicalSupport {
        +handle(request): void
    }

    class BillingSupport {
        +handle(request): void
    }

    Handler <|.. BaseHandler
    BaseHandler <|-- BasicSupport
    BaseHandler <|-- TechnicalSupport
    BaseHandler <|-- BillingSupport
```

## Our Example

We implement a customer support system:

- **`SupportRequest.java`**: Record with `Type` enum (`BASIC`, `TECHNICAL`, `BILLING`) and message
- **`Handler.java`**, **`BaseHandler.java`**: Interface and abstract base with the chain link
- **`BasicSupport.java`**, **`TechnicalSupport.java`**, **`BillingSupport.java`**: Concrete handlers
- **`ChainOfResponsibilityDemo.java`**: Builds the chain and processes different requests

## Request Flow

```mermaid
flowchart LR
    R[Request] --> B[BasicSupport]
    B -->|Can't handle| T[TechnicalSupport]
    T -->|Can't handle| BI[BillingSupport]
    BI -->|Can't handle| E[No Handler]

    B -->|Handles basic| D1[Done]
    T -->|Handles tech| D2[Done]
    BI -->|Handles billing| D3[Done]
```

## Chain Setup

```java
BasicSupport basic = new BasicSupport();
TechnicalSupport technical = new TechnicalSupport();
BillingSupport billing = new BillingSupport();

basic.setNext(technical).setNext(billing);
```

## When to Use

- When more than one object may handle a request
- When you want to issue a request without specifying the receiver
- When the set of handlers should be specified dynamically

## Run

```bash
mvn -q compile exec:java -Dexec.mainClass="com.mattee37.patterns.behavioral.chainofresponsibility.ChainOfResponsibilityDemo"
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
