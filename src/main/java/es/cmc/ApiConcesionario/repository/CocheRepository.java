package es.cmc.ApiConcesionario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.cmc.prueba.ApiConcesionario.entities.Coche;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer>{
}
