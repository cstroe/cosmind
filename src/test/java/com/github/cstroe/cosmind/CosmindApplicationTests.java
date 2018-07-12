package com.github.cstroe.cosmind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CosmindApplicationTests {

    @Autowired
    private WebTestClient webClient;

//    @Test
    public void contextLoads() {
        this.webClient.get().uri("/").exchange().expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello World");
    }

}
