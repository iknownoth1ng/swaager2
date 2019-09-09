package com.lxy.swagger2.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: swagger2-demo
 * @description:
 * @author: lxy
 * @create: 2019-09-07 22:11
 */
@ApiModel("用户")
public class User {
@ApiModelProperty("用户名")
    public String username;
@ApiModelProperty("密码")
    public String password;
}
