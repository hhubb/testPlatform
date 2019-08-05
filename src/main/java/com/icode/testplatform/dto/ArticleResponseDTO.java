package com.icode.testplatform.dto;

import java.util.List;

public class ArticleResponseDTO extends BasicResponseDTO {
    private List<ArticleDTO> articleList;

    public List<ArticleDTO> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleDTO> articleList) {
        this.articleList = articleList;
    }
}
