package com.viniciusx.tabela_fipe.domain.model;

public enum VehicleType {
    CAR("cars"),
    MOTORCYCLE("motorcycles"),
    TRUCK("trucks");

    private final String path;

    VehicleType(final String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public static VehicleType fromPath(final String path) {
        return switch (path) {
            case "1" -> CAR;
            case "2" -> MOTORCYCLE;
            case "3" -> TRUCK;
            default -> throw new IllegalArgumentException("Opção inválida!");
        };
    }


}
