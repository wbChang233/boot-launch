package com.albert.bootlaunch.Controller;

import com.albert.bootlaunch.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public ArticleVO hello(String name) {
        ArticleVO article1 = ArticleVO.builder().id(2L).author("金斯").build();
        log.info("测试一下"+ article1);
        return article1;
    }
}