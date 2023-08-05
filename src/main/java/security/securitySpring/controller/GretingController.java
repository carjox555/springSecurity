package security.securitySpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")


public class GretingController {

    @GetMapping("hi")
    public String hellou(){
        return "Hellou CJX";
    }
}
