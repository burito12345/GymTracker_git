package at.htld.module.tracker.controller;

/**
 * Created by Ermin Kameric on 30.05.2017.
 */

import at.htld.module.tracker.entity.User;
import at.htld.module.tracker.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository repository;

    @Autowired
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getIndexPage() {
        return "admin/admin";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listUser(Model model) {
        model.addAttribute("users", repository.findAll());
        return "admin/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUser() {
        return "admin/new";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        repository.delete(id);
        return new ModelAndView("redirect:/admin/list");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id,
                       Model model) {
        User user = repository.findOne(id);
        model.addAttribute("user", user);
        return "admin/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("post_id") long id,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("age") int age,
                               @RequestParam("height") int height) {
        User user = repository.findOne(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setHeight(height);
        repository.save(user);
        return new ModelAndView("redirect:/admin/list");
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("age") int age,
                               @RequestParam("height") int height) {
        repository.save(new User(firstName,lastName,age,height));
        return new ModelAndView("redirect:/admin/list");
    }

}
