package br.com.lanchonete.rest.mappers.inputs.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressInputDTO {

    @NotBlank(message = "Logradouro não pode ser vazio ou nulo")
    private String address;

    @NotBlank(message = "Número não pode ser vazio ou nulo")
    private String number;

    private String complement;

    @NotBlank(message = "CEP não pode ser vazio ou nulo")
    private String zipcode;

}
