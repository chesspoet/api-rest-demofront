package org.api.demo.Controller;

import org.api.demo.Model.Task;
import org.api.demo.Repository.TodoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class TodoControllerTest {
    @Mock
    private TodoRepository todoRepositoryMock;

    @InjectMocks
    private TodoController todoController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void holaMundo() {
    }

    @Test
    void getTask() throws Exception {
        // Configurar el escenario de prueba
        // Arrange
        List<Task> expectedTasks = new ArrayList<>();
        expectedTasks.add(new Task(1L, "Tarea 1", "Descripción de tarea 1"));
        expectedTasks.add(new Task(2L, "Tarea 2", "Descripción de tarea 2"));
        Mockito.when(todoRepositoryMock.findAll()).thenReturn(expectedTasks);

        // Act
        List<Task> actualTasks = todoController.getTask();

        // Assert
        Assert.assertEquals(expectedTasks, actualTasks);

    }

    @Test
    void saveTask() {
    }

    @Test
    void updateTask() {
    }

    @Test
    void deleteTask() {
    }
}