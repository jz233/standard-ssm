package cn.zjj.service.impl;

import cn.zjj.dao.CountryMapper;
import cn.zjj.entity.Country;
import cn.zjj.service.BaseService;
import cn.zjj.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class CountryServiceImpl extends BaseService implements CountryService{

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<Country> getAllCountries(Map<String, Object> params) {
        if (params == null) {
            params = new HashMap<>();
        }
        params.put("pageSize", 15);
        params.put("pageNum", 2);


        PageHelper.startPage(params);
        List<Country> countries = countryMapper.getAllCountries();
        PageInfo<Country> pageInfo = new PageInfo<>(countries);
        params.put("totalRows", pageInfo.getTotal());
        params.put("curPage", pageInfo.getPageNum());
        params.put("success", true);
        params.put("data", pageInfo.getList());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(params);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return countries;
    }

    @Override
    public PageInfo getCountriesByPage(Map<String, Object> params) {
        params.put("pageSize", 15);
        params.put("pageNum", params.get("page"));

        PageHelper.startPage(params);
        List<Country> countries = countryMapper.getAllCountries();
        PageInfo<Country> pageInfo = new PageInfo<>(countries);

        return pageInfo;
    }

}
