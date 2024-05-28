package com.sinanengin.perfume.core.utilities.security;

import com.sinanengin.perfume.entities.Permission;
import com.sinanengin.perfume.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Token {
    User user;
    List<Permission> claims;
}

