package com.grupoa.desafio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Student Model")
public class Student {

    public static final String MSG_STUDENT_ALREADY_EXIST = "Student already exist";
    public static final String MSG_STUDENT_CREATE_NOT_COMPLETED = "Student create not completed";
    public static final String MSG_STUDENT_UPDATE_NOT_COMPLETED = "Student update not completed";
    public static final String MSG_STUDENT_DELETE_NOT_COMPLETED = "Student delete not completed";
    public static final String MSG_STUDENT_NOT_FOUND = "No student found";
    public static final String MSG_STUDENT_CREATED = "Student created";
    public static final String MSG_STUDENT_UPDATED = "Student updated";
    public static final String MSG_STUDENT_DELETED = "Student deleted";

    @ApiModelProperty(notes = "Student Registration", example = "1", dataType = "long")
    private Long registration;
    @ApiModelProperty(notes = "Student name", example = "Miguel", dataType = "string")
    @NotNull(message = "The name id cannot be null")
    @NotEmpty(message = "The name id cannot be empty")
    private String name;
    @NotNull(message = "The email cannot be null")
    @NotEmpty(message = "The email cannot be empty")
    @ApiModelProperty(notes = "Student email", example = "miguel@gmail.com", dataType = "string")
    private String email;
    @ApiModelProperty(notes = "Student CPF", example = "01212312399", dataType = "string")
    @NotNull(message = "The CPF cannot be null")
    @NotEmpty(message = "The CPF cannot be empty")
    private String cpf;
    @ApiModelProperty(notes = "Student Activate", example = "true", dataType = "boolean")
    private boolean active;
}
