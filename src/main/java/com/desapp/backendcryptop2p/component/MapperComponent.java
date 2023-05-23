package com.desapp.backendcryptop2p.component;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;

@Component
public class MapperComponent {

    @Autowired
    private ModelMapper modelMapper;

    
    public <S, T> List<T> ToList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public <S, T> T To(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }

}
