package com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="Categories")
public class Category implements Serializable {
    @Id
    @NotBlank(message = "Không được bỏ trống id !")
    String id;
    @NotBlank(message = "Không được bỏ trống tên !")
    String name;
}
