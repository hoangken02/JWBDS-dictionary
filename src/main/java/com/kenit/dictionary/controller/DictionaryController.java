package com.kenit.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    @GetMapping("/dictionary")
    public String index(){
        return "index";
    }

    @GetMapping("/dictionary/search")
    public String search(@RequestParam("word") String word, Model model){
         Map<String, String> dic = new HashMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");

        String result = dic.get(word);
        if (result != null) {
            System.out.println("Word: " + word);
            System.out.println("Vietnamese: " + result);
            model.addAttribute("word",word);
            model.addAttribute("result",result);
        } else {
            System.out.println("Not Found");
            return "redirect:/dictionary";
        }
        return "result";
    }
}
