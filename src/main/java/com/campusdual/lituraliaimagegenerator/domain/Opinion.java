package com.campusdual.lituraliaimagegenerator.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "opinions")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opinion_id")
    private Integer opinionId;

    //    @Column(name = "rating")
//    private int rating;
    @Column(name = "review")
    private String review;
//    @Column(name = "opinion_create", columnDefinition = "DATE")
//    private LocalDateTime opinionCreate;
//    @Column(name = "opinion_update", columnDefinition = "DATE")
//    private LocalDateTime opinionUpdate;
//
//    @Column(name = "book_id")
//    private int bookId;
//
//
//    @Column(name = "user_")
//    private String user_;


}
