package com.icode.testplatform.service;

import com.icode.testplatform.dto.ArticleDTO;
import com.icode.testplatform.dto.ArticleRequestDTO;
import com.icode.testplatform.dto.ArticleResponseDTO;
import com.icode.testplatform.dto.BasicResponseDTO;
import com.icode.testplatform.entity.Article;
import com.icode.testplatform.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    public ArticleResponseDTO getArticleListByMainid(Long mainid){
        ArticleResponseDTO responseDTO =new ArticleResponseDTO();
        responseDTO.setSuccess(false);
        try{
          List<ArticleDTO> articles=  articleMapper.getArticleListByMainid(mainid);
            for(ArticleDTO articleDTO : articles){
                List<ArticleDTO> subArticleList=   articleMapper.getArticleListByMainid(articleDTO.getId());
                articleDTO.setSubArticleList(subArticleList);
            }

          responseDTO.setArticleList(articles);
            responseDTO.setSuccess(true);
        }catch (Exception ex){
            ex.getMessage();
            responseDTO.setSuccess(false);
            responseDTO.setMessage(ex.getMessage());
            return responseDTO;
        }
        return responseDTO;


    }
    public BasicResponseDTO deleteById(long id) {
        BasicResponseDTO responseDTO =new BasicResponseDTO();
        responseDTO.setSuccess(false);
        try{

           int flag= articleMapper.deleteById(id);
            if(flag>0){
                responseDTO.setSuccess(true);
            }else{
                responseDTO.setSuccess(false);
            }
        }catch (Exception ex){
            ex.getMessage();
            responseDTO.setSuccess(false);
            responseDTO.setMessage(ex.getMessage());
            return responseDTO;
        }
        return  responseDTO;


    }
    public BasicResponseDTO sendArticle(ArticleRequestDTO requestDTO){
        BasicResponseDTO responseDTO =new BasicResponseDTO();
        responseDTO.setSuccess(false);
        try{
            Article article =new Article();
            article.setContent(requestDTO.getContent());
            article.setMainid(requestDTO.getMainid());
            article.setTitle(requestDTO.getTitle());
            article.setUserid(requestDTO.getUserid());
            Calendar calendar=Calendar.getInstance();//取当前时间
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            article.setCreate_time(sdf.format(calendar.getTime()));
            int flag =articleMapper.insert(article);
            if(flag>0){
                responseDTO.setSuccess(true);
            }else{
                responseDTO.setSuccess(false);
            }
        }catch (Exception ex){
            ex.getMessage();
            responseDTO.setSuccess(false);
            responseDTO.setMessage(ex.getMessage());
            return responseDTO;
        }
        return  responseDTO;

    }
}
