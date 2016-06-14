package com.oreilly.helloworld;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static final List<Data> VALUES = new ArrayList<>();

    static {
        VALUES.add(new Data("<font color=\"red\"><b>Hire Tony</b></font> As A Consultant",
                "(You Can't Afford Him)"));
        VALUES.add(new Data("Contact the (Marvel) <font color=\"red\"><i>Avengers</i></font>",
                "(We have a <font color=\"green\"><b>HULK</b></font>)"));
        VALUES.add(new Data("Complaints",
                "mailto:justin.hammer@hammertech.com"));
        VALUES.add(new Data("Need the <font color=\"blue\"><b>Iron Patriot</b></font>",
                "(Try <i>WarMachineRox</i>)"));
    }

    private String title;
    private String detail;

    public Data(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }
}
