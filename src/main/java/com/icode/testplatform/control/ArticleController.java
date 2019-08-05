package com.icode.testplatform.control;

import com.icode.testplatform.dto.ArticleRequestDTO;
import com.icode.testplatform.dto.ArticleResponseDTO;
import com.icode.testplatform.dto.BasicResponseDTO;
import com.icode.testplatform.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value="/editor",method = RequestMethod.GET)
    public String indexPost(){
        return "article/editor";
    }
    @RequestMapping(value="/luntan",method = RequestMethod.GET)
    public String luntan(HttpServletRequest request, HttpServletResponse response){
        if(request.getSession().getAttribute("userId")!=null ){
            return "article/luntan";
        }else{
            return "home/index";
        }

    }
    @RequestMapping("/getArticleList")
    @ResponseBody
    public ArticleResponseDTO getArticleList(@RequestBody String mainid){
        Long mainId=Long.parseLong(mainid);

        ArticleResponseDTO responseDTO= articleService.getArticleListByMainid(mainId);
        return responseDTO;
    }
    @RequestMapping("/sendArticle")
    @ResponseBody
    public BasicResponseDTO sendArticle(@RequestBody ArticleRequestDTO request){
        BasicResponseDTO responseDTO=  articleService.sendArticle(request);

        return responseDTO;


    }
    @RequestMapping("/deleteById")
    @ResponseBody
    public BasicResponseDTO sendArticle(@RequestBody String id){

        BasicResponseDTO responseDTO=  articleService.deleteById(Long.parseLong(id));

        return responseDTO;


    }
    @RequestMapping(value="/ueditor",method = RequestMethod.GET)
    public String ueditor(HttpServletRequest request, HttpServletResponse response){
        String ue="ok";
        return ue;

    }


}
