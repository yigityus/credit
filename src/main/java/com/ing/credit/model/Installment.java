package com.ing.credit.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum Installment {
    SIX(6),
    NINE(9),
    TWELVE(12),
    TWENTY_FOUR(24);
    private int value;

    Installment(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Installment nameByValue(final int value) {
        for (final Installment installment : Installment.values()) {
            if (installment.value == value) {
                return installment;
            }
        }
        return null;
    }


    public static boolean isValid(int numberOfInstallments) {
        return Arrays.stream(values())
                     .anyMatch(installment -> installment.value == numberOfInstallments);
    }
}
