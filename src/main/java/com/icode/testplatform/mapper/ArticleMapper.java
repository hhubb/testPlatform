package com.icode.testplatform.mapper;

import com.icode.testplatform.dto.ArticleDTO;
import com.icode.testplatform.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    public List<ArticleDTO> getArticleListByMainid(@Param("mainid") Long mainid);

    public int insert(@Param("article") Article article);

    public int deleteById(@Param("id") long id);
}
