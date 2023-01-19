package com.moura.rent.config.validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartridgeValidationException {
    private ErrorResponse error;
    private List<CartridgeFieldsErrors> fields;
}

@Data
@AllArgsConstructor
class CartridgeFieldsErrors{
    private String field, error;
}
