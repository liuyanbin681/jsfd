package com.ruoyi.system.domain;

public class Sum {
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /***
     * 单位名称
     */
    private String name;
    /***
     * 煤车数
     */
    private Integer coalCount;
    /**
     * 煤用了多少防冻液
     */
    private Integer coalAntifreezeSum;

    /***
     * 矿粉车数车数
     */
    private Integer mpCount;
    /**
     * 矿粉用了多少防冻液
     */
    private Integer mpSum;
    /**
     * 喷洒总量
     */
    private Integer mpCSum;

    public Integer getMpCSum() {
        return mpCSum;
    }

    public void setMpCSum(Integer mpCSum) {
        this.mpCSum = mpCSum;
    }

    /**
     * 冻车合计
     */
    private Integer fre;

    public Integer getFre() {
        return fre;
    }

    public void setFre(Integer fre) {
        this.fre = fre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoalCount() {
        return coalCount;
    }

    public void setCoalCount(Integer coalCount) {
        this.coalCount = coalCount;
    }

    public Integer getCoalAntifreezeSum() {
        return coalAntifreezeSum;
    }

    public void setCoalAntifreezeSum(Integer coalAntifreezeSum) {
        this.coalAntifreezeSum = coalAntifreezeSum;
    }

    public Integer getMpCount() {
        return mpCount;
    }

    public void setMpCount(Integer mpCount) {
        this.mpCount = mpCount;
    }

    public Integer getMpSum() {
        return mpSum;
    }

    public void setMpSum(Integer mpSum) {
        this.mpSum = mpSum;
    }
    @Override
    public String toString() {
        return "Sum{" +
                "name='" + name + '\'' +
                ", coalCount=" + coalCount +
                ", coalAntifreezeSum=" + coalAntifreezeSum +
                ", mpCount=" + mpCount +
                ", mpSum=" + mpSum +
                ", Free=" +  +
                '}';
    }
}
