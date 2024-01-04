package kr.co.galaxy.app.pilates.application.dto;

import jakarta.validation.constraints.NotEmpty;
import kr.co.galaxy.app.pilates.domain.Counsel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CounselRequest {

    @NotEmpty
    private int customerId;

    @NotEmpty
    private int instructorId;

    @NotEmpty
    private String counselType;

    @NotEmpty
    private String counselContents;

    public Counsel toCounsel(){
        return new Counsel(this.customerId, this.instructorId, this.counselType, this.counselContents);
    }

}
