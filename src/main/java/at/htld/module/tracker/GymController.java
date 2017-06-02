package at.htld.module.tracker;

/**
 * Created by Ermin Kameric on 30.05.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/gyms")
public class GymController {

    @Autowired
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String listPosts() {
        return "gyms/index";
    }

    @RequestMapping(value = "/ficken", method = RequestMethod.GET)
    public String listficken() {
        return "gyms/index";
    }
}
