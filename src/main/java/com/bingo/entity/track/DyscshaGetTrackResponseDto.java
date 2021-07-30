package com.bingo.entity.track;

import java.util.List;

/**
 * 轨迹响应报文
 */
public class DyscshaGetTrackResponseDto {

    /**
     * 【必填】箱号
     */
    private String tracking_id;
    /**
     * 【必填】状态
     */
    private String status;
    /**
     * 【必填】物流状态
     */
    private List<DyscshaGetTrackableItemsResponseDto> trackable_items;
    /**
     * 【必填】错误信息
     */
    private List<DyscshaGetTrackErrorResponseDto> errors;

    public String getTracking_id() {
        return tracking_id;
    }

    public void setTracking_id(String tracking_id) {
        this.tracking_id = tracking_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DyscshaGetTrackableItemsResponseDto> getTrackable_items() {
        return trackable_items;
    }

    public void setTrackable_items(List<DyscshaGetTrackableItemsResponseDto> trackable_items) {
        this.trackable_items = trackable_items;
    }

    public List<DyscshaGetTrackErrorResponseDto> getErrors() {
        return errors;
    }

    public void setErrors(List<DyscshaGetTrackErrorResponseDto> errors) {
        this.errors = errors;
    }
}
