package com.beeorg.mymarketing.entity.database;

import com.beeorg.mymarketing.entity.lib.PrimaryKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "credential", schema = "my_marketing", indexes = {@Index(name = "credential_phone_number_unique", columnList = "phone_number", unique = true)})
public class Credential extends PrimaryKey {
    @Size(max = 100)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 100)
    private String phoneNumber;

    @Size(max = 100)
    @NotNull
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Size(max = 100)
    @NotNull
    @Column(name = "nrc_no", nullable = false, length = 100)
    private String nrcNo;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "consumer_id", nullable = false)
    private Consumer consumer;

}