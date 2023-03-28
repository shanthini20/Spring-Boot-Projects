package com.team.Dto;

import java.util.List;

public class DeleteRequest {
    private List<Long> memIds;

    public List<Long> getMemIds() {
        return memIds;
    }

    public void setMemIds(List<Long> memIds) {
        this.memIds = memIds;
    }
}
