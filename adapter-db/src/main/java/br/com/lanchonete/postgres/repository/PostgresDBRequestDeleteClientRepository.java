package br.com.lanchonete.postgres.repository;

import br.com.lanchonete.model.RequestDeleteClient;
import br.com.lanchonete.port.repository.RequestDeleteClientRepository;
import br.com.lanchonete.postgres.entity.RequestDeleteClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PostgresDBRequestDeleteClientRepository implements RequestDeleteClientRepository {

    private final SpringDataPostgresRequestDeleteClientRepository requestDeleteClientRepository;
    private final ModelMapper modelMapper;

    public PostgresDBRequestDeleteClientRepository(SpringDataPostgresRequestDeleteClientRepository requestDeleteClientRepository, ModelMapper modelMapper) {
        this.requestDeleteClientRepository = requestDeleteClientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public RequestDeleteClient save(RequestDeleteClient requestDeleteClient) {
        RequestDeleteClientEntity requestDeleteClientEntity = modelMapper.map(requestDeleteClient, RequestDeleteClientEntity.class);

        requestDeleteClientRepository.save(requestDeleteClientEntity);
        return modelMapper.map(requestDeleteClientEntity, RequestDeleteClient.class);
    }

}
