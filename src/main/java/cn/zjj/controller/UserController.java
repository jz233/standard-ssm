package cn.zjj.controller;


import cn.zjj.entity.User;
import cn.zjj.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        User user = userService.getUser();
        System.out.println(user);

        return "user";
    }

    @RequestMapping("/login")
    public String loginUI() {
        return "login";
    }


    @RequestMapping(value = "/login_check", method = RequestMethod.POST)
    public ModelAndView login_check(@RequestParam String username, @RequestParam String password) {

        String pwd = userService.getPasswordByUsername(username);
        if (StringUtils.isNotEmpty(pwd)) {
            if (pwd.equals(password)) {
                Map<String, String> model = new HashMap<>();
//                ModelAndView mav = new ModelAndView("redirect:/countries");
                ModelAndView mav = new ModelAndView("redirect:/countries/");

                return mav;
            }
        }
        return new ModelAndView("login");
    }

}
