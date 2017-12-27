package cn.zjj.controller;

import cn.zjj.service.CountryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/countries")
public class CountryController {


    @Autowired
    private CountryService countryService;


    @RequestMapping("/")
    public String countries() {
        return "redirect:page-1";
    }



    @RequestMapping("/page-{pageNum}")
    public ModelAndView countriesByPage(HttpServletRequest request, @PathVariable("pageNum") Integer pageNum) {
        Map<String, Object> params = new HashMap<>();
        if (pageNum == null || pageNum <1) {
            params.put("page", 1);
        } else {
            params.put("page", pageNum);
        }
        PageInfo pageInfo = countryService.getCountriesByPage(params);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("country");

        modelAndView.addObject("countries", pageInfo.getList());
        modelAndView.addObject("pageInfo", pageInfo);

        return modelAndView;
    }
}
