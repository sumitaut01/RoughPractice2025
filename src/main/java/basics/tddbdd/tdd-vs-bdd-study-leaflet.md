# TDD vs BDD — Study Leaflet

## 1. Core Definitions

**TDD (Test-Driven Development)**
A developer practice where you write a failing unit test *before* writing the code that makes it pass. Cycle: **Red → Green → Refactor**. Focus is on code correctness at the unit/class level.

**BDD (Behavior-Driven Development)**
An extension of TDD that shifts focus from "how the code works" to "how the system behaves" from a user/business perspective. Tests are written as human-readable specifications, often collaboratively with QA, devs, and business stakeholders (the "three amigos").

---

## 2. Side-by-Side Comparison

| Aspect | TDD | BDD |
|---|---|---|
| **Primary audience** | Developers | Developers + QA + Business/Product |
| **Language** | Code (assertions, method calls) | Natural language (Given/When/Then) |
| **Granularity** | Unit-level (single class/method) | Feature/scenario-level (end-to-end behavior) |
| **Goal** | "Is the code correct?" | "Does the system do what the user needs?" |
| **Tools (Java)** | JUnit, TestNG | Cucumber-JVM, JBehave, Serenity BDD |
| **Format** | `@Test` methods with assertions | `.feature` files with Gherkin syntax |
| **When written** | Before implementation, by the developer | Before implementation, often collaboratively |
| **Output artifact** | Passing/failing unit tests | Living documentation (readable spec + test) |

---

## 3. The Cycle

**TDD Cycle**
```
1. Write a failing test (Red)
2. Write minimal code to pass it (Green)
3. Refactor code, keep tests green
4. Repeat
```

**BDD Cycle**
```
1. Discovery: discuss the feature (three amigos)
2. Write scenarios in Gherkin (Given/When/Then)
3. Automate step definitions (glue code)
4. Implement feature until scenarios pass
5. Scenarios become regression + living documentation
```

---

## 4. Code Snapshot

**TDD — TestNG example**
```java
@Test
public void shouldApplyDiscountForBulkOrder() {
    Order order = new Order(150, unitPrice);
    double total = pricingEngine.calculateTotal(order);
    assertEquals(total, expectedDiscountedTotal);
}
```

**BDD — Gherkin + Cucumber-JVM example**
```gherkin
Feature: Bulk order discount

  Scenario: Customer orders more than 100 units
    Given a customer has 150 units in their cart
    When the pricing engine calculates the total
    Then a bulk discount should be applied
    And the final total should reflect the discount
```
```java
@When("the pricing engine calculates the total")
public void calculateTotal() {
    total = pricingEngine.calculateTotal(order);
}
```

---

## 5. Key Differences to Remember

- **TDD is a design technique** for developers writing code; **BDD is a collaboration/communication technique** that happens to also produce automated tests.
- BDD is built **on top of** TDD principles — it doesn't replace unit testing, it adds a behavior layer above it.
- TDD tests are usually **invisible to non-technical stakeholders**; BDD scenarios are **readable by anyone**.
- In practice, teams often do **both**: TDD for unit-level logic (e.g., pricing rule calculations), BDD for feature-level acceptance criteria (e.g., end-to-end pricing engine behavior via Selenium + Cucumber).

---

## 6. Quick Self-Check Questions

1. What problem does the "three amigos" meeting solve that pure TDD doesn't?
2. Why is Gherkin considered "living documentation"?
3. Can BDD scenarios exist without any TDD unit tests underneath them? What's the risk?
4. In a hybrid framework (Selenium + TestNG + RestAssured), where would you draw the line between what's tested via TDD vs BDD?

---

## 7. One-Line Summary
> **TDD asks "does my code work?" BDD asks "does my system behave the way the business expects?"**
