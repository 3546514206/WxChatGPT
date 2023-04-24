package edu.zjnu.chatGpt.controller;

import edu.zjnu.chatGpt.service.GptService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: 杨海波
 * @date: 2023-02-14 17:18:29
 * @description:
 */
@RestController
public class GptController {

    @Resource
    public GptService gptService;

    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public String chat(@RequestBody String request) {
        return gptService.doChat(request);
    }
}
