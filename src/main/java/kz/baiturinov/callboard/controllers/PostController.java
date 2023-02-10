package kz.baiturinov.callboard.controllers;

import kz.baiturinov.callboard.models.Posts;
import kz.baiturinov.callboard.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/index")
    public String indexPage(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "index";
    }

    @GetMapping("/formAddPost")
    public String addPostForm(@ModelAttribute("posts") Posts posts) {
        return "/formAddPost";
    }

    @PostMapping("/formAddPost")
    public String addPost(@ModelAttribute("posts") Posts posts) {
        postService.save(posts);
        return "redirect:/index";
    }
}
