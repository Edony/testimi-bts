package edu.ubt.testimi.repository;

import edu.ubt.testimi.entity.Product;
import edu.ubt.testimi.entity.ShportaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShportaProductRepository extends JpaRepository<ShportaProduct, Long> {

    Boolean existsByProduct(Product product);


}
