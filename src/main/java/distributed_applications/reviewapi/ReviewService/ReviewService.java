/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributed_applications.reviewapi.ReviewService;

import distributed_applications.reviewapi.ReviewDatabase.ReviewDatabaseInterface;
import distributed_applications.reviewapi.ReviewDomain.Review;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author redro
 */
@RestController
@RequestMapping(value = "/api")
public class ReviewService {
    
    @Autowired
    private ReviewDatabaseInterface database;

    public ReviewService() {}

    public ReviewDatabaseInterface getDatabase() {
        return database;
    }

    public void setDatabase(ReviewDatabaseInterface database) {
        this.database = database;
    }
    
    @RequestMapping(value = "/reviews/{zipCode}", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getReviewsByZipCode(@PathVariable("zipCode") String zipCode){
        HashMap<String, Object> responseBody = new HashMap<>();
        List<Review> reviews = this.database.getReviewsByZipCode(zipCode);
        responseBody.put("reviews", reviews);
        return new ResponseEntity<Map<String, Object>>(responseBody, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/reviews/save", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<Boolean> postReview(@RequestBody Review r){
        this.database.saveReview(r);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
    
}
