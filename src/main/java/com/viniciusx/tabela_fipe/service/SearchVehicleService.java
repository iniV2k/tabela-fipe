package com.viniciusx.tabela_fipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.viniciusx.tabela_fipe.domain.gateway.Identifiable;
import com.viniciusx.tabela_fipe.domain.model.*;
import com.viniciusx.tabela_fipe.infrastructure.external.fipe.FipeVehicleClient;

import java.util.List;

public class SearchVehicleService {
    private final FipeVehicleClient fipeVehicleClient = new FipeVehicleClient();
    private final ObjectMapper mapper = new ObjectMapper();

    private <T extends Identifiable> List<T> getList(String json, Class<T> clazz) {
        CollectionType collectionType = mapper.getTypeFactory()
                .constructCollectionType(List.class, clazz);
        try {
            return mapper.readValue(json, collectionType);
        } catch (JsonProcessingException e) {
            System.out.println("Erro ao processar JSON: " + e.getMessage());
        }
        return List.of();
    }

    public Vehicle getVehicle(VehicleType vehicleType, String codeBrand, String codeModel, String codeYear) {
        try {
            return mapper
                    .readValue(fipeVehicleClient
                            .searchVehicle(vehicleType, codeBrand, codeModel, codeYear), Vehicle.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Brand> listBrands(VehicleType vehicleType) {
        return getList(fipeVehicleClient.searchBrands(vehicleType), Brand.class);
    }

//    public void listBrands(VehicleType vehicleType) {
//        String json = fipeVehicleClient.searchBrands(vehicleType);
//        getList(json, Brand.class);
//    }

//    public void listModels(VehicleType vehicleType, String codeBrand) {
//        String json = fipeVehicleClient.searchModels(vehicleType, codeBrand);
//        getList(json, Model.class);
//    }

    public List<Model> listModels(VehicleType vehicleType, String codeBrand) {
        return getList(fipeVehicleClient.searchModels(vehicleType, codeBrand), Model.class);
    }

//    public void listYears(VehicleType vehicleType, String codeBrand, String codeYear) {
//        String json = fipeVehicleClient.searchYears(vehicleType, codeBrand, codeYear);
//        getList(json, Year.class);
//    }

    public List<Year> listYears(VehicleType vehicleType, String codeBrand, String codeYear) {
        return getList(fipeVehicleClient.searchYears(vehicleType, codeBrand, codeYear), Year.class);
    }

//    public void listVehicle(VehicleType vehicleType, String codeBrand, String codeModel, String codeYear) {
//        String json = fipeVehicleClient.searchVehicle(vehicleType, codeBrand, codeModel, codeYear);
//        getVehicle(json);
//    }

//    public List<Vehicle> listVehicle(VehicleType vehicleType, String codeBrand, String codeModel, String codeYear) {
//        return fipeVehicleClient.searchVehicle();
//    }
}