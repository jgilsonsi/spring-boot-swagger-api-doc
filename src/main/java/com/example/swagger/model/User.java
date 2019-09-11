package com.example.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(description = "All details about the User.")
public class User {

    @NotEmpty(message = "Name cannot be empty.")
    @Length(max = 255, message = "Name must be contain a maximum of {max} characters.")
    @ApiModelProperty(notes = "The name of the user")
    private String name;

    @NotEmpty(message = "Password cannot be empty.")
    @Length(min = 6, max = 255, message = "Password must be contain between {min} and {max} characters.")
    @ApiModelProperty(notes = "The password of the user")
    private String passwod;
}
