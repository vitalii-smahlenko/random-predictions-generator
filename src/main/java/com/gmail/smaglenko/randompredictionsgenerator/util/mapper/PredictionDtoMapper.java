package com.gmail.smaglenko.randompredictionsgenerator.util.mapper;

import com.gmail.smaglenko.randompredictionsgenerator.dto.PredictionDto;
import com.gmail.smaglenko.randompredictionsgenerator.model.Prediction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PredictionDtoMapper {
    @Mapping(target = "id", ignore = true)
    PredictionDto mapToDto(Prediction prediction);

    Prediction mapToModel(PredictionDto dto);
}
