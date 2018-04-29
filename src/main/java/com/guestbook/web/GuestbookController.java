package com.guestbook.web;

import com.guestbook.data.CommentRepository;
import com.guestbook.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by hello on 29/04/2018.
 */
@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

    private CommentRepository commentRepository;

    @Autowired
    public GuestbookController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Comment> comments = commentRepository.findComments(10, 10);
        model.addAttribute(comments);
        return "index";
    }
}
