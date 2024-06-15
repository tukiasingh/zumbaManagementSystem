package org.example.model;

public class BatchAssignment {
    private int pid;
    private int bid;

    public BatchAssignment() {
    }

    public BatchAssignment(int pid, int bid) {
        this.pid = pid;
        this.bid = bid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "BatchAssignment{" +
                "pid=" + pid +
                ", bid=" + bid +
                '}';
    }
}
