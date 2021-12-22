package com.tzy.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Hung
 * @date 2021/11/2 23:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserAuthorityDTO {
    private Long id;
    private String username;
    private String password;
    private List<String> roles;
}
