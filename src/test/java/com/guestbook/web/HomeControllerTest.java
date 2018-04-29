package com.guestbook.web;

import com.guestbook.data.CommentRepository;
import com.guestbook.model.Comment;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by hello on 22/04/2018.
 */
public class HomeControllerTest {

    @Test
    public void homeTest() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

    @Test
    public void shouldReturnComments() throws Exception {
        CommentRepository commentRepository = mock(CommentRepository.class);
        List<Comment> comments = createComments();
        when(commentRepository.findComments(Long.MAX_VALUE, 20)).thenReturn(comments);

        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/index.jsp")).build();

        mockMvc.perform(get("/index"))
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(comments.toArray())));
    }

    private List<Comment> createComments() {
        int i;
        List<Comment> comments = new ArrayList<Comment>();
        for(i = 1; i <= 20; i++) {
            Comment comment = new Comment();
            comment.setText("Comment " + i);
            comments.add(comment);
        }

        return comments;
    }
}
