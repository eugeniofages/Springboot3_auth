package authspring.authspringboot3.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {


        @PostMapping(value ="demo")
        public String welcome() {
            return "Welcome from secure endpoint";
        }
        

}
