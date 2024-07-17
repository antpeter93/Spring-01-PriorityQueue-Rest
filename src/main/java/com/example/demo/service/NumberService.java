package com.example.demo.service;

import com.example.demo.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class NumberService {
    private final NumberRepository repository;

    @Autowired
    public NumberService(NumberRepository repository) {
        this.repository = repository;
    }

    public List<Integer> selectAllNumbers () {
        List<Integer> result = new LinkedList<>();
        result.addAll(repository.getNumbersAsMaxHeap());
        return result;
    }

    public Integer selectKthNumber (Integer k) {
        Integer kthLargestNumber = repository.getLargestNumber(k);
        return kthLargestNumber;
    }

    public void replaceAllNumbers () {
        repository.refreshDataSet();
    }

    public void removeAllData () {
        repository.clear();
    }
}
