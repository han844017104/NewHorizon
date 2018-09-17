package com.qfedu.newhorizon.domain.user;

import java.util.Date;

/**
 * 　　　Create   By   Mr.Han
 * 　                 　　　　　------   On   2018/9/16  18:31
 */
public class UserMain extends User{


    private String username;


    private String tel;


    private String password;


    private String nickname;


    private Date maketime;


    private Integer flag;

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }


    public String getTel() {
        return tel;
    }


    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


    public String getNickname() {
        return nickname;
    }


    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }


    public Date getMaketime() {
        return maketime;
    }


    public void setMaketime(Date maketime) {
        this.maketime = maketime;
    }


    public Integer getFlag() {
        return flag;
    }


    public void setFlag(Integer flag) {
        this.flag = flag;
    }

}
