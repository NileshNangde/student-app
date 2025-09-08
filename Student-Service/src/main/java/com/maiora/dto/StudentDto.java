package com.maiora.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {

    private Long id;
    private String name;
    private Integer dobDay;
    private Integer dobMonth;
    private Integer dobYear;
    private Integer age;
}
