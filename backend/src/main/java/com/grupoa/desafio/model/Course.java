package com.grupoa.desafio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Course Model")
public class Course {
    @ApiModelProperty(notes = "Course ID", example = "1", dataType = "long")
    private Long id;
    @ApiModelProperty(notes = "Course description", example = "Programacao Web", dataType = "string")
    private String description;
    @ApiModelProperty(notes = "Course Activate", example = "true", dataType = "boolean")
    private boolean active;
    @ApiModelProperty(notes = "Institution", example = "true", dataType = "Institution")
    private Institution institution;
}
