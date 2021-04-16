package org.souzarodrigo.core.utils.models.users;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.souzarodrigo.core.utils.security.constants.Roles;

import java.time.LocalDateTime;

public abstract class User extends PanacheMongoEntity {

    public Roles role;

    public String name;
    public String email;
    public String password;

    public String phone;

    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    public User() {

        setCreatedAt(LocalDateTime.now());
        setUpdatedAt(LocalDateTime.now());
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
