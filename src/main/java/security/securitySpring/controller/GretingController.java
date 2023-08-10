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


    @GetMapping("hiProtected")
    public String hellouProtec(){
        return "Hellou CJX PROTECTED";
    }
}
