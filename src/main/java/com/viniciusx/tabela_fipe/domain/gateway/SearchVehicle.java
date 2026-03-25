package com.viniciusx.tabela_fipe.domain.gateway;

import com.viniciusx.tabela_fipe.domain.model.*;

public interface SearchVehicle {
    String searchBrands(VehicleType vehicleType);
    String searchModels(VehicleType vehicleType, String codeBrand);
    String searchYears(VehicleType vehicleType, String codeBrand, String codeModel);
    String searchVehicle(VehicleType vehicleType, String codeBrand, String codeModel, String codeYear);
}
