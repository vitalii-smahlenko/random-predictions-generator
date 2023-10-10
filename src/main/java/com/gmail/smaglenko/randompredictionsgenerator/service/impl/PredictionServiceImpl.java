package com.gmail.smaglenko.randompredictionsgenerator.service.impl;

import com.gmail.smaglenko.randompredictionsgenerator.model.Prediction;
import com.gmail.smaglenko.randompredictionsgenerator.repository.PredictionRepository;
import com.gmail.smaglenko.randompredictionsgenerator.service.PredictionService;
import java.util.NoSuchElementException;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PredictionServiceImpl implements PredictionService {
    private final PredictionRepository repository;

    @Override
    public Prediction add(Prediction prediction) {
        return repository.save(prediction);
    }

    @Override
    public Prediction getRandomPrediction() {
        Integer numberOfPrediction = repository.countPredictionById();
        Random random = new Random();
        Long id = (long) random.nextInt(numberOfPrediction + 1);
        return repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Something went wrong try again!")
        );
    }
}
