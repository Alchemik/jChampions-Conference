# Solutions

### Challenge 1: 
> Answer:

### Challenge 2:
> Answer:

### Challenge 3: JDK 17 - sealed classes
> Answer: 

### Challenge 4: JDK 21 - instance of Pattern Matching
```java
sealed interface Payment permits CreditCard, Cash {}
final class CreditCard implements Payment {}            // 1. Subclasses must either be final, sealed or non-sealed
non-sealed class Cash implements Payment {}             // 2. The Cash class is declared as non-sealed, allowing it to have subclasses (DigitalWallet)

class DigitalWallet extends Cash {} // Line #A          // 3. DigitalWallet can extend Cash, because Cash class is non-sealed

public class SealedChallenge {
    public static void main(String[] args) {
        Payment payment = new DigitalWallet();
        if (payment instanceof CreditCard) {
            System.out.println("Payment through CreditCard");
        } else if (payment instanceof Cash) {           // 4. Since DigitalWallet is a subclass of Cash, the program prints Payment through Cash
            System.out.println("Payment through Cash");
        } else {
            System.out.println("Unknown payment method");
        }
    }
}

```
> Answer: "Payment through Cash"

