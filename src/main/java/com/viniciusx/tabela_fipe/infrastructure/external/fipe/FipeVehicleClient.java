package com.viniciusx.tabela_fipe.infrastructure.external.fipe;

import com.viniciusx.tabela_fipe.domain.gateway.SearchVehicle;
import com.viniciusx.tabela_fipe.domain.model.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class FipeVehicleClient implements SearchVehicle {
    private final String baseUrl = "https://fipe.parallelum.com.br/api/v2";

    private String getResponse(String url) {
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder()
                .url(url)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .build();

        try(Response response = client.newCall(req).execute()) {
            if (response.body() != null) {
                return response.body().string();
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return "";
    }

    @Override
    public String searchBrands(VehicleType vehicleType) {
        return getResponse
                (baseUrl + "/%s/brands"
                        .formatted(vehicleType.getPath()));
    }

    @Override
    public String searchModels(VehicleType vehicleType, String codeBrand) {
        return getResponse
                (baseUrl + "/%s/brands/%s/models"
                        .formatted(vehicleType.getPath(), codeBrand));
    }

    @Override
    public String searchYears(VehicleType vehicleType, String codeBrand, String codeModel) {
        return getResponse
                (baseUrl + "/%s/brands/%s/models/%s/years"
                        .formatted(vehicleType.getPath(), codeBrand, codeModel));
    }

    @Override
    public String searchVehicle(VehicleType vehicleType, String codeBrand, String codeModel, String codeYear) {
        return getResponse
                (baseUrl + "/%s/brands/%s/models/%s/years/%s"
                        .formatted(vehicleType.getPath(), codeBrand, codeModel, codeYear));
    }
}
