package com.example.demo.arguments;

import com.example.demo.domain.Employee;
import com.example.demo.observer.Weather;
import com.example.demo.observer.WeatherObserver;
import com.example.demo.observer.WeatherType;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArgumentCaptorTest {

    // dependencia (mock)
    @Mock
    WeatherObserver observer;

    // SUT - System Under Test
    @InjectMocks
    Weather weather;

    @Test
    void changeWeatherTest() {

        weather.addObserver(observer); // observer es un mock

        // sut - comportamiento a testear
        weather.changeWeather(WeatherType.RAINY);

        // lo que probamos es que al observer le llega como argumento WeatherType.RAINY
        ArgumentCaptor<WeatherType> argument = ArgumentCaptor.forClass(WeatherType.class);
        verify(observer).update(argument.capture());
        assertEquals(WeatherType.RAINY, argument.getValue());


    }
}
