package com.beeorg.mymarketing.entity;

import com.beeorg.mymarketing.entity.lib.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "dashboard_user", schema = "my_marketing")
@AttributeOverrides({@AttributeOverride(name = "createdBy", column = @Column(name = "created_by", nullable = false, length = 50)), @AttributeOverride(name = "updatedBy", column = @Column(name = "updated_by", nullable = false, length = 50))})
public class DashboardUser extends Base {
    @Size(max = 100)
    @NotNull
    @Column(name = "login_id", nullable = false, length = 100, unique = true)
    private String loginId;

    @Size(max = 100)
    @NotNull
    @Column(name = "password", nullable = false, length = 100)
    private String password;
}