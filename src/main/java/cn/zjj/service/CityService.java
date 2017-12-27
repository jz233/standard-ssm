package cn.zjj.service;

import cn.zjj.entity.City;

import java.util.List;

public interface CityService {

    List<City> getCitiesByCountryCode(String countryCode);


}
