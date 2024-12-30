package test;

import com.example.demo.controller.UserController;
import com.example.demo.controller.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Mukesh Verma
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = {UserController.class, UserService.class})

public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

     @Mock
    private UserService userService;
    @Test
    void getUser_shouldReturnUserData_whenUserIdIsValid() throws Exception {
        // Arrange
        String userId = "123";
        String expectedResponse = "123";
        given(userService.getData(any())).willReturn(expectedResponse);
        mockMvc.perform(get("/api/v1/user/{userId}",userId))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }


}
