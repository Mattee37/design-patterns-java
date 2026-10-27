# Feature: design-patterns-java

## Objective
Port the 23 GoF design patterns from the sibling TypeScript repo (`../patterns`) to Java 25 + Maven, same structure: implementation classes, runnable demo per pattern, JUnit 5 test per pattern, README per pattern, root README mirroring the TS one.

## Why
User wants the same collection in Java (the natural OOP language for GoF). New folder + new repo: `D:\Taller\Programacion\JAM STACK\design-patterns-java`.

## Scope
- 23 patterns: 5 creational, 7 structural, 11 behavioral
- Maven build (Java 25 LTS, JUnit 5, exec plugin for demos)
- Package root: `com.mattee37.patterns.<category>.<pattern>`
- Faithful ports of the TS examples (same domain examples, e.g. Pizza Builder)

## Out of scope
- Push / GitHub repo creation (user decision)
- Gradle, Spring, or any framework dependency

## Constraints
- Java 25, Maven 3.9.16 (installed), no deps besides JUnit 5
- Delivery: >400 lines forecast → work-unit commits per category on `main` (brand-new repo, no remote yet); user decides push/PR later

## Checklist
- [x] T1 Scaffold: git init, pom.xml, .gitignore, root README, odd tracking doc
- [x] T2 Creational patterns (factory, abstract-factory, builder, prototype, singleton) — writer A
- [x] T3 Structural patterns (adapter, bridge, composite, decorator, facade, flyweight, proxy) — writer B
- [x] T4 Behavioral part 1 (chain-of-responsibility, command, interpreter, iterator, mediator, memento) — writer C
- [x] T5 Behavioral part 2 (observer, state, strategy, template-method, visitor) — writer D
- [x] T6 Verify: `mvn test` green, spot-check demos, commit

## Acceptance criteria
- `mvn test` passes with 23 test classes (one per pattern) ✅ 59 tests green
- Every pattern has a `main` demo runnable via exec plugin ✅ spot-checked BuilderDemo
- Every pattern has a README.md ✅
- Root README lists all 23 with run commands ✅

## Progress
- 2026-10-27: T1 done. Writers A–D launched in parallel.
- 2026-10-27: All writers returned. Fixed 1 compile error (Folder.name() missing override).
- 2026-10-27: `mvn test` → BUILD SUCCESS, Tests run: 59, Failures: 0, Errors: 0.
- 2026-10-27: Initial commit c5bd79a on main (162 files, 5420 insertions).
- Next: user decides push/GitHub repo creation (remote operation, needs explicit authorization).

## TDD / checks
- TDD: off (ordinary functional checks)
- Checks: `mvn -q test`, `mvn -q compile exec:java -Dexec.mainClass=<demo>` spot checks
