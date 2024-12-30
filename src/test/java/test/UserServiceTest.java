package test;

import com.example.demo.controller.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Mukesh Verma
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserService userService;
    @Test
    void getData() {
        when(userService.getData("3")).thenReturn("3");
        String actual=userService.getData("3");
        Assertions.assertEquals("3",actual);
        verify(userService).getData(any());
        verify(userService,atLeast(1)).getData(any());

    }
}