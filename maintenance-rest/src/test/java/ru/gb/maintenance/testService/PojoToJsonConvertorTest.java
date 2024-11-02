package ru.gb.maintenance.testService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@Service
public class PojoToJsonConvertorTest<T> {

        @Autowired
        private ObjectMapper objectMapper;

        public String PojoToJson(T t) {
            try {
                return objectMapper.writeValueAsString(t);
            } catch (JsonProcessingException e) {
                System.out.println("Failed conversion converting an object to Json");
            }
            return "";
        }

    public String PojoListToJson(List<T> list) {
        try {
            return objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            System.out.println("failed conversion: Pojo object to Json");
        }
        return "";
    }
}
