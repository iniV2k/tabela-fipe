package com.viniciusx.tabela_fipe.domain.model;

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
}
