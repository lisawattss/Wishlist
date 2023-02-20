package com.example.Wishlist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID of wisher
    private String usn;
    private String psw;

    public Wisher() {
    }

    public Wisher(Long id, String usn, String psw) {
        this.id = id;
        this.usn = usn;
        this.psw = psw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}