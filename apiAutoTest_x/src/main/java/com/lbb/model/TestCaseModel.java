package com.lbb.model;

import lombok.Data;

@Data
public class TestCaseModel {
    private int id;
    private int interfacesId;
    private String key;
    private String value;
    private String parentId;
    private int passed;

}
