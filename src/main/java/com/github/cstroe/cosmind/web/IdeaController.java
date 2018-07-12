package com.github.cstroe.cosmind.web;

import com.github.cstroe.cosmind.dao.IdeaEntity;
import com.github.cstroe.cosmind.repo.IdeaRepository;
import com.github.cstroe.cosmind.web.idea.IdeaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static java.lang.String.format;

@Controller
@RequestMapping(IdeaController.PATH)
public class IdeaController {
    public static final String PATH = "/idea";

    private final IdeaRepository ideaRepository;

    @Autowired
    public IdeaController(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    @GetMapping
    public String ideas(Model model) {
        var ideas = ideaRepository.findAll();
        model.addAttribute("ideas", ideas);
        model.addAttribute("ideaForm", new IdeaForm());
        return "ideas";
    }

    @GetMapping("/{id}")
    public String idea(@PathVariable("id") Long id, Model model) {
        var entityOpt = ideaRepository.findById(id);
        if(entityOpt.isPresent()) {
            model.addAttribute("idea", entityOpt.get());
            return "idea";
        } else {
            return "notfound";
        }
    }

    @PostMapping
    public String newStory(IdeaForm form) {
        var newIdea = new IdeaEntity();
        newIdea.setDescription(form.getDescription());
        var savedStory = ideaRepository.save(newIdea);
        return format("redirect:%s/%d", IdeaController.PATH, savedStory.getId());
    }
}
