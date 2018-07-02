package com.github.cstroe.cosidea.web;

import com.github.cstroe.cosidea.dao.IdeaEntity;
import com.github.cstroe.cosidea.repo.IdeaRepository;
import com.github.cstroe.cosidea.web.idea.IdeaForm;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.reset;

public class IdeaControllerUT {
    private IdeaRepository repo = mock(IdeaRepository.class);
    private Model model = mock(Model.class);
    private IdeaController controller = new IdeaController(repo);

    @Before
    public void setUp() {
        reset(repo, model);
    }

    @Test
    public void testIdeasList() {
        var list = new ArrayList<IdeaEntity>();

        when(repo.findAll()).thenReturn(list);

        var view = controller.ideas(model);

        assertEquals("ideas", view);
        verify(model).addAttribute("ideas", list);
        verify(model).addAttribute(eq("ideaForm"), any(IdeaForm.class));
    }

    @Test
    public void testIdeaById() {
        var idea = mock(IdeaEntity.class);

        when(repo.findById(eq(1L))).thenReturn(Optional.of(idea));

        var view = controller.idea(1L, model);

        assertEquals("idea", view);
        verify(model).addAttribute("idea", idea);
    }

    @Test
    public void testNotFound() {
        when(repo.findById(eq(1L))).thenReturn(Optional.empty());
        var view = controller.idea(1L, model);
        assertEquals("notfound", view);
    }
}