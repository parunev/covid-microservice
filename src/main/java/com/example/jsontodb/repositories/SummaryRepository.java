package com.example.jsontodb.repositories;

import com.example.jsontodb.domain.Summary;
import org.springframework.data.repository.CrudRepository;

public interface SummaryRepository extends CrudRepository<Summary, String> {
}
