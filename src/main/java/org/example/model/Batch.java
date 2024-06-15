package org.example.model;


public class Batch {
    private int bid;
    private String title;
    private String startTime;

    public Batch() {
    }

    public Batch(int bid, String startTime, String title) {
        this.bid = bid;
        this.startTime = startTime;
        this.title = title;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }



    @Override
    public String toString() {
        return "Batch{" +
                "bid=" + bid +
                ", title='" + title + '\'' +
                ", startDate=" + startTime +
                '}';
    }
}
