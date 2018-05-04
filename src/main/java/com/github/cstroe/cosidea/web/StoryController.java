package com.github.cstroe.cosidea.web;

import com.github.cstroe.cosidea.dao.StoryEntity;
import com.github.cstroe.cosidea.repo.StoryRepository;
import com.github.cstroe.cosidea.web.idea.StoryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(StoryController.PATH)
public class StoryController {
    public static final String PATH = "/story";

    @Autowired
    private StoryRepository storyRepository;

    @GetMapping
    public String stories(Model model) {
        var ideas = storyRepository.findAll();
        model.addAttribute("stories", ideas);
        model.addAttribute("storyForm", new StoryForm());
        return "stories";
    }

    @PostMapping
    public String newStory(StoryForm form) {
        var idea = new StoryEntity();
        idea.setSummary(form.getSummary());
        idea.setDescription(form.getDescription());
        storyRepository.save(idea);
        return "redirect:" + StoryController.PATH;
    }
}