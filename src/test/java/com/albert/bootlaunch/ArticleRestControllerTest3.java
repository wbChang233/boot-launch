package com.albert.bootlaunch;

import com.albert.bootlaunch.model.ArticleVO;
import com.albert.bootlaunch.service.ArticleMybatisRestServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//@Transactional
@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest
public class ArticleRestControllerTest3 {

    //mock对象
    @Resource
    private MockMvc mockMvc;

    @MockBean
    ArticleMybatisRestServiceImpl articleRestService;

    //mock对象初始化
    /*@Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
    }*/

    //测试方法
    @Test
    public void saveArticle() throws Exception {



        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"zimug\",\n" +
                "    \"title\": \"手摸手教你开发spring boot\",\n" +
                "    \"content\": \"c\",\n" +
                "    \"createTime\": \"2017-07-16 05:23:34\",\n" +
                "    \"reader\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        ArticleVO articleObj = objectMapper.readValue(article, ArticleVO.class);
        articleRestService.saveArticle(articleObj);

        //打桩
//        when((articleRestService.saveArticle(articleObj)).then);
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/article")
                .contentType("application/json").content(article))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                .andDo(print())
                .andReturn();

        log.info(result.getResponse().getContentAsString());

    }
}
