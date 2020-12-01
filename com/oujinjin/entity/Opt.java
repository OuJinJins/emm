package com.oujinjin.entity;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.ArrayList;

public class Opt implements Serializable {
    public String opt;

    public Opt(String opt) {
        this.opt = opt;
    }

    public Opt() {
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getOpt() {
        return opt;
    }

    @Override
    public String toString(){
        return getOpt();
    }
}
