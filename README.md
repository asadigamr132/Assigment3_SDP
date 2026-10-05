# Assignment 3 - Bridge Pattern

## Student

Name: Abdraissov Altair

Group: SE-2528

Topic: A - Drawing


Base commit:
c26226d


## Pattern

This project demonstrates the Bridge design pattern.

The abstraction hierarchy is:

Shape
- Circle
- Square

The implementor hierarchy is:

Renderer
- VectorRenderer
- RasterRenderer
- AsciiRenderer


## Role Map

| Role | Class | Source |
|---|---|---|
| Abstraction | Shape | src/Shape.java |
| Refined Abstraction | Circle | src/Circle.java |
| Refined Abstraction | Square | src/Square.java |
| Implementor | Renderer | src/Renderer.java |
| Concrete Implementor | VectorRenderer | src/VectorRenderer.java |
| Concrete Implementor | RasterRenderer | src/RasterRenderer.java |
| Concrete Implementor | AsciiRenderer | src/AsciiRenderer.java |
| Client | Main | src/Main.java |


## Bridge Location

The bridge is the Renderer reference stored in Shape:

Renderer renderer;

It is supplied through the Shape constructor.

The implementation can be replaced using:

setImplementation(Renderer renderer)

The execute() method is implemented by Circle and Square.


## T5 Runtime Switching

T5 creates one Circle object with VectorRenderer.

The implementation is then changed to RasterRenderer using setImplementation().

The same object is verified using ==.

The ID and radius remain unchanged while the rendering result changes.


## Build

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"