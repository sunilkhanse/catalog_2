package com.catalog.repository;

import com.catalog.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    public Optional<ProductCategory> findById(Integer id);

    public boolean existsByName(String category);
}
