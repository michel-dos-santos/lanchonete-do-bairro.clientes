package br.com.lanchonete.postgres.repository;

import br.com.lanchonete.model.Address;
import br.com.lanchonete.port.repository.AddressRepository;
import br.com.lanchonete.postgres.entity.AddressEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PostgresDBAddressRepository implements AddressRepository {

    private final SpringDataPostgresAddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public PostgresDBAddressRepository(SpringDataPostgresAddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public Address save(Address address) {
        AddressEntity addressEntity = modelMapper.map(address, AddressEntity.class);
        addressRepository.save(addressEntity);
        return modelMapper.map(addressEntity, Address.class);
    }

}
