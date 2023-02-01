package com.pluralsight.dto;

import com.pluralsight.models.Audiance;
import com.pluralsight.models.Chapitre;
import com.pluralsight.models.Instructor;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

public record CourseDTO(
        String title,
        Duration duration,
        Instructor instructor,
        byte[] image,
        List<ChapiterDTO> chapitres,
        Set<Audiance> audiance,
        Date relaseDate,
        float price
) {
}
