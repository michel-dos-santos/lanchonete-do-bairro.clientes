package br.com.lanchonete.rest.mappers.outputs;

import br.com.lanchonete.model.Address;
import br.com.lanchonete.rest.mappers.outputs.dtos.AddressOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressOutputMapper {

    @Autowired
    private ModelMapper modelMapper;

    public AddressOutputDTO mapAddressFromAddressOutputDTO(Address address) {
        return modelMapper.map(address, AddressOutputDTO.class);
    }

}
