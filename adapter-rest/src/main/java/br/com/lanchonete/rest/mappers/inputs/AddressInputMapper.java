package br.com.lanchonete.rest.mappers.inputs;

import br.com.lanchonete.model.Address;
import br.com.lanchonete.rest.mappers.inputs.dtos.AddressInputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressInputMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Address mapAddressFromAddressInputDTO(AddressInputDTO addressInputDTO) {
        return modelMapper.map(addressInputDTO, Address.class);
    }

}
