package kr.co.galaxy.app.pilates.application.dto;

import kr.co.galaxy.app.pilates.domain.Counsel;

public class CounselResponse {

    private int id;
    private int customerId;
    private int instructorId;

    private String counselType;
    private String counselContents;

    public CounselResponse(int id, int customerId, int instructorId, String counselType, String counselContents) {
        this.id = id;
        this.customerId = customerId;
        this.instructorId = instructorId;
        this.counselType = counselType;
        this.counselContents = counselContents;
    }

    public static CounselResponse of(Counsel counsel) {
        return new CounselResponse(counsel.getId(), counsel.getCustomerId(), counsel.getInstructorId(), counsel.getCounselType(), counsel.getCounselContents());
    }
}
