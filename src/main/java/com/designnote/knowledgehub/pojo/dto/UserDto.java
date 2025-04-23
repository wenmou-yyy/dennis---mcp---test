package com.designnote.knowledgehub.pojo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
public class UserDto {

    @NotBlank (message ="username can not be empty")
    private String username;

    @NotBlank(message ="password can not be empty")
    @Length(min=6,max=12)
    private String password;

//    @Email(message ="incorrect email format")
//    private String email;
}
