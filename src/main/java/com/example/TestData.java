package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestData {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "col_1")
    private String col1;

    @Column(name = "col_2")
    private String col2;

    public TestData() {
    }

    public TestData(String col1, String col2) {
        this.col1 = col1;
        this.col2 = col2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }
}
