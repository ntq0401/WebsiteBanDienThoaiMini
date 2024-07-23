package com.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name="Products")
public class Product implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotBlank(message = "Không được bỏ trống tên !")
    String name;
    @NotNull(message = "Không được bỏ trống giá")
    Integer price;
    @ManyToOne @JoinColumn(name="Categoryid")
    @NotNull(message = "Không được bỏ trống nhóm sản phẩm")
    Category category;
    @NotBlank(message = "Không được bỏ trống ảnh !")
    String image;
}
