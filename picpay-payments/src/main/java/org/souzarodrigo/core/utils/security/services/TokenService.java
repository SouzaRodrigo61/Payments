package org.souzarodrigo.core.utils.security.services;

import org.eclipse.microprofile.jwt.Claims;
import org.jose4j.jwt.JwtClaims;
import org.souzarodrigo.core.utils.security.constants.Roles;
import org.souzarodrigo.core.utils.security.util.TokenUtils;

import javax.enterprise.context.RequestScoped;
import java.util.Collections;
import java.util.UUID;

@RequestScoped
public class TokenService {

    public String generateCustomerToken(String email, String username) {
        return generateToken(email, username, Roles.CUSTOMER);
    }

    public String generateShopkeeperToken(String email, String username) {
        return generateToken(email, username, Roles.SHOPKEEPER);
    }

    public String generateAdminToken(String email, String username) {
        return generateToken(email, username, Roles.ADMIN);
    }

    public String generateToken(String email, String name, Roles roles) {
        try {
            JwtClaims jwtClaims = new JwtClaims();
            jwtClaims.setIssuer("https://quarkus.io/using-jwt-rbac");
            jwtClaims.setJwtId(UUID.randomUUID().toString());
            jwtClaims.setSubject(email);
            jwtClaims.setClaim(Claims.upn.name(), email);
            jwtClaims.setClaim(Claims.preferred_username.name(), name);
            jwtClaims.setClaim(Claims.groups.name(), Collections.singletonList(roles));
            jwtClaims.setAudience("using-jwt");
            jwtClaims.setExpirationTimeMinutesInTheFuture(60);

            return TokenUtils.generateTokenString(jwtClaims);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
