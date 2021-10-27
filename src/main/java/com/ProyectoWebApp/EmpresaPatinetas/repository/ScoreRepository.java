package com.ProyectoWebApp.EmpresaPatinetas.repository;

import com.ProyectoWebApp.EmpresaPatinetas.repository.crud.ScoreCrudRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
/**
 * This class defines the methods to bring from CRUD repository for the entity-table score
 * @author: Laura De Villeros
 */
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    public List<Score> getAll() { return (List<Score>) scoreCrudRepository.findAll(); }
    public Optional<Score> getScore(int id) { return scoreCrudRepository.findById(id); }
    public Score save(Score score) { return scoreCrudRepository.save(score); }
    public void delete(Score score) { scoreCrudRepository.delete(score); }
}
