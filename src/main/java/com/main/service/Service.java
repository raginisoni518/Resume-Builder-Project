package com.main.service;

import java.lang.reflect.Field;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;


import com.main.entity.SignUser;

import com.main.repository.UserRepository;



@org.springframework.stereotype.Service
public class Service {
	@Autowired
	UserRepository userRepository;
	
	
	private Object convertValue(Object value, Class<?> targetType) {
	    if (value == null) {
	        return null;
	    }

	    if (targetType.isAssignableFrom(value.getClass())) {
	        return value;
	    }

	    if (targetType == Integer.class || targetType == int.class) {
	        return Integer.parseInt(value.toString());
	    } else if (targetType == Long.class || targetType == long.class) {
	        return Long.parseLong(value.toString());
	    } else if (targetType == Double.class || targetType == double.class) {
	        return Double.parseDouble(value.toString());
	    } else if (targetType == Boolean.class || targetType == boolean.class) {
	        return Boolean.parseBoolean(value.toString());
	    } else if (targetType == String.class) {
	        return value.toString();
	    }

	    throw new IllegalArgumentException("Unsupported target type: " + targetType.getName());
	}
    public SignUser update(String email,Map<String,Object>fields) {
    	SignUser existingUser = userRepository.findById(email).get();
    	fields.forEach((key,value)->{
    		Field field=ReflectionUtils.findField(SignUser.class, key);
    		field.setAccessible(true);
    		 Object convertedValue = convertValue(value, field.getType());
    		ReflectionUtils.setField(field, existingUser, convertedValue);
    	});
    	return existingUser;
    }}
	