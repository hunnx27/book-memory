package com.twodollar.bookmemory.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/naver")
public class NaverAPIController {

    @RequestMapping(value = "/search/book", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String,Object>>> getSimpleSearch(@RequestParam String keyword){
        List<Map<String,Object>> result = new ArrayList<>();
        Map<String,Object> hello = new HashMap<>();
        hello.put("test", "aaa");

        result.add(hello);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
