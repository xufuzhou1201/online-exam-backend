package edu.sandau.service.impl;

import edu.sandau.dao.SysEnumDao;
import edu.sandau.entity.SysEnum;
import edu.sandau.rest.model.Page;
import edu.sandau.service.SysEnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class SysEnumServiceImpl implements SysEnumService {
    @Autowired
    private SysEnumDao enumDao;

    @Override
    public SysEnum addEnum(SysEnum sysEnum) {
        return enumDao.save(sysEnum);
    }

//    @Override
//    public List<Map<String, Object>> getEnumMap(String catalog, String type) {
//        return enumDao.getEnumMap(catalog, type);
//    }

    @Override
    public List<SysEnum> getEnums(String catalog, String type) {
        return enumDao.getEnums(catalog, type);
    }

    @Override
    public SysEnum getEnum(String catalog, String type, Integer value) {
        return enumDao.getEnum(catalog, type, value);
    }

    @Override
    public Integer getEnumValue(String catalog, String type, String name) {
        return enumDao.getEnumValue(catalog, type, name);
    }

    @Override
    public String getEnumName(String catalog, String type, Integer value) {
        return enumDao.getEnumName(catalog, type, value);
    }

    @Override
    public SysEnum changeEnum(SysEnum sysEnum) {
        enumDao.updateEnum(sysEnum);
        return enumDao.getEnumById(sysEnum.getId());
    }

    @Override
    public Integer deleteEnum(SysEnum sysEnum) {
        return enumDao.deleteEnum(sysEnum);
    }

    @Override
    public Integer deleteEnumById(Integer id) {
        return enumDao.deleteEnumById(id);
    }

    @Override
    public Page getEnumsByPage(Page page) {
        List<SysEnum> enums = enumDao.listEnumByPage(page);
        int count = enumDao.getCount();
        page.setTotal(count);
        page.setRows(enums);
        return page;
    }

    @Override
    public List<SysEnum> getAllEnums() {
        return enumDao.listAllEnum();
    }
}
