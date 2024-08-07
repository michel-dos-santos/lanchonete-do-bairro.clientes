package br.com.lanchonete.rest.mappers.outputs.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RequestDeleteClientOutputDTO {

    private UUID id;
    private String name;
    private String phone;
    private AddressOutputDTO address;

}
