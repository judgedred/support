package com.omertex.support.service;


import com.omertex.support.dao.AttributeOfInquiryDao;
import com.omertex.support.dao.DaoException;
import com.omertex.support.domain.AttributeOfInquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AttributeOfInquiryServiceImpl implements AttributeOfInquiryService
{
    @Autowired
    private AttributeOfInquiryDao attributeOfInquiryDao;

    @Override
    public AttributeOfInquiry create(AttributeOfInquiry attribute) throws DaoException
    {
        return attributeOfInquiryDao.create(attribute);
    }

    @Override
    public void update(AttributeOfInquiry attribute) throws DaoException
    {
        attributeOfInquiryDao.update(attribute);
    }

    @Override
    public void delete(AttributeOfInquiry attribute) throws DaoException
    {
        attributeOfInquiryDao.delete(attribute);
    }

    @Override
    public List<AttributeOfInquiry> getAttributeAll() throws DaoException
    {
        return attributeOfInquiryDao.getAttributeAll();
    }

    @Override
    public AttributeOfInquiry getAttributeById(int id) throws DaoException
    {
        return attributeOfInquiryDao.getAttributeById(id);
    }

    @Override
    public Map<String, String> getAttributeOfInquiryById(int inquiryId) throws DaoException
    {
        List<AttributeOfInquiry> attributeList = attributeOfInquiryDao.getAttributeAll();
        Map<String, String> attributeMap = new HashMap<>();
        if(attributeList != null)
        {
            for(AttributeOfInquiry a : attributeList)
            {
                if(a.getInquiry().getInquiryId().equals(inquiryId))
                {
                    attributeMap.put(a.getAttributeName(), a.getAttributeValue());
                }
            }
            return attributeMap;
        }
        else
        {
            return null;
        }
    }
}