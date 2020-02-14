package com.albert.bootlaunch.service;

import com.albert.bootlaunch.dao.ArticleJDBCDAO;
import com.albert.bootlaunch.model.AjaxResponse;
import com.albert.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleRestJdbcServiceImpl implements ArticleRestService{

    @Resource
    ArticleJDBCDAO articleJDBCDAO;

    public Article saveArticle(Article article) {
        articleJDBCDAO.save(article);

        return article;
    }


    @Override
    public void deleteArticle(Long id) {

        articleJDBCDAO.deleteById(id);

    }

    @Override
    public void updateArticle(Article article) {

        articleJDBCDAO.updateById(article);

    }

    @Override
    public Article getArticle(Long id) {
         return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll();
    }
}
