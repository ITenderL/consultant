package com.itender.consultant.controller;

import com.itender.consultant.aiservice.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


/**
 * @author analytics
 * @date 2025/11/10 21:09
 * @description
 */
@RestController
@RequestMapping("")
public class ChatController {
    @Autowired
    private ConsultantService consultantService;

    @GetMapping(value = "/chat", produces = "text/html;charset=UTF-8")
    public Flux<String> chat(String memoryId, String message) {
        return consultantService.chat(memoryId, message);
    }

    // @GetMapping("/chat")
    // public String chat(String message) {
    //     return consultantService.chat(message);
    // }

    // @Autowired
    // private OpenAiChatModel openAiChatModel;
    //
    // @GetMapping("/chat")
    // public String chat(String message) {
    //     return openAiChatModel.chat(message);
    // }
}
