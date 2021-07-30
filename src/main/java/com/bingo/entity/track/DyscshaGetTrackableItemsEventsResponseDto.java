package com.bingo.entity.track;

/**
 * 轨迹节点
 */
public class DyscshaGetTrackableItemsEventsResponseDto {

    /**
     * 【必填】 地点
     */
     private String location;
    /**
     *【必填】  状态
     */
    private String description;
    /**
     * 【必填】 时间
     */
     private String date;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
