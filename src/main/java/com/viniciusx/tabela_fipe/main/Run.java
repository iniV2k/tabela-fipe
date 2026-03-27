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
        System.out.print("Digite o ID da opção desejada: ");

        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite o tipo de veículo a ser consultado: ");
            VehicleType vehicleType = VehicleType.fromPath(sc.nextLine().trim());

            List<Brand> listBrands = searchVehicleService.listBrands(vehicleType);
            listBrands.forEach(System.out::println);

            System.out.print("Filtre a busca: ");
            searchVehicleService.filterSearch(listBrands, sc.nextLine().trim()).forEach(System.out::println);

            System.out.print("Digite o ID da marca a ser consultada: ");
            String codeBrand =  sc.nextLine().trim();

            List<Model> listModels = searchVehicleService.listModels(vehicleType,  codeBrand);
            listModels.forEach(System.out::println);

            System.out.print("Filtre a busca: ");
            searchVehicleService.filterSearch(listModels, sc.nextLine().trim()).forEach(System.out::println);

            System.out.print("Digite o ID do modelo a ser consultado: ");
            String codeModel = sc.nextLine().trim();

            List<Year> years = searchVehicleService.listYears(vehicleType, codeBrand, codeModel);
            years.forEach(System.out::println);

            System.out.print("Digite o ID do ano referência: ");
            String codeYear = sc.nextLine().trim();

            System.out.println(searchVehicleService.getVehicle(vehicleType, codeBrand, codeModel, codeYear));
        }

    }
}