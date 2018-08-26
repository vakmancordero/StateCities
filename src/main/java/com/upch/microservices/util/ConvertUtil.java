package com.upch.microservices.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

@Component
public class ConvertUtil {

    private final ModelMapper modelMapper;

    @Autowired
    public ConvertUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T, K> List<T> convert(Iterable<K> rawData, Class<T> convertToClass) {
        List<T> convertedData = new ArrayList<>();

        if (rawData == null)
            return convertedData;

        for (K raw : rawData) {
            T convertedElement = modelMapper.map(raw, convertToClass);
            convertedData.add(convertedElement);
        }
        return convertedData;
    }

    public <T, K> T convert(K rawData, Class<T> convertToClass) {
        if (rawData == null)
            return null;

        return modelMapper.map(rawData, convertToClass);
    }

}