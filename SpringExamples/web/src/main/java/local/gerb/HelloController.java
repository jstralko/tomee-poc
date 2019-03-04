package local.gerb;

import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/controller")
public class HelloController {

    @EJB
    private HelloWorld helloWorld;

    @RequestMapping(method = RequestMethod.GET)
    public String doHome() {
        return "hello";
    }
}
