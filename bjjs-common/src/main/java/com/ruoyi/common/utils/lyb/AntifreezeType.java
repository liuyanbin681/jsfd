package com.ruoyi.common.utils.lyb;

import java.util.HashMap;
import java.util.Map;

/**
 * 防冻液类型
 */
public enum AntifreezeType {

    Antifreeze("防冻液",0),
    Antifreeze_p("防冻粉",1);

    private int value;
    private String type;
    AntifreezeType(String type ,int value) {
        this.type =type;
        this.value =value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void Map(AntifreezeType antifreeze, String type){

    }
    private static final Map<String, AntifreezeType> map = new HashMap<>(5);
    public static AntifreezeType getValue(String key){
             return map.get(key);
    }
}
