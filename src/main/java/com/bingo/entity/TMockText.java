package com.bingo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_mock_text
 * @author 
 */
@Data
public class TMockText implements Serializable {
    private Integer id;

    private String name;

    private String jsonData;

    private String createTime;

    private String updateTime;

    private Boolean state;

    private String createUser;

    private static final long serialVersionUID = 1L;
}