package com.albert.bootlaunch.service;

import com.albert.bootlaunch.model.AjaxResponse;
import com.albert.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
public class ArticleRestService {
    public String saveArticle(@RequestBody Article article) {
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle：{}",article);
        return  "Test";
    }
}
