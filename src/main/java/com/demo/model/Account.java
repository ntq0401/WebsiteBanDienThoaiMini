package com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="Accounts")
public class Account implements Serializable {
    @Id
    @NotBlank(message = "Không được bỏ trống username")
    String username;
    @NotBlank(message = "Không được bỏ trống password")
    String password;
    @NotBlank(message = "Không được bỏ trống fullname")
    String fullname;
    @NotBlank(message = "Không được bỏ trống email")
    String email;
}
