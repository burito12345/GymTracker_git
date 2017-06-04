package at.htld.module.tracker.controller;

/**
 * Created by Ermin Kameric on 30.05.2017.
 */

import at.htld.module.tracker.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController{

    @Autowired
    private UserRepository repository;

    @Autowired
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getIndexPage() {
        return "admin/admin";
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String listUser(Model model) {
        model.addAttribute("users", repository.findAll());
        return "admin/list";
    }

}
