# Feature: uml-diagrams (design-patterns-java)

## Objective
Add 4 PlantUML diagrams (class, state, sequence, use case) per pattern — 92 diagrams total — rendered to PNG and embedded in each pattern's README.

## Why
User request: "diagramas de clase, estado, secuencia, de uso... algo estándar para Java, UML". PlantUML is the Java-standard text UML tool.

## Scope
- `src/main/java/com/mattee37/patterns/<cat>/<pat>/diagrams/{class,state,sequence,usecase}.puml` × 23 patterns
- Render to PNG alongside via PlantUML (`net.sourceforge.plantuml:plantuml:1.2025.4`, main class `net.sourceforge.plantuml.Run`)
- Each pattern README gets a `## Diagrams` section embedding the 4 PNGs
- Root README: note about diagrams + how to re-render
- pom: plantuml dep (provided scope) + render invocation

## Constraints
- Diagrams must reflect the ACTUAL Java classes in this repo (read the sources)
- PNG (GitHub-safe embeds)
- Java 25 / Maven only; no new tools to install

## Delivery
- >400 authored lines forecast → but delivery = direct push to main on the existing GitHub repo (established repo policy, no PR flow). Work-unit commit(s) per category, push on user confirmation.

## Checklist
- [x] D1 Feature doc created
- [x] D2 Writer A: 5 creational patterns → 20 .puml + README sections
- [x] D3 Writer B: 7 structural patterns → 28 .puml + README sections
- [x] D4 Writer C: 6 behavioral (chain, command, interpreter, iterator, mediator, memento) → 24 .puml + README sections
- [x] D5 Writer D: 5 behavioral (observer, state, strategy, templatemethod, visitor) → 20 .puml + README sections
- [x] D6 Render: pom config + PlantUML run, 1 syntax error fixed (interpreter/state.puml `note top` → `note top of X`), 92 PNGs, -checkonly exit 0
- [x] D7 Verify: 92 PNGs, READMEs embed, root README updated, mvn test green

## Acceptance criteria
- 92 .puml files, 92 PNGs rendered (plantuml exit 0, no syntax errors)
- Each pattern README embeds its 4 diagrams
- `mvn test` still green (nothing source-breaking)

## Progress
- 2026-10-27: D1 done, writers A–D launched in parallel.
- Engram mirror: PENDING (engram unavailable in this runtime).

## Checks
- `mvn test` (regression)
- `mvn -q exec:java -Dexec.mainClass=net.sourceforge.plantuml.Run ...` render exit 0 + PNG count = 92
