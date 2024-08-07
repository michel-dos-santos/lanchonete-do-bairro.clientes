package br.com.lanchonete.postgres.repository;

import br.com.lanchonete.postgres.entity.RequestDeleteClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataPostgresRequestDeleteClientRepository extends JpaRepository<RequestDeleteClientEntity, UUID> {

}
