package com.haoli.dao;

import org.apache.ibatis.annotations.Mapper;
import com.haoli.domain.Text;


@Mapper
public interface TextDao {
	public void addTranslateText(Text text);

	public Text loadTextById(Integer id);
}
