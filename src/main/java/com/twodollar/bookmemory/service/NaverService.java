package com.twodollar.bookmemory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class NaverService {
    @Autowired
    WebClient webClient;
    private static String BASE_URL = "https://openapi.naver.com/v1";
    public String getBookList(String keyword, int start){
        String response = webClient.get()
                .uri(BASE_URL+"/search/book",
                        uriBuilder -> uriBuilder
                    .queryParam("query", String.format("'%s'", keyword))
                    .queryParam("display", 10)
                    .queryParam("start", start)
                    .build()
                )
                .header("X-Naver-Client-Id", "Yv1DbrzFI800a0IvEQbc")
                .header("X-Naver-Client-Secret", "M1Y4wRa5OV")
                .retrieve()
                .bodyToMono(String.class).block();
        log.info("response : {}", response);
        return response;
    }
}
