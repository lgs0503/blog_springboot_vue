package com.web.blog.api.sample.controller;

import com.web.blog.api.sample.service.SampleService;
import com.web.blog.api.sample.vo.Sample;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Tag(name="SampleController")
@RequestMapping("/api/sample")
public class SampleController {

    SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService){
        this.sampleService = sampleService;
    }

    @Operation(summary = "getSampleData", description = "getSampleData")
    @GetMapping
    public ResponseEntity getSampleData() {
        return new ResponseEntity<>(sampleService.getSampleList(), HttpStatus.OK);
    }

    @Operation(summary = "insertSample", description = "insertSample")
    @PostMapping
    public ResponseEntity insertSample(@RequestBody Sample sample) {
        return new ResponseEntity<>(sampleService.insertSample(sample), HttpStatus.OK);
    }

    @Operation(summary = "updateSample", description = "updateSample")
    @PutMapping
    public ResponseEntity updateSample(@RequestBody Sample sample) {
        return new ResponseEntity<>(sampleService.updateSample(sample), HttpStatus.OK);
    }

    @Operation(summary = "deleteSample", description = "deleteSample")
    @DeleteMapping
    public ResponseEntity deleteSample(@RequestBody List<String> deleteList) {
        return new ResponseEntity<>(sampleService.deleteSample(deleteList), HttpStatus.OK);
    }
}
