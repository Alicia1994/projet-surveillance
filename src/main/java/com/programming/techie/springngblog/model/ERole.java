package com.programming.techie.springngblog.model;

import java.util.HashSet;
import java.util.Set;

public enum ERole {
    ADMIN,
    USER;

    public static Set<ERole> ConvertFromString(Set<String> role) {
        Set<ERole> roles = new HashSet<>();
        role.forEach(str -> roles.add(ERole.valueOf(str)));
        return roles;
    }
}
