package com.sukuawali.sukuawalibackend;

import com.sukuawali.sukuawalibackend.controller.SukuaController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class SukuawaliBackendApplicationTests {


    @Autowired
    SukuaController sukuaController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(sukuaController).isNotNull();
    }
}

