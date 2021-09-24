package al.gred.hellospring.controllers;

import al.gred.hellospring.services.TimeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;

@RestController
public class HelloSpringController {

    @GetMapping("/friendly-greeting")
    public String friendlGreeting() {
        return "Hello there, friend";
    }

    @GetMapping("/echo")
    public String parameter(@RequestParam String input) {
        return input;
    }

    @GetMapping("er-det-fredag")
    public String erDetFredag(String tz) { //Don't use @RequestParam since the parameter is optional
        if ( tz != null ) {
            if ( TimeUtils.isItFriday(ZoneId.of(tz)) ) {
                return "Det er fredag!";
            } else {
                return "Det er ikke fredag :/";
            }
        } else {
            return """
                     <body
                         onload="window.location.search='?tz='+Intl.DateTimeFormat().resolvedOptions().timeZone">
                     </body>
                    """;
        }
    }
}


