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
    private final PredictionRepository predictionRepository;

    @Override
    public Prediction add(Prediction prediction) {
        return predictionRepository.save(prediction);
    }

    @Override
    public Prediction getRandomPrediction() {
        long numberOfPrediction = predictionRepository.count();
        Random random = new Random();
        long id = (long) random.nextInt(1,(int) numberOfPrediction + 1);
        return predictionRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Something went wrong try again!")
        );
    }
}
