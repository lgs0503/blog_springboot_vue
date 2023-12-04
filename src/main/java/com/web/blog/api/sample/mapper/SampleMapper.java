package com.web.blog.api.sample.mapper;

import com.web.blog.api.sample.vo.Sample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {

    List<Sample> getSampleList();

    int insertSample(Sample sample);

    int updateSample(Sample sample);

    int deleteSample(List<String> deleteList);
}
