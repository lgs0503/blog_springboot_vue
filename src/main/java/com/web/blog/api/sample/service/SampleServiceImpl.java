package com.web.blog.api.sample.service;

import com.web.blog.api.sample.mapper.SampleMapper;
import com.web.blog.api.sample.vo.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleServiceImpl implements SampleService{

    private SampleMapper sampleMapper;

    @Autowired
    public SampleServiceImpl(SampleMapper sampleMapper) {
        this.sampleMapper = sampleMapper;
    }

    @Override
    public List<Sample> getSampleList() {
        return sampleMapper.getSampleList();
    }

    @Override
    public int insertSample(Sample sample) {
        return sampleMapper.insertSample(sample);
    }

    @Override
    public int updateSample(Sample sample) {
        return sampleMapper.updateSample(sample);
    }

    @Override
    public int deleteSample(List<String> deleteList) {
        return sampleMapper.deleteSample(deleteList);
    }
}
