package com.example.demo.controller;

import com.example.demo.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ListIterator;

@RestController
@RequestMapping("heap")
public class NumberRestController {

    private final NumberService numberService;

    @Autowired
    public NumberRestController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping
    public List<Integer> getAllNumbers () {
        return numberService.selectAllNumbers();
    }

    @GetMapping("/{k}") //path = csak ha más beállítást is megadunk
    public Integer getKthLargestNumber (@PathVariable("k") Integer k) {
        return numberService.selectKthNumber(k);
    }

    @PutMapping
    public void regenerateAllNumbers () {
        numberService.replaceAllNumbers();
    }

    @DeleteMapping
    public void removeAllNumbers () {
        numberService.removeAllData();
    }
}
