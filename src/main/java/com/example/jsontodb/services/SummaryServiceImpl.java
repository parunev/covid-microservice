package com.example.jsontodb.services;

import com.example.jsontodb.domain.Summary;
import com.example.jsontodb.repositories.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryServiceImpl implements SummaryService {

    private final SummaryRepository summaryRepository;

    @Autowired
    public SummaryServiceImpl(SummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    @Override
    public void saveCovidData(Summary summary) {
        summaryRepository.save(summary);
    }
}
