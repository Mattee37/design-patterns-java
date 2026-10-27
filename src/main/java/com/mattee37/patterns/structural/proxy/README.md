# Proxy Pattern

## Intent

Provide a surrogate or placeholder for another object to control access to it.

## Problem

You need to control access to an object—for lazy loading, access control, logging, caching, etc.

## Solution

Create a proxy class with the same interface as the original object that controls access to it.

## Diagram

```mermaid
classDiagram
    class Image {
        <<interface>>
        +display(): void
    }

    class RealImage {
        -filename: string
        -loadFromDisk(): void
        +display(): void
    }

    class ImageProxy {
        -filename: string
        -realImage: RealImage
        +display(): void
    }

    Image <|.. RealImage
    Image <|.. ImageProxy
    ImageProxy o-- RealImage : lazy loads
```

## Our Example

We implement a virtual proxy for lazy-loading images:

- **`Image.java`**: Defines the `Image` interface, with package-private `RealImage` (expensive to create)
- **`ImageProxy.java`**: Delays loading
- **`ProxyDemo.java`**: Shows lazy loading behavior

## Lazy Loading Flow

```mermaid
sequenceDiagram
    participant Client
    participant Proxy
    participant RealImage

    Client->>Proxy: new ImageProxy("photo.jpg")
    Note right of Proxy: Image NOT loaded yet

    Client->>Proxy: display()
    Proxy->>RealImage: new RealImage("photo.jpg")
    Note right of RealImage: Loading from disk...
    RealImage-->>Proxy: created
    Proxy->>RealImage: display()

    Client->>Proxy: display()
    Note right of Proxy: Already loaded!
    Proxy->>RealImage: display()
```

## Types of Proxies

| Type | Purpose |
|------|---------|
| **Virtual** | Lazy loading (our example) |
| **Protection** | Access control |
| **Remote** | Local representation of remote object |
| **Logging** | Keep history of requests |
| **Caching** | Cache results |

## When to Use

- **Lazy initialization**: When you have a heavyweight object that you don't always need
- **Access control**: When you want to control access to an object
- **Logging/Caching**: When you want to add behavior without changing the original
- **Remote objects**: When the real object is in a different address space

## Run

```bash
mvn -q compile exec:java -Dexec.mainClass=com.mattee37.patterns.structural.proxy.ProxyDemo
```
