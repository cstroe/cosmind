package com.github.cstroe.cosmind.web;

import com.github.cstroe.cosmind.repo.IdeaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(IdeaController.class)
@WithMockUser
public class IdeaControllerIT {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private IdeaRepository ideaRepository;

    @Test
    public void test() throws Exception {
        given(ideaRepository.findAll()).willReturn(new ArrayList<>());
        this.mvc.perform(get("/idea"))
                .andExpect(status().isOk());
    }
}