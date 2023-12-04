package com.web.blog.sample;

import com.web.blog.TestMvcConfig;
import com.web.blog.api.sample.vo.Sample;
import org.junit.jupiter.api.*;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SampleTest extends TestMvcConfig {

    @DisplayName("샘플 리스트 조회")
    @Test
    @Order(4)
    public void getSampleList() throws Exception {

        mockMvc.perform(get("/api/sample"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"col1\":\"2\",\"col2\":\"한글\"}]"))
                .andDo(print());
    }

    @DisplayName("샘플 추가")
    @Test
    @Order(1)
    public void insertSample() throws Exception {

        Sample sample = new Sample();
        sample.setCol1("test1");
        sample.setCol2("test2");

        String content = objectMapper.writeValueAsString(sample);

        mockMvc.perform(post("/api/sample")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());
    }


    @DisplayName("샘플 수정")
    @Test
    @Order(2)
    public void updateSample() throws Exception {

        Sample sample = new Sample();
        sample.setCol1("test1");
        sample.setCol2("update 데이터");

        String content = objectMapper.writeValueAsString(sample);

        mockMvc.perform(put("/api/sample")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());
    }


    @DisplayName("샘플 삭제")
    @Test
    @Order(3)
    public void deleteSample() throws Exception {

        List<String> deleteItem = new ArrayList<String>();
        deleteItem.add("test1");

        String content = objectMapper.writeValueAsString(deleteItem);

        mockMvc.perform(delete("/api/sample")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());
    }
}
