package com.pluralsight.dto;

public record ChapiterDTO(
        String title,
        String content,
        String quiz_description ,
        String quiz_success_rate
) {
}
