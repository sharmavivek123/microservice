package com.example.moviecatalogservice.resource;


import com.example.moviecatalogservice.model.CataLogItem;
import com.example.moviecatalogservice.model.Movie;
import com.example.moviecatalogservice.model.Rating;
import com.example.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webclientBuilders;



    @RequestMapping("/{userId}")
    public List<CataLogItem> getCatalog(@PathVariable("userId")  String userId){
        System.out.println("path variable userId is " + userId);


        UserRating forObject1 = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId,
                UserRating.class);
        System.out.println(forObject1);

        //rest template------
        Movie forObject = restTemplate.getForObject("http://localhost:8082/movies/"+ userId, Movie.class);
        System.out.println();

        //web client

       /* Movie block = webclientBuilders.build()
                .get()
                .uri("http://localhost:8082/movies/3")
                .retrieve()
                .bodyToMono(Movie.class) // Mono means like asynchronous call response

                .block();   // blocking execution   we wait here
        System.out.println(block);
*/

        return Collections.singletonList(
                new CataLogItem("Transformer","Test",4)
        );

    }

}
