package br.com.lanchonete.rest.mappers.outputs.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class AddressOutputDTO {

    private UUID id;
    private String address;
    private String number;
    private String complement;
    private String zipcode;

}
