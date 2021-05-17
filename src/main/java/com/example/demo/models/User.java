package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private Boolean active;
    private Integer score;
    private Boolean admin;
    private Integer hp;
    private Integer czyJestemGlupi;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        setAdmin(false);
        setScore(0);
        setActive(true);
        setHp(5);
        setCzyJestemGlupi(27);

    }

    public User() {

    }

    public Integer getCzyJestemGlupi() {
        return czyJestemGlupi;
    }

    public void setCzyJestemGlupi(Integer czyJestemGlupi) {
        this.czyJestemGlupi = czyJestemGlupi;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
