package com.blog.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "cai")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaiCai {

    private String url;
}
