package com.github.cstroe.cosidea;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CosideaApplicationTests {

    @Autowired
    private WebTestClient webClient;

//    @Test
    public void contextLoads() {
        this.webClient.get().uri("/").exchange().expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello World");
    }

}
