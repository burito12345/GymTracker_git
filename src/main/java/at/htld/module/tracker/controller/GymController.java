package at.htld.module.tracker.controller;

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
    public String getIndexPage() {
        return "gyms/index";
    }



}
