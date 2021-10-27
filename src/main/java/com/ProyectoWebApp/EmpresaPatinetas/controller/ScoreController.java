package com.ProyectoWebApp.EmpresaPatinetas.controller;

import com.ProyectoWebApp.EmpresaPatinetas.service.ScoreService;
import com.ProyectoWebApp.EmpresaPatinetas.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
/**
 * This class allows mapping the entity score
 * @author: Laura De Villeros
 */
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getScores() { return scoreService.getAll(); }
    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int gScoreId) {
        return scoreService.getScore(gScoreId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score) { return scoreService.save(score); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score) { return scoreService.update(score); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int dScoreId) { return scoreService.deleteScore(dScoreId); }
}
