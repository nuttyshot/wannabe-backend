package wannabe.backend.web.main.weeklybestperformancelook;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;
import wannabe.backend.config.security.SecurityConfig;
import wannabe.backend.product.usecase.FindAllProductUseCase;

@WebMvcTest(MainWeeklyBestPerformanceLookController.class)
@Import(SecurityConfig.class)
@MockBean(JpaMetamodelMappingContext.class)
class MainWeeklyBestPerformanceLookControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private FindAllProductUseCase useCase;

  @Test
  void 정상동작() throws Exception {
    // given
    // when
    mockMvc.perform(get("/main/weekly-best-performance-look"))
        .andExpect(status().isOk());
    // then
    verify(useCase, only()).execute();
  }
}