package kr.co.galaxy.app.pilates.application.dto;

import kr.co.galaxy.app.pilates.domain.Counsel;

public class CounselRequest {
    private int customerId;
    private int instructorId;

    private String counselType;
    private String counselContents;

    public Counsel toCounsel(){
        return new Counsel(this.customerId, this.instructorId, this.counselType, this.counselContents);
    }

}
