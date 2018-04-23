package com.pojo;
// Generated Feb 3, 2018 3:14:18 PM by Hibernate Tools 4.3.1

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;




/**
 * Student generated by hbm2java
 */
@ManagedBean
public class Student  implements java.io.Serializable {


     private String firstname;
     private String lastname;
     private String username;
     private String password;
     private String email;
     private String message;

    public Student(String firstname, String lastname, String username, String password, String email, String message) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.message = message;
    }
    public Student() {
    }

	
    public Student(String firstname) {
        this.firstname = firstname;
    }
    public Student(String firstname, String lastname, String username, String password, String email) {
       this.firstname = firstname;
       this.lastname = lastname;
       this.username = username;
       this.password = password;
       this.email = email;
    }
   
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
     public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


public String doInsert(){
    StudentDAO dao=new StudentDAO();
    boolean result=dao.doInsert(this);
    if(result){
        return "login";
    }else{
        setFirstname("");
        setLastname("");
        setUsername("");
        setPassword("");
        setEmail("");
        setMessage("Registration Fail");
        return "insert";
    }
}
public String loginAction()throws SQLException{
    StudentDAO dao=new StudentDAO();
    boolean result=dao.loginA(username, password);
    if(result){
        return "wellcome";
    }else{
        setMessage("Login Fail");
        setUsername("");
        setPassword("");
        return "login";
    }
}
   

}


