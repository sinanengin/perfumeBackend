package com.sinanengin.perfume.entities.dtos;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserForLogin{
    private String email;
    private String password;
}
