package de.vw.f73.kitereisen.loader;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest /* (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) */
public class LoaderTest {

//    @Autowired
//    private TestRestTemplate restTemplate;

//    @Test
//    void getKitereise() {
//        String url = "https://www.kitereisen.tv/besten-kitespots-kitesurfen-ringkobing-fjord-daenemark/";
//        System.err.println("test");
////        this.restTemplate.get
//        System.err.println(this.restTemplate.getForObject(url, String.class));
//    }

    @Test
    void blubb() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.kitereisen.tv/besten-kitespots-kitesurfen-ringkobing-fjord-daenemark/";
        System.err.println("LoaderTest");
//         this.restTemplate.get
        System.err.println("restTemplate" + restTemplate.getForEntity(url, String.class));
        // System.err.println(this.restTemplate.getForObject(url, String.class));
    }

}
