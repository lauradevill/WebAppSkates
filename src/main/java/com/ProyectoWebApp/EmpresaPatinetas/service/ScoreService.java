package com.ProyectoWebApp.EmpresaPatinetas.service;

import com.ProyectoWebApp.EmpresaPatinetas.repository.ScoreRepository;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/**
 * This class defines business restrictions to the methods brought from repository for the entity-table score
 * @author: Laura De Villeros
 */
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    public List<Score> getAll(){ return scoreRepository.getAll(); }
    public Optional<Score> getScore(int id){ return scoreRepository.getScore(id);}
    public Score save(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.save(score);
        }else{
            Optional<Score> element= scoreRepository.getScore(score.getIdScore());
            if(element.isEmpty()){
                return scoreRepository.save(score);
            }else{
                return score;
            }
        }
    }
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> element=scoreRepository.getScore(score.getIdScore());
            if(!element.isEmpty()){
                if(score.getNumber()!=null){
                    element.get().setNumber(score.getNumber());
                }
                if(score.getMessageScore()!=null){
                    element.get().setMessageScore(score.getMessageScore());
                }
                if(score.getReservation()!=null){
                    element.get().setReservation(score.getReservation());
                }
                scoreRepository.save(element.get());
                return element.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }
    public boolean deleteScore(int id){
        boolean aBoolean=getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(aBoolean=false);
        return aBoolean;
    }
}
