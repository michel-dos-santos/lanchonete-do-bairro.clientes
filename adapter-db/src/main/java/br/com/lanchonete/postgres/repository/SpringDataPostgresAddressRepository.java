package br.com.lanchonete.postgres.repository;

import br.com.lanchonete.postgres.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataPostgresAddressRepository extends JpaRepository<AddressEntity, UUID> {

}
