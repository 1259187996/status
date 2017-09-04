package com.im.status.model;

import java.io.Serializable;

/**
 * Created by zhizhuang.yang on 2017/7/25.
 */
public class Range<T> implements Serializable{

    private static final long serialVersionUID = 1L;
    private T min, max;
    private boolean minIncluded = true;
    private boolean maxIncluded = false;

    public Range(T min, T max) {
        this.setMin(min);
        this.setMax(max);
    }

    public Range(){}

    public T getMin() {
        return min;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public boolean isMinIncluded() {
        return minIncluded;
    }

    public void setMinIncluded(boolean minIncluded) {
        this.minIncluded = minIncluded;
    }

    public boolean isMaxIncluded() {
        return maxIncluded;
    }

    public void setMaxIncluded(boolean maxIncluded) {
        this.maxIncluded = maxIncluded;
    }
}
