package com.example.android_project.Common;

public class AskDTO {
    private String key, value; //AsynkTask 실행 시 name 부분과 text 부분을
                                //유동적으로 사용하고 더 편리하게 사용하기 위함.


    public AskDTO(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
