package com.example.jsontodb.services;

import com.example.jsontodb.domain.Summary;
import org.springframework.web.bind.annotation.ResponseBody;

public interface SummaryService {
    void saveCovidData(Summary summary);
}
