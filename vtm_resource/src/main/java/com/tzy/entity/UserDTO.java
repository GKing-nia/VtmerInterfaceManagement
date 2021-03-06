package com.tzy.entity;

import lombok.Data;

/**
 * 用户信息
 *
 * @author Hung
 */
@Data
public class UserDTO {

    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 姓名
     */
    private String fullName;

}
