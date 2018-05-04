package com.github.cstroe.cosidea.web;

import com.github.cstroe.cosidea.dao.StoryEntity;
import com.github.cstroe.cosidea.repo.StoryRepository;
import com.github.cstroe.cosidea.web.idea.StoryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static java.lang.String.format;

@Controller
@RequestMapping(StoryController.PATH)
public class StoryController {
    public static final String PATH = "/story";

    private StoryRepository storyRepository;

    @Autowired
    public StoryController(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @GetMapping
    public String stories(Model model) {
        var ideas = storyRepository.findAll();
        model.addAttribute("stories", ideas);
        model.addAttribute("storyForm", new StoryForm());
        return "stories";
    }

    @GetMapping("/{id}")
    public String story(@PathVariable("id") Long id, Model model) {
        var entityOpt = storyRepository.findById(id);
        if(entityOpt.isPresent()) {
            model.addAttribute("story", entityOpt.get());
        }
        return "story";
    }

    @PostMapping
    public String newStory(StoryForm form) {
        var newStory = new StoryEntity();
        newStory.setSummary(form.getSummary());
        newStory.setDescription(form.getDescription());
        var savedStory = storyRepository.save(newStory);
        return format("redirect:%s/%d", StoryController.PATH, savedStory.getId());
    }
}
