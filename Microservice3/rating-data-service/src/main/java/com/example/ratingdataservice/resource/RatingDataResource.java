package com.example.ratingdataservice.resource;

import com.example.ratingdataservice.model.Rating;
import com.example.ratingdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }



    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {

    List<Rating> rst= Arrays.asList(
      new Rating("1",4),
      new Rating("3",5)
    );
    UserRating userRating=new UserRating(rst);
    return userRating;
    }


}