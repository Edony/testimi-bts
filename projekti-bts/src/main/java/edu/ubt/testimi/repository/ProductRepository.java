package edu.ubt.testimi.repository;

import edu.ubt.testimi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
