package com.viniciusx.tabela_fipe.domain.model;

import org.jspecify.annotations.NonNull;

public record Vehicle(
        String vehicleType,
        String price,
        String brand,
        String model,
        String modelYear,
        String fuel,
        String codeFipe,
        String referenceMonth,
        String fuelAcronym
) {
    @Override
    public @NonNull String toString() {
        return "[%s] %s, %s [%s] | %s [%s]".formatted(brand, model, modelYear, fuel, price, referenceMonth);
    }
}
