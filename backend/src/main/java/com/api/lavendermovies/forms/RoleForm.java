package com.api.lavendermovies.forms;

import com.api.lavendermovies.enums.RoleName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class RoleForm {
    @Enumerated(EnumType.STRING)
    private RoleName roleName;
}
