package ru.gb.maintenance.testService;

import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.ParameterizedType;

@ActiveProfiles("test")
@Service
public class BaseUtil<T> {
    public T getInstanceOf(Class<T> tClass) {
        ParameterizedType superClass = (ParameterizedType) tClass.getGenericSuperclass();
        Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
