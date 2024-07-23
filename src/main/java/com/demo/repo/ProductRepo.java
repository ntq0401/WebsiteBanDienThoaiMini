package com.demo.repo;

import com.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("SELECT P FROM Product P WHERE P.name LIKE ?1 AND P.category.id Like ?2 AND P.price BETWEEN ?3 AND ?4")
    Page<Product> findByALL(String keyword,String categoryID ,double min, double max,Pageable pageable);
}
