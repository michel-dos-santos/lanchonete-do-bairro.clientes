package br.com.lanchonete.postgres.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_address")
@EntityListeners(AuditingEntityListener.class)
public class AddressEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    @Column(length = 50, nullable = false)
    private String address;
    @Column(length = 10, nullable = false)
    private String number;
    @Column(length = 50)
    private String complement;
    @Column(length = 8, nullable = false)
    private String zipcode;

}
