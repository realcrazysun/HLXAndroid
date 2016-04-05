package com.polyent.hlx.ui.bean;


/**
 * 登录用户实体类
 * 
 * @author liux (http://my.oschina.net/liux)
 * @version 1.0
 * @created 2012-3-21
 */
@SuppressWarnings("serial")

public class User {

    private String username;
    private String faceurl;
    private int cover;
    private int gender;
    private String phone;
    private String sign;
    private String birthday;
    private String email;

    private int rvrc;
    private int money;

    private String level;
    private String easemob;
    private int follows;
    private int fans;
    private int vipid;
    private String bbscookiename;
    private String bbscookievalue;
    private int allowpush;
    private String login_token;
    private int uid;
    private String third_app_token;
    private String nickname;
    private String bbstoken;


    public String getBbstoken() {
        return bbstoken;
    }

    public void setBbstoken(String bbstoken) {
        this.bbstoken = bbstoken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFaceurl() {
        return faceurl;
    }

    public void setFaceurl(String faceurl) {
        this.faceurl = faceurl;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRvrc() {
        return rvrc;
    }

    public void setRvrc(int rvrc) {
        this.rvrc = rvrc;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEasemob() {
        return easemob;
    }

    public void setEasemob(String easemob) {
        this.easemob = easemob;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getVipid() {
        return vipid;
    }

    public void setVipid(int vipid) {
        this.vipid = vipid;
    }

    public String getBbscookiename() {
        return bbscookiename;
    }

    public void setBbscookiename(String bbscookiename) {
        this.bbscookiename = bbscookiename;
    }

    public String getBbscookievalue() {
        return bbscookievalue;
    }

    public void setBbscookievalue(String bbscookievalue) {
        this.bbscookievalue = bbscookievalue;
    }

    public int getAllowpush() {
        return allowpush;
    }

    public void setAllowpush(int allowpush) {
        this.allowpush = allowpush;
    }

    public String getLogin_token() {
        return login_token;
    }

    public void setLogin_token(String login_token) {
        this.login_token = login_token;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getThird_app_token() {
        return third_app_token;
    }

    public void setThird_app_token(String third_app_token) {
        this.third_app_token = third_app_token;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", faceurl='" + faceurl + '\'' +
                ", cover=" + cover +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", sign='" + sign + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", rvrc=" + rvrc +
                ", money=" + money +
                ", level='" + level + '\'' +
                ", easemob='" + easemob + '\'' +
                ", follows=" + follows +
                ", fans=" + fans +
                ", vipid=" + vipid +
                ", bbscookiename='" + bbscookiename + '\'' +
                ", bbscookievalue='" + bbscookievalue + '\'' +
                ", allowpush=" + allowpush +
                ", login_token='" + login_token + '\'' +
                ", uid=" + uid +
                ", third_app_token='" + third_app_token + '\'' +
                ", nickname='" + nickname + '\'' +
                ", bbstoken='" + bbstoken + '\'' +
                '}';
    }
}
