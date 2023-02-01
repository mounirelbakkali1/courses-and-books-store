package com.pluralsight.dto;

import com.pluralsight.models.Chapitre;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class ChapitresDTOMapper implements Function<Chapitre,ChapiterDTO> {
    @Override
    public ChapiterDTO apply(Chapitre chapitre) {
        return new ChapiterDTO(
                chapitre.getTitle(),
                chapitre.getContent(),
                chapitre.getQuiz().getDescription(),
                String.format("%.1f",chapitre.getQuiz().getSuccessRate()*100)+"%"
        );
    }
}
