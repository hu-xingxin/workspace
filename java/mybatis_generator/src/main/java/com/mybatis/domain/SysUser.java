package com.mybatis.domain;

import java.util.Date;

public class SysUser {
    private Long user_id;

    private Long dept_id;

    private String login_name;

    private String user_name;

    private String user_type;

    private String email;

    private String phonenumber;

    private String sex;

    private String law_num;

    private String avatar;

    private String password;

    private String salt;

    private String status;

    private String del_flag;

    private String login_ip;

    private Date login_date;

    private String create_by;

    private Date create_time;

    private String update_by;

    private Date update_time;

    private String remark;

    private String user_genre;

    private String law_fa;

    private String ledger_icon;

    private String login_permission;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name == null ? null : login_name.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type == null ? null : user_type.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getLaw_num() {
        return law_num;
    }

    public void setLaw_num(String law_num) {
        this.law_num = law_num == null ? null : law_num.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag == null ? null : del_flag.trim();
    }

    public String getLogin_ip() {
        return login_ip;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip == null ? null : login_ip.trim();
    }

    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by == null ? null : create_by.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by == null ? null : update_by.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUser_genre() {
        return user_genre;
    }

    public void setUser_genre(String user_genre) {
        this.user_genre = user_genre == null ? null : user_genre.trim();
    }

    public String getLaw_fa() {
        return law_fa;
    }

    public void setLaw_fa(String law_fa) {
        this.law_fa = law_fa == null ? null : law_fa.trim();
    }

    public String getLedger_icon() {
        return ledger_icon;
    }

    public void setLedger_icon(String ledger_icon) {
        this.ledger_icon = ledger_icon == null ? null : ledger_icon.trim();
    }

    public String getLogin_permission() {
        return login_permission;
    }

    public void setLogin_permission(String login_permission) {
        this.login_permission = login_permission == null ? null : login_permission.trim();
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "user_id=" + user_id +
                ", dept_id=" + dept_id +
                ", login_name='" + login_name + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_type='" + user_type + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", sex='" + sex + '\'' +
                ", law_num='" + law_num + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                ", del_flag='" + del_flag + '\'' +
                ", login_ip='" + login_ip + '\'' +
                ", login_date=" + login_date +
                ", create_by='" + create_by + '\'' +
                ", create_time=" + create_time +
                ", update_by='" + update_by + '\'' +
                ", update_time=" + update_time +
                ", remark='" + remark + '\'' +
                ", user_genre='" + user_genre + '\'' +
                ", law_fa='" + law_fa + '\'' +
                ", ledger_icon='" + ledger_icon + '\'' +
                ", login_permission='" + login_permission + '\'' +
                '}';
    }
}