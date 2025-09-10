package org.delivery.demo1.controller;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.delivery.demo1.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@ToString
@Log4j2
@RequestMapping("/sample")
public class HelloController {
    private final HelloService helloService;

    @GetMapping("/ex1")
    public void ex1() {
        log.info("/sample/ex1");
        helloService.hello1();

    }

    @GetMapping("/ex2")
    public String ex2() {
        log.info("/sample/ex2");
        helloService.hello2("HongGil Dong");
        return "sample/success";
    }

    @GetMapping("/ex3")
    public String ex3() {
        log.info("/sample/ex/ex3");
        return "redirect:/sample/ex3re";
    }

    @GetMapping("/ex3re")
    public String ex3Re() {
        log.info("/sample/ex3Re");
        return "sample/ex3Result";
    }
}
