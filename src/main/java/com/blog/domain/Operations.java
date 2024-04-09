package com.blog.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName operations
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operations implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     *
     */
    private Integer username;

    /**
     *
     */
    private Object recordMethod;

    /**
     *
     */
    private String record;

    /**
     *
     */
    private String timeConsuming;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    private static final long serialVersionUID = 1L;
}
