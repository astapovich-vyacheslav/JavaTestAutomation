package com.solvd.it.requirements;

import java.util.Date;

public class StateInfo {
    private boolean ready;
    private Date start;
    private Date finish;

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public StateInfo(Date start) {
        this.ready = false;
        this.start = start;
    }

    public boolean FinishTask(Date finish) {
        try {
            this.finish = finish;
            this.ready = true;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
