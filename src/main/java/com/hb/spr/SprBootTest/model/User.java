package com.hb.spr.SprBootTest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hb.spr.SprBootTest.define.HbBean;

@Entity
@Table(name="hb_user")
public class User extends HbBean {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String account;
    private String password;
    private Integer age;
    private Integer sex;
    private String domain;
    private String email;
    private String userLevel;
    private String country;
    private Date birthdate;
    private String state;
    private String registerIp;
    private String lastLoginIp;
    private Integer deleted;
    private String race;//种族
    private String flag;
    
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getAccount()
    {
        return account;
    }
    public void setAccount(String account)
    {
        this.account = account;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public Integer getAge()
    {
        return age;
    }
    public void setAge(Integer age)
    {
        this.age = age;
    }
    public Integer getSex()
    {
        return sex;
    }
    public void setSex(Integer sex)
    {
        this.sex = sex;
    }
    public String getDomain()
    {
        return domain;
    }
    public void setDomain(String domain)
    {
        this.domain = domain;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getCountry()
    {
        return country;
    }
    public void setCountry(String country)
    {
        this.country = country;
    }
    public Date getBirthdate()
    {
        return birthdate;
    }
    public void setBirthdate(Date birthdate)
    {
        this.birthdate = birthdate;
    }
    public String getState()
    {
        return state;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    public String getRegisterIp()
    {
        return registerIp;
    }
    public void setRegisterIp(String registerIp)
    {
        this.registerIp = registerIp;
    }
    public String getLastLoginIp()
    {
        return lastLoginIp;
    }
    public void setLastLoginIp(String lastLoginIp)
    {
        this.lastLoginIp = lastLoginIp;
    }
    public Integer getDeleted()
    {
        return deleted;
    }
    public void setDeleted(Integer deleted)
    {
        this.deleted = deleted;
    }
    public String getRace()
    {
        return race;
    }
    public void setRace(String race)
    {
        this.race = race;
    }
    public String getFlag()
    {
        return flag;
    }
    public void setFlag(String flag)
    {
        this.flag = flag;
    }
    public String getUserLevel()
    {
        return userLevel;
    }
    public void setUserLevel(String userLevel)
    {
        this.userLevel = userLevel;
    }
    
}
