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
            String vehicleTypeStr = sc.nextLine();
            VehicleType vehicleType = VehicleType.fromPath(vehicleTypeStr);
            searchVehicleService.listBrands(vehicleType);
            System.out.print("Digite o código da marca desejada: ");
            String codeBrand = sc.nextLine();
            searchVehicleService.listModels(vehicleType, codeBrand);
            System.out.print("Digite o código do modelo desejado: ");
            String codeModel = sc.nextLine();
            searchVehicleService.listYears(vehicleType, codeBrand, codeModel);
            System.out.print("Digite o código do ano desejado: ");
            String codeYear = sc.nextLine();
            searchVehicleService.listVehicle(vehicleType, codeBrand, codeModel, codeYear);
        }

    }
}
