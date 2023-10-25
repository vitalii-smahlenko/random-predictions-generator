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
@RequestMapping("/predictions")
@RequiredArgsConstructor
public class PredictionController {
    private final PredictionService predictionService;
    private final PredictionDtoMapper predictionDtoMapper;

    @PostMapping()
    public PredictionDto createPrediction(@RequestBody PredictionDto dto) {
        return predictionDtoMapper
                .mapToDto(predictionService.add(predictionDtoMapper.mapToModel(dto)));
    }

    @GetMapping("/get-random")
    public ResponseEntity<String> getPrediction() {
        Prediction randomPrediction = predictionService.getRandomPrediction();
        return ResponseEntity.ok(randomPrediction.getContent());
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello random-predictions-generator app!!!");
    }
}
