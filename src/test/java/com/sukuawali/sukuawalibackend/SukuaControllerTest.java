package com.sukuawali.sukuawalibackend;

import com.sukuawali.sukuawalibackend.models.Sukua;
import com.sukuawali.sukuawalibackend.services.SukuaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("test")
@SpringBootTest()
public class SukuaControllerTest {

    @Autowired
    SukuaService sukuaService;

    @Test
    public void addNewSukuaTest() throws Exception {
        Sukua sukua = new Sukua(1L, "Test Sukua", "best sukua", 99, "http:/image.com", 1);
        Optional<Sukua> savedSukua = sukuaService.addNewSukua(sukua);
        assertThat(savedSukua).get().isNotNull();
    }

}
