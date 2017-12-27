package cn.zjj.controller;

import cn.zjj.entity.City;
import cn.zjj.service.CityService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/country-{countryCode}")
    public JSONArray getCitiesByCountryCode(@PathVariable("countryCode") String countryCode) throws IOException {

        List<City> cities = cityService.getCitiesByCountryCode(countryCode);
        return JSONArray.parseArray(JSON.toJSONString(cities));
    }
}
