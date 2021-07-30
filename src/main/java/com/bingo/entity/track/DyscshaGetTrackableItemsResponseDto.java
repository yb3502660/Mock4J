package com.bingo.entity.track;

import java.util.List;

/**
 * trackable_items 响应体
 */
public class DyscshaGetTrackableItemsResponseDto {

    /**
     * 箱号
     */
    private String article_id;
    /**
     * 产品类型
     */
    private String product_type;
    /**
     * 物流状态
     */
    private List<DyscshaGetTrackableItemsEventsResponseDto> events;
    /**
     * 最新状态
     */
    private String status;

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public List<DyscshaGetTrackableItemsEventsResponseDto> getEvents() {
        return events;
    }

    public void setEvents(List<DyscshaGetTrackableItemsEventsResponseDto> events) {
        this.events = events;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
