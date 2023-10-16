package com.gmail.smaglenko.randompredictionsgenerator.service;

import com.gmail.smaglenko.randompredictionsgenerator.model.Prediction;

public interface PredictionService {
    Prediction add(Prediction prediction);

    Prediction getRandomPrediction();
}
