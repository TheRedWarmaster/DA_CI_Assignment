/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributed_applications.reviewapi.ReviewDatabase;

import distributed_applications.reviewapi.ReviewDomain.Review;
import java.util.List;

/**
 *
 * @author redro
 */
public interface ReviewDatabaseInterface {
    
    List<Review> getReviewsByZipCode(String zipCode);
    void saveReview(Review r);
    
}
