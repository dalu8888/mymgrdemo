package io.renren.entity;

import java.sql.Date;

/**
 * Created by asus on 2017/5/24.
 */
public class SysRealNameEntity {
    private static final long serialVersionUID = 1L;

    private String userid;
    private String login;
    private String name;
    private String paperworktype;
    private String paperworkcode;
    private String frontphoto;
    private String basckphoto;
    private String headphoto;
    private Date applytime;
    private Date updatetime;
    private String applyway;
    private String applysiteid;
    private String verifyuser;
    private String verifyopinion;
    private Integer verifytimelimit;
    private Date verifycompletetime;
    private String state; //01：审核中，02：审核通过；03：审核未通过
    private String source;
    private Integer applytimes;
    private Date verifyendtime;
    private Integer rejecttimes;
    private String applylevel;
    private String verifyuserlogin;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaperworktype() {
        return paperworktype;
    }

    public void setPaperworktype(String paperworktype) {
        this.paperworktype = paperworktype;
    }

    public String getPaperworkcode() {
        return paperworkcode;
    }

    public void setPaperworkcode(String paperworkcode) {
        this.paperworkcode = paperworkcode;
    }

    public String getFrontphoto() {
        return frontphoto;
    }

    public void setFrontphoto(String frontphoto) {
        this.frontphoto = frontphoto;
    }

    public String getBasckphoto() {
        return basckphoto;
    }

    public void setBasckphoto(String basckphoto) {
        this.basckphoto = basckphoto;
    }

    public String getHeadphoto() {
        return headphoto;
    }

    public void setHeadphoto(String headphoto) {
        this.headphoto = headphoto;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getApplyway() {
        return applyway;
    }

    public void setApplyway(String applyway) {
        this.applyway = applyway;
    }

    public String getApplysiteid() {
        return applysiteid;
    }

    public void setApplysiteid(String applysiteid) {
        this.applysiteid = applysiteid;
    }

    public String getVerifyuser() {
        return verifyuser;
    }

    public void setVerifyuser(String verifyuser) {
        this.verifyuser = verifyuser;
    }

    public String getVerifyopinion() {
        return verifyopinion;
    }

    public void setVerifyopinion(String verifyopinion) {
        this.verifyopinion = verifyopinion;
    }

    public Integer getVerifytimelimit() {
        return verifytimelimit;
    }

    public void setVerifytimelimit(Integer verifytimelimit) {
        this.verifytimelimit = verifytimelimit;
    }

    public Date getVerifycompletetime() {
        return verifycompletetime;
    }

    public void setVerifycompletetime(Date verifycompletetime) {
        this.verifycompletetime = verifycompletetime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getApplytimes() {
        return applytimes;
    }

    public void setApplytimes(Integer applytimes) {
        this.applytimes = applytimes;
    }

    public Date getVerifyendtime() {
        return verifyendtime;
    }

    public void setVerifyendtime(Date verifyendtime) {
        this.verifyendtime = verifyendtime;
    }

    public Integer getRejecttimes() {
        return rejecttimes;
    }

    public void setRejecttimes(Integer rejecttimes) {
        this.rejecttimes = rejecttimes;
    }

    public String getApplylevel() {
        return applylevel;
    }

    public void setApplylevel(String applylevel) {
        this.applylevel = applylevel;
    }

    public String getVerifyuserlogin() {
        return verifyuserlogin;
    }

    public void setVerifyuserlogin(String verifyuserlogin) {
        this.verifyuserlogin = verifyuserlogin;
    }
}
