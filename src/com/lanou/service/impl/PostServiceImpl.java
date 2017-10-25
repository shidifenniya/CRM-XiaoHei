package com.lanou.service.impl;

import com.lanou.dao.PostDao;
import com.lanou.domain.Post;
import com.lanou.service.PostService;

import java.util.List;


/**
 * Created by dllo on 17/10/25.
 */
public class PostServiceImpl implements PostService {

    private PostDao postDao;

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<Post> findAllPost() {

        String hql = "from Post";

        return postDao.findAll(hql);

    }
}
