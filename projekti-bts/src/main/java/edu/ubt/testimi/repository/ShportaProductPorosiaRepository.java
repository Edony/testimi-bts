package edu.ubt.testimi.repository;

import edu.ubt.testimi.entity.ShportaProductPorosia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShportaProductPorosiaRepository extends JpaRepository<ShportaProductPorosia, Long> {

    Long countByPorosiaId(Long id);
    List<ShportaProductPorosia> findAllByPorosiaId(Long id);

}
