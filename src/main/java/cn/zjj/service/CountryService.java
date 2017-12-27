package cn.zjj.service;

import cn.zjj.entity.Country;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface CountryService {

    List<Country> getAllCountries(Map<String, Object> params);

    PageInfo getCountriesByPage(Map<String, Object> params);
}
