package com.viniciusx.tabela_fipe.main;

import com.viniciusx.tabela_fipe.domain.model.Brand;
import com.viniciusx.tabela_fipe.domain.model.Model;
import com.viniciusx.tabela_fipe.domain.model.VehicleType;
import com.viniciusx.tabela_fipe.domain.model.Year;
import com.viniciusx.tabela_fipe.service.SearchVehicleService;

import java.util.List;
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
            List<Brand> brands = searchVehicleService.listBrands(vehicleType);
            List<Model> models = searchVehicleService.listModels(vehicleType, "56");
            List<Year> years = searchVehicleService.listYears(vehicleType, "56", "8942");
            years.forEach(System.out::println);
            System.out.println(searchVehicleService.getVehicle(vehicleType, "56", "8942", "2022-5"));


//            System.out.print("Digite o código da marca desejada: ");
//            String codeBrand = sc.nextLine();
//            searchVehicleService.listModels(vehicleType, codeBrand);
//            System.out.print("Digite o código do modelo desejado: ");
//            String codeModel = sc.nextLine();
//            searchVehicleService.listYears(vehicleType, codeBrand, codeModel);
//            System.out.print("Digite o código do ano desejado: ");
//            String codeYear = sc.nextLine();
//            searchVehicleService.listVehicle(vehicleType, codeBrand, codeModel, codeYear);
        }

    }
}
