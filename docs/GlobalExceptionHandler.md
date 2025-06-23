# Global Exception Handler

To return a specific `ResponseEntity` with a status code after catching an exception, you need to follow these steps:

1. **Create a base Exception class** (for example, `ApiException`) which extends `RuntimeException`.  
   This exception should have a variable to hold the `HttpStatus`.

2. **Create child exceptions** that extend the base `ApiException`.

3. **Create a global exception handler class** that returns the `ResponseEntity` with the proper status code.  
   To do this, annotate the class with `@RestControllerAdvice` and create methods to handle specific exceptions annotated with `@ExceptionHandler`.

---

## Example

```java
public class ApiException extends RuntimeException {
    private final HttpStatus status;

    public ApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}

public class UsernameAlreadyExistsException extends ApiException {
    public UsernameAlreadyExistsException() {
        super("Username already exists", HttpStatus.BAD_REQUEST);
    }
}

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(Map.of(
                    "error", ex.getMessage(),
                    "status", ex.getStatus().value()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOtherExceptions(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Unexpected error occurred"));
    }
}
```
