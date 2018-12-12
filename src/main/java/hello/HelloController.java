package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;


@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping(path = "/ping", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> pingSubmit(@RequestBody Ping ping) {
        String mycontent = ping.getContent();
        if (!mycontent.equals("ping")){
            return new ResponseEntity<String>("{\"sorry\": \"" + mycontent + "\"}",
                HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("{\"ping\": \"pong\"}", HttpStatus.OK);

    }
}
