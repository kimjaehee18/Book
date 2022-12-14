//package com.book.controller;
//
//
//
//import com.book.dto.BookInfo;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import javax.servlet.http.HttpServletRequest;
//import java.net.URI;
//import java.nio.ByteBuffer;
//import java.nio.charset.StandardCharsets;
//import java.text.ParseException;
//import java.util.ArrayList;
//
//
//@RequiredArgsConstructor
//@Controller
//@Log4j2
//@RequestMapping("/book")
//public class Searchcontroller {
//
//    @GetMapping("/search")
//    public String Book() {
//        return "api/searchBook";
//    }
//    @PostMapping("/search")
//    public String searchBook(HttpServletRequest httpServletRequest, Model model) throws ParseException {
//
//        String query = httpServletRequest.getParameter("title");
//        log.info(query);
//
//        ByteBuffer buffer = StandardCharsets.UTF_8.encode(query);
//        String encode = StandardCharsets.UTF_8.decode(buffer).toString();
//
//        URI uri = UriComponentsBuilder
//                .fromUriString("https://openapi.naver.com")
//                .path("/v1/search/book.json")
//                .queryParam("query",encode)
//                .queryParam("display",10)
//                .encode()
//                .build()
//                .toUri();
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        RequestEntity<Void> req = RequestEntity
//                .get(uri)
//                .header("X-Naver-Client-Id", "zwvvcSwJFxCgtvbJTnvm")
//                .header("X-Naver-Client-Secret","qqkxIC0KAZ")
//                .build();
//
//        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
//        String r = result.getBody();
//
//        JSONObject value = new JSONObject(r);
//        log.info(value);
//
//        JSONArray items = value.getJSONArray("items");
//        log.info(items);
//
//        ArrayList<BookInfo> bookInfos = new ArrayList<>();
//
//
//        for(int i = 0; i<items.length(); i++) {
//            bookInfos.add(new BookInfo(i+1, (String) items.getJSONObject(i).get("title"), (String) items.getJSONObject(i).get("link"),(String) items.getJSONObject(i).get("image"),(String) items.getJSONObject(i).get("author")));
//        }
//        model.addAttribute("bookInfos", bookInfos);
//
//        return "api/searchBook";
//    }
//
//
//}
