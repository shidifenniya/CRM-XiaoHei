package com.lanou.action;

import com.lanou.domain.Post;
import com.lanou.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends ActionSupport implements ModelDriven<Post> {

    @Autowired
    @Qualifier("postService")
    private PostService postService;

    private Post post;

    private List<Post> posts;

    public String findAllPost(){

        posts = postService.findAllPost();

        return SUCCESS;

    }

    @Override
    public Post getModel() {

        post = new Post();

        return post;

    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
