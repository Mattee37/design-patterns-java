# Interpreter Pattern

## Intent

Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.

## Problem

You have a simple language or grammar that needs to be evaluated, and you want a flexible way to parse and execute it.

## Solution

Define an abstract syntax tree (AST) where each node is an expression class with an `interpret()` method that evaluates itself.

## Diagram

```mermaid
classDiagram
    class Expression {
        <<interface>>
        +interpret(context): double
    }

    class NumberExpression {
        -value: double
        +interpret(context): double
    }

    class VariableExpression {
        -name: String
        +interpret(context): double
    }

    class AddExpression {
        -left: Expression
        -right: Expression
        +interpret(context): double
    }

    class SubtractExpression {
        -left: Expression
        -right: Expression
        +interpret(context): double
    }

    class MultiplyExpression {
        -left: Expression
        -right: Expression
        +interpret(context): double
    }

    Expression <|.. NumberExpression
    Expression <|.. VariableExpression
    Expression <|.. AddExpression
    Expression <|.. SubtractExpression
    Expression <|.. MultiplyExpression
    AddExpression o-- Expression : left, right
    SubtractExpression o-- Expression : left, right
    MultiplyExpression o-- Expression : left, right
```

## Our Example

We implement a simple arithmetic expression evaluator:

- **`Expression.java`**: The expression interface; the context is a plain `Map<String, Double>` of variables
- **`NumberExpression.java`**, **`VariableExpression.java`**: Terminal (leaf) expressions — implemented as records
- **`AddExpression.java`**, **`SubtractExpression.java`**, **`MultiplyExpression.java`**, **`DivideExpression.java`**: Non-terminal (composite) expressions
- **`InterpreterDemo.java`**: Builds and evaluates expression trees

## Expression Tree

For `(x + y) * 2`:

```mermaid
graph TD
    M["* (Multiply)"] --> A["+ (Add)"]
    M --> N2["2 (Number)"]
    A --> X["x (Variable)"]
    A --> Y["y (Variable)"]
```

## Evaluation Flow

```mermaid
sequenceDiagram
    participant Client
    participant Multiply
    participant Add
    participant VarX
    participant VarY
    participant Num2
    participant Context

    Client->>Multiply: interpret(context)
    Multiply->>Add: interpret(context)
    Add->>VarX: interpret(context)
    VarX->>Context: get("x")
    Context-->>VarX: 10
    Add->>VarY: interpret(context)
    VarY->>Context: get("y")
    Context-->>VarY: 5
    Add-->>Multiply: 15
    Multiply->>Num2: interpret(context)
    Num2-->>Multiply: 2
    Multiply-->>Client: 30
```

## Key Concepts

| Term | Description | Example |
|------|-------------|---------|
| **Terminal** | Leaf nodes, don't contain other expressions | `NumberExpression`, `VariableExpression` |
| **Non-terminal** | Composite nodes with child expressions | `AddExpression`, `MultiplyExpression` |
| **Context** | Shared state for interpretation | Variables map |

## Building Expressions

```java
// (x + y) * 2
Expression expr = new MultiplyExpression(
    new AddExpression(
        new VariableExpression("x"),
        new VariableExpression("y")),
    new NumberExpression(2));

double result = expr.interpret(Map.of("x", 10.0, "y", 5.0));
// Result: 30
```

## Real-World Uses

- SQL query parsers
- Regular expression engines
- Mathematical expression evaluators
- Configuration file parsers
- Domain-specific languages (DSLs)

## When to Use

- When you have a simple grammar to interpret
- When efficiency is not critical (complex grammars are better with parser generators)
- When you want to represent statements as abstract syntax trees

## Trade-offs

✅ **Pros**: Easy to extend grammar, each rule is a class  
❌ **Cons**: Complex grammars create many classes, not efficient for large expressions

## Run

```bash
mvn -q compile exec:java -Dexec.mainClass="com.mattee37.patterns.behavioral.interpreter.InterpreterDemo"
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
