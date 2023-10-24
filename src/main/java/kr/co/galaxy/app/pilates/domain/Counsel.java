package kr.co.galaxy.app.pilates.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Counsel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int customerId;
    private int instructorId;
    private String counselType;
    private String counselContents;

    public Counsel(int customerId, int instructorId, String counselType, String counselContents) {
        this.customerId = customerId;
        this.instructorId = instructorId;
        this.counselType = counselType;
        this.counselContents = counselContents;
    }

    protected Counsel(){

    }
}
