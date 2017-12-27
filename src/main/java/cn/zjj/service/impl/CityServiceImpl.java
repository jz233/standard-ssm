package cn.zjj.service.impl;

import cn.zjj.dao.CityMapper;
import cn.zjj.entity.City;
import cn.zjj.service.BaseService;
import cn.zjj.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class CityServiceImpl extends BaseService implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> getCitiesByCountryCode(String countryCode) {
        return cityMapper.getCitiesByCountryCode(countryCode);
    }

}
