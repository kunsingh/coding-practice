package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobotRoomCleaner {

    public void cleanRoom(Robot robot) {

    }

    public static void main(String[] args) {
//        int[] nums = new int[];
//        List<Integer> list = new ArrayList(Arrays.asList(nums));
    }
}

interface Robot{
    boolean move();
    void turnLeft();
    void turnRight();
    void clean();
}
