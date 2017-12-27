package cn.zjj.dao;

import cn.zjj.entity.City;

import java.util.List;

public interface CityMapper {

    List<City> getCitiesByCountryCode(String countryCode);


}
