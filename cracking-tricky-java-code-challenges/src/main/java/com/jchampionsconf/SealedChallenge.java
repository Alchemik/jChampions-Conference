package com.jchampionsconf;

sealed interface Payment permits CreditCard, Cash {}
final class CreditCard implements Payment {}
non-sealed class Cash implements Payment {}

class DigitalWallet extends Cash {} // Line #A

public class SealedChallenge {
    public static void main(String[] args) {
        Payment payment = new DigitalWallet();
        if (payment instanceof CreditCard) {
            System.out.println("Payment through CreditCard");
        } else if (payment instanceof Cash) {
            System.out.println("Payment through Cash");
        } else {
            System.out.println("Unknown payment method");
        }
    }
}
