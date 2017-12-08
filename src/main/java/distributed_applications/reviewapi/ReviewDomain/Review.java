/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributed_applications.reviewapi.ReviewDomain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author redro
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "zipCode",
    "userName",
    "score",
    "comment"
})
public class Review {
    
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("score")
    private double score;
    @JsonProperty("comment")
    private String comment;

    public Review() {
    }

    public Review(String zipCode, String userName, double score, String comment) {
        this.zipCode = zipCode;
        this.userName = userName;
        this.score = score;
        this.comment = comment;
    }

    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("score")
    public double getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(double score) {
        this.score = score;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.userName != null ? this.userName.hashCode() : 0);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.score) ^ (Double.doubleToLongBits(this.score) >>> 32));
        hash = 31 * hash + (this.comment != null ? this.comment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Review other = (Review) obj;
        if (Double.doubleToLongBits(this.score) != Double.doubleToLongBits(other.score)) {
            return false;
        }
        if ((this.userName == null) ? (other.userName != null) : !this.userName.equals(other.userName)) {
            return false;
        }
        if ((this.comment == null) ? (other.comment != null) : !this.comment.equals(other.comment)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Review{" + "userName=" + userName + ", score=" + score + ", comment=" + comment + '}';
    }
    
    
    
}
