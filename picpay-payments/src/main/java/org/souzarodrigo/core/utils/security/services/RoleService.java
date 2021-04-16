package org.souzarodrigo.core.utils.security.services;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.souzarodrigo.core.utils.security.constants.Roles;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RoleService {

    public Roles getRoles(JsonWebToken jwt) {
        String jwtRole = jwt.getGroups().stream().findFirst().isPresent() ? jwt.getGroups().stream().findFirst().get() : "";

        return Roles.fromString(jwtRole);
    }
}
