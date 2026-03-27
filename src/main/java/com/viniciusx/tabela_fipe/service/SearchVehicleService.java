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

    public List<Model> listModels(VehicleType vehicleType, String codeBrand) {
        return getList(fipeVehicleClient.searchModels(vehicleType, codeBrand), Model.class);
    }

    public List<Year> listYears(VehicleType vehicleType, String codeBrand, String codeYear) {
        return getList(fipeVehicleClient.searchYears(vehicleType, codeBrand, codeYear), Year.class);
    }

    public <T extends Identifiable> List<T> filterSearch(List<T> list, String filter) {
        return list.stream()
                .filter(t -> t.name().toLowerCase().contains(filter.toLowerCase()))
                .toList();
    }
}