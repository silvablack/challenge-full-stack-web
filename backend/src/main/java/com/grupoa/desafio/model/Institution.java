package com.grupoa.desafio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "Institution Model")
public class Institution {
    @ApiModelProperty(notes = "Institution ID", example = "1", dataType = "long")
    private Long id;
    @ApiModelProperty(notes = "Institution description", example = "EdTech", dataType = "string")
    private String description;
    @ApiModelProperty(notes = "Institution Activate", example = "true", dataType = "boolean")
    private boolean active;
}
