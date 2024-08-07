package br.com.lanchonete.rest.mappers.outputs;

import br.com.lanchonete.model.RequestDeleteClient;
import br.com.lanchonete.rest.mappers.outputs.dtos.RequestDeleteClientOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestDeleteClientOutputMapper {

    @Autowired
    private ModelMapper modelMapper;

    public RequestDeleteClientOutputDTO mapRequestDeleteClientFromRequestDeleteClientOutputDTO(RequestDeleteClient requestDeleteClient) {
        return modelMapper.map(requestDeleteClient, RequestDeleteClientOutputDTO.class);
    }

}
