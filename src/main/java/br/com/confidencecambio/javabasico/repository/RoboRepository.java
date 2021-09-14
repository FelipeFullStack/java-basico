package br.com.confidencecambio.javabasico.repository;


import br.com.confidencecambio.javabasico.model.Robo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoboRepository extends JpaRepository<Robo, Integer> {
}
