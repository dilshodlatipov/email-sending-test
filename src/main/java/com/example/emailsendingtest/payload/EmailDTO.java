package com.example.emailsendingtest.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO {
    @NotBlank
    private String from;
    @NotBlank
    @Email(regexp = "\\w{5,}@\\w{4,12}\\.[a-zA-Z]{3,5}")
    private String toWhom;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;
}