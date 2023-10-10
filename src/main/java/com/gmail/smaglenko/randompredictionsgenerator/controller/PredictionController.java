package com.gmail.smaglenko.randompredictionsgenerator.controller;

import com.gmail.smaglenko.randompredictionsgenerator.dto.PredictionDto;
import com.gmail.smaglenko.randompredictionsgenerator.model.Prediction;
import com.gmail.smaglenko.randompredictionsgenerator.service.PredictionService;
import com.gmail.smaglenko.randompredictionsgenerator.util.mapper.PredictionDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prediction")
@RequiredArgsConstructor
public class PredictionController {
    private final PredictionService predictionService;
    private final PredictionDtoMapper predictionDtoMapper;

    @PostMapping("/create")
    public ResponseEntity<String> createPrediction(@RequestBody PredictionDto dto) {
        predictionService.add(predictionDtoMapper.mapToModel(dto));
        return ResponseEntity.ok("Prediction successfully added!");
    }

    @GetMapping("/get-prediction-for-today")
    public ResponseEntity<String> getPrediction() {
        Prediction randomPrediction = predictionService.getRandomPrediction();
        return ResponseEntity.ok(randomPrediction.getContent());
    }
}
