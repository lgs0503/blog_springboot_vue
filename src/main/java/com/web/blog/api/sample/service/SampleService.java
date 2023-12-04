package com.web.blog.api.sample.service;

import com.web.blog.api.sample.vo.Sample;

import java.util.List;

public interface SampleService {

    List<Sample> getSampleList();

    int insertSample(Sample sample);

    int updateSample(Sample sample);

    int deleteSample(List<String> deleteList);
}
