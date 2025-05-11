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
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Entity
@Table(name = "dashboard_user", schema = "my_marketing")
@AttributeOverrides({
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "created_by", length = 50)),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "updated_by", length = 50))
})
public class DashboardUser extends Base {
    @Size(max = 100)
    @NotNull(message = "Login id is required")
    @Column(name = "login_id", nullable = false, length = 100, unique = true)
    private String loginId;

    @Size(max = 100)
    @NotNull(message = "Password is required")
    @Column(name = "password", nullable = false, length = 100)
    private String password;
}