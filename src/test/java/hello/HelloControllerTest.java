package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    public void postPingOk() throws Exception {
        String json="{\"content\": \"ping\"}";
        String response_json="{\"ping\": \"pong\"}";
        mvc.perform(MockMvcRequestBuilders.post("/ping").contentType(MediaType.APPLICATION_JSON)
            .content(json)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo(response_json)));
    }

    @Test
    public void postPingFail() throws Exception {
        String json="{\"content\": \"pring\"}";
        String response_json="{\"sorry\": \"pring\"}";
        mvc.perform(MockMvcRequestBuilders.post("/ping").contentType(MediaType.APPLICATION_JSON)
            .content(json)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().is(400))
            .andExpect(content().string(equalTo(response_json)));
    }

}
