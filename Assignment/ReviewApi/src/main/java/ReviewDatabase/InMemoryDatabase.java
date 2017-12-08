/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReviewDatabase;

import ReviewDomain.Review;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author redro
 */
public class InMemoryDatabase implements ReviewDatabaseInterface{

    private List<Review> database;

    public InMemoryDatabase() {
        this.database = new ArrayList<Review>();
        this.fill();
    }

    public List<Review> getDatabase() {
        return database;
    }

    public void setDatabase(List<Review> database) {
        this.database = database;
    }
    
    private void fill(){
        Review rev1 = new Review("3000", "Red", 9.0, "Great place to be");
        Review rev2 = new Review("3000", "Blue", 5.0, "Test Comment");
        Review rev3 = new Review("1000", "Green", 1.0, "Test Comment");
        this.database.add(rev1);
        this.database.add(rev2);
        this.database.add(rev3);
    }
    
    @Override
    public List<Review> getReviewsByZipCode(String zipCode) {
        List<Review> result = new ArrayList<>();
        for(Review r : getDatabase()){
            if(r.getZipCode().equals(zipCode)){
                result.add(r);
            }
        }
        return result;
    }

    @Override
    public void saveReview(Review r) {
        this.database.add(r);
    }
    
}
