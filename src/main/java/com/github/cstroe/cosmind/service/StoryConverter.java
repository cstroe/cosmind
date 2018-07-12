package com.github.cstroe.cosmind.service;

import com.github.cstroe.cosmind.dao.StoryEntity;
import com.github.cstroe.cosmind.vdo.StoryVdo;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryConverter {
    private Parser commonmarkParser;
    private HtmlRenderer htmlRenderer;

    @Autowired
    public StoryConverter(Parser commonmarkParser, HtmlRenderer htmlRenderer) {
        this.commonmarkParser = commonmarkParser;
        this.htmlRenderer = htmlRenderer;
    }

    public StoryVdo ideaToView(StoryEntity entity) {
        var vdo = new StoryVdo();
        vdo.setSummary(entity.getSummary());
        var node = commonmarkParser.parse(entity.getDescription());
        vdo.setDescription(htmlRenderer.render(node));
        return vdo;
    }
}
