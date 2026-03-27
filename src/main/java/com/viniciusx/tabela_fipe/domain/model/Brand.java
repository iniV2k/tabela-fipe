package com.viniciusx.tabela_fipe.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.viniciusx.tabela_fipe.domain.gateway.Identifiable;
import org.jspecify.annotations.NonNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Brand(String code, String name) implements Identifiable {
    @Override
    public @NonNull String toString() {
        return "%s | ID [%s]".formatted(name, code);
    }
}
