package com.viniciusx.tabela_fipe.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.viniciusx.tabela_fipe.domain.gateway.Identifiable;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Model(String name,String code) implements Identifiable {
}
