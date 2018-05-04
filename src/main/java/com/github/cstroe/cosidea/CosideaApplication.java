package com.github.cstroe.cosidea;

import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CosideaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosideaApplication.class, args);
    }

    @Bean
    public Parser commonmarkParser() {
        return Parser.builder().build();
    }

    @Bean
    public HtmlRenderer htmlRenderer() {
        return HtmlRenderer.builder().build();
    }
}
