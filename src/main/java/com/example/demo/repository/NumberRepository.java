package com.example.demo.repository;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class NumberRepository {
    @Getter
    private final PriorityQueue<Integer> numbersAsMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    @Getter
    private final Integer heapSize;


    public NumberRepository(@Value("${largest-number-finder.data-set.size}") Integer heapSize) {
        this.heapSize = heapSize;
    }


    @PostConstruct
    public void initDataSet() {
        Random random = new Random();
        for (int i = 0; i < heapSize; i++) {
            numbersAsMaxHeap.add(random.nextInt(1_000_000));
        }
    }

    public List<Integer> getAllNumbersSorted() {
        List<Integer> sortedNumbers = new LinkedList<>(numbersAsMaxHeap);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public Integer getLargestNumber(int k) {
        if (k > numbersAsMaxHeap.size()) {
            throw new IllegalArgumentException("k too large");
        }
        List<Integer> polledNumbers = new LinkedList<>();
        for (int i = 0; i < k-1; i++) {
            Integer number = numbersAsMaxHeap.poll();
            polledNumbers.add(number);
        }
        Integer result = numbersAsMaxHeap.poll();
        numbersAsMaxHeap.addAll(polledNumbers);
        numbersAsMaxHeap.add(result);
        return result;
    }

    public void refreshDataSet () {
        numbersAsMaxHeap.clear();
        initDataSet();
    }

    public void clear() {
        numbersAsMaxHeap.clear();
    }
}
