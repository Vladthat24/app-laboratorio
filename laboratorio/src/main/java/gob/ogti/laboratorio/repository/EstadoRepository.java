package gob.ogti.laboratorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.ogti.laboratorio.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
