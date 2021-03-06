package com.example.sbs.lolHi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sbs.lolHi.dto.Article;
import com.example.sbs.lolHi.dto.Board;

@Mapper
public interface ArticleDao {


	List<Article> getForPrintArticlesById(Map<String, Object> param);
	
	Article getForPrintArticleById(@Param("id") int id);

	void doDeleteArticleById(@Param("id") int id);

	void doWrite(Map<String, Object> param);

	void doModify(Map<String, Object> param);

	int getTotalCount(Map<String, Object> param);

	Board getBoard(@Param("boardCode") String boardCode);

	void increseArticleHit(@Param("id") int id);

}
