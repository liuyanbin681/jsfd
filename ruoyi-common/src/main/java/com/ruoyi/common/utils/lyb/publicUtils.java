package com.ruoyi.common.utils.lyb;

/**
 * @date 2019-8-10
 * @author lyb
 */
public class publicUtils {
    /**
     * 防止在数值在相加值为空报错
     * @param value
     * @return
     */
    public static int defaultValue(int value){
       return value==0? 0:value;
    }
}
