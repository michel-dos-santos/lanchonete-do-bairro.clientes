package br.com.lanchonete.rest.mappers.inputs.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestDeleteClientInputDTO {

    @NotBlank(message = "Nome não pode ser vazio ou nulo")
    @Size(min = 3, max = 50, message = "Nome do cliente deve ter no mínimo {min} e no máximo {max} caracteres")
    private String name;

    @NotBlank(message = "Telefone não pode ser vazio ou nulo")
    private String phone;

    @NotNull(message = "Endereço não pode ser vazio ou nulo")
    private @Valid AddressInputDTO address;

}
