package com.viniciusx.tabela_fipe.main;

import com.viniciusx.tabela_fipe.domain.model.VehicleType;
import com.viniciusx.tabela_fipe.service.SearchVehicleService;

import java.util.Scanner;

public class Run {
    static SearchVehicleService searchVehicleService = new SearchVehicleService();
    public static void search() {
        System.out.println("Pesquisar por: ");
        System.out.println("[1] Carro");
        System.out.println("[2] Moto");
        System.out.println("[3] Caminhão");
        System.out.print("Digite o código da opção desejada: ");

        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite o tipo de veículo a ser consultado: ");
            VehicleType vehicleType = VehicleType.fromPath(sc.nextLine().trim());

        }

    }
}