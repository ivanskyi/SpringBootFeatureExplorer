# Aspect-Oriented Programming (AOP)

## Pointcut

A **Pointcut** is a rule that defines which methods an aspect applies to in AOP. It selects specific execution points in the code where additional logic (Advice) will be executed.

```java
@Pointcut("execution(public * com.ivanskyi.sbfe..*(..))")
public void allServiceMethods() { }
```

* `execution(...)` — intercepts method execution
* `public` — public methods
* `*` — any return type
* `com.ivanskyi.sbfe..*` — all classes in the package `com.ivanskyi.sbfe` and its subpackages
* `*(..)` — any method name with any arguments

-----

## Advice

**Advice** is the code executed at the moment defined by a Pointcut, for example, before or after a method call. It is the behavior added by the aspect to the target code.

Common types of Advice in AOP:

* `@Before` — executes before the method call
* `@After` — executes after the method call (regardless of outcome)
* `@AfterReturning` — executes after successful method completion
* `@AfterThrowing` — executes if the method throws an exception
* `@Around` — wraps the method call, allows full control (execute code before and after, modify arguments, result, or skip the method call)

-----

## Join Point

A **Join Point** is a specific point in the program where additional code can be executed (e.g., a method call).

A **Pointcut** is a rule or expression that describes a set of such join points, selecting exactly where the aspect should be applied.
