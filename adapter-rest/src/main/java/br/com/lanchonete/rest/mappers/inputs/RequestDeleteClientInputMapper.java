package br.com.lanchonete.rest.mappers.inputs;

import br.com.lanchonete.model.RequestDeleteClient;
import br.com.lanchonete.rest.mappers.inputs.dtos.RequestDeleteClientInputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestDeleteClientInputMapper {

    @Autowired
    private ModelMapper modelMapper;

    public RequestDeleteClient mapRequestDeleteClientFromRequestDeleteClientInputDTO(RequestDeleteClientInputDTO requestDeleteClientInputDTO) {
        return modelMapper.map(requestDeleteClientInputDTO, RequestDeleteClient.class);
    }

}
