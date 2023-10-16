package com.gmail.smaglenko.randompredictionsgenerator.repository;

import com.gmail.smaglenko.randompredictionsgenerator.model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PredictionRepository extends JpaRepository<Prediction, Long> {
}
