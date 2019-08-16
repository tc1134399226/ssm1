package com.qianfeng.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class UserTest implements Serializable {
    @Length(min = 2,max = 20,message = "名字不合法")
    String userName;
    @NotBlank
    String password;
    @Length(min = 2,max = 20,message = "账号不合法")
    String accountName;
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message = "邮箱地址不合法")
    String email;


    //上传成功

    //上传成功是否

}