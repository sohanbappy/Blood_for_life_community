/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.general;


/**
 *
 * @author Bappy's Pc
 */
public class generalMember {
    
    private int sl;
    private String name,mail,phone,bl_gr,age,weight,pass,status,dist,location,last_given,req;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
    

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBl_gr() {
        return bl_gr;
    }

    public void setBl_gr(String bl_gr) {
        this.bl_gr = bl_gr;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLast_given() {
        return last_given;
    }

    public void setLast_given(String last_given) {
        this.last_given = last_given;
    }

    /**
     * @return the req
     */
    public String getReq() {
        return req;
    }

    /**
     * @param req the req to set
     */
    public void setReq(String req) {
        this.req = req;
    }

 
}
