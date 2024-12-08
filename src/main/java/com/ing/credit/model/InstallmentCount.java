package com.ing.credit.model;

import java.util.Arrays;

public enum InstallmentCount {
    SIX(6),
    NINE(9),
    TWELVE(12),
    TWENTY_FOUR(24);
    private int value;

    InstallmentCount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static InstallmentCount nameByValue(final int value) {
        for (final InstallmentCount installment : InstallmentCount.values()) {
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
