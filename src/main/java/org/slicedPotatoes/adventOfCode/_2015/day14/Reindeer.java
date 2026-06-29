package org.slicedPotatoes.adventOfCode._2015.day14;

public class Reindeer {
    public final String name;
    public final int speed;
    public final int max_speed_time;
    public final int resting_time;

    private int current_distance;
    private boolean is_resting;
    private int timer;

    public Reindeer(String name, int speed, int max_speed_time, int resting_time) {
        this.name = name;
        this.speed = speed;
        this.max_speed_time = max_speed_time;
        this.resting_time = resting_time;

        this.current_distance = 0;
        this.is_resting = false;
        this.timer = max_speed_time;
    }

    public void turn() {
        timer -= 1;

        if(!is_resting) {
            current_distance += speed;
        }

        if(timer == 0) {
            is_resting = !is_resting;
            timer = is_resting ? resting_time : max_speed_time;
        }
    }

    public int getCurrent_distance() {
        return current_distance;
    }
}
