package com.web.blog.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.blog.annotation.TestParam;
import com.web.blog.api.sample.vo.Sample;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class TestResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(TestParam.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest httpServletRequest = (HttpServletRequest) webRequest.getNativeRequest();

        TestParam testParam = parameter.getParameterAnnotation(TestParam.class);
        String[] colNames = testParam.colName();

        //body에 있는 제이슨을 받은 객체
        String bodyJson = "";

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader br = null;
        //한줄씩 담을 변수
        String line = "";

        try {
            //body내용 inputstream에 담는다.
            InputStream inputStream = httpServletRequest.getInputStream();
            if (inputStream != null) {
                br = new BufferedReader(new InputStreamReader(inputStream));
                //더 읽을 라인이 없을때까지 계속
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }else {
                log.info("Data 없음");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        bodyJson = stringBuilder.toString();



        //condition 값을 object ㅇㅇ
        //object 를 map혹은 json 바꿀수잇어야하고 ㅇㅇ
        //map.get("") == db에조회 커럼이있는지 ㅇㅇ
        //column orderby 배열로 for문 요거
        //Sample sample.get("col1")
        Map<String, String> map = new ObjectMapper().readValue(bodyJson, Map.class);

        //map.get("orderby");
        log.info("resolve test");

        if(false) {
            throw new Exception("컬럼체크에러");
        } else {
            return new ObjectMapper().convertValue(map, parameter.getParameterType());
        }
    }
}
