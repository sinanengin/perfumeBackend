package com.sinanengin.perfume.entities.dtos;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserForRegister {
    private String username;
    private String password;
    private String email;
}
