package com.twodollar.bookmemory.controller.api;

import com.twodollar.bookmemory.service.NaverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/naver")
@Slf4j
public class NaverAPIController {

    @Autowired
    NaverService naverService;

    @RequestMapping(value = "/search/book", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String,Object>>> getSimpleSearch(@RequestParam String keyword){
        List<Map<String,Object>> result = new ArrayList<>();
        Map<String,Object> hello = new HashMap<>();
        hello.put("test", "aaa");
        log.info("### BEFORE ");
        String a = naverService.getBookList("이어령", 1);
        hello.put("res", a);
        log.info("### AFTER ");

        result.add(hello);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
