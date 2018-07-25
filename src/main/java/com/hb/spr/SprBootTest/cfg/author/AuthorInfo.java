package com.hb.spr.SprBootTest.cfg.author;


import com.hb.spr.SprBootTest.utils.SpringUtils;

public class AuthorInfo {
    private String name = "***";
    private String remarks = "*****";
    
    public static AuthorInfo getInstance(){
        try{
            return SpringUtils.getBean(AuthorInfo.class);
        }catch(Exception e){
            System.err.println(e.getMessage());
            return new AuthorInfo();
        }
    }
    
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
