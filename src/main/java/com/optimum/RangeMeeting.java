package com.optimum;

import java.util.*;

public class RangeMeeting
{
    static class Meeting {
        int start;
        int end;
        int difference;
        int originalIndex;

        Meeting(int start, int end, int originalIndex) {
            this.start = start;
            this.end = end;
            this.difference = end - start;
            this.originalIndex = originalIndex;
        }
    }
    public static void main(String[] args)
    {
        //int[] startTimes = {1, 3, 0, 5, 8, 5};
        //int[] endTimes = {2, 4, 6, 7, 9, 9};
        int[] startTimes = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
        int[] endTimes = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};
        ArrayList<Meeting>[] times = new ArrayList[startTimes.length];


       int[] result = findMaxMeetings(startTimes, endTimes);
        for (int i = 1; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        result = findMeetings(startTimes, endTimes);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public static int[] findMaxMeetings(int[] startTimes, int[] endTimes)
    {
        if (startTimes == null || endTimes == null || startTimes.length != endTimes.length || startTimes.length == 0) {
            return new int[0];
        }

        int n = startTimes.length;
        int[][] meetings = new int[n][3]; // [start, finish, originalMeetingNumber]

        for (int i = 0; i < n; i++) {
            meetings[i][0] = startTimes[i];
            meetings[i][1] = endTimes[i];
            meetings[i][2] = i + 1; // 1-based meeting number
        }

        Arrays.sort(meetings, Comparator.comparingInt((int[] m) -> m[1]).thenComparingInt(m -> m[2]));

        List<Integer> picked = new ArrayList<>();
        int lastFinish = Integer.MIN_VALUE;

        for (int[] meeting : meetings) {
            if (meeting[0] > lastFinish) { // strict as in your examples
                picked.add(meeting[2]);
                lastFinish = meeting[1];
            }
        }

        int[] result = new int[picked.size()];
        for (int i = 0; i < picked.size(); i++) {
            result[i] = picked.get(i);
        }
        return result;
    }

    public static Meeting findNextMeeting(TreeMap<Integer, Meeting> meetings, int startTime) {
        Map.Entry<Integer, Meeting> entry = meetings.higherEntry(startTime);
        return entry != null ? entry.getValue() : null;
    }
    public static int[] findMeetings(int[] startTimes, int[] endTimes) {
        if (startTimes == null || endTimes == null || startTimes.length != endTimes.length || startTimes.length == 0) {
            return new int[0];
        }

        int n = startTimes.length;
        TreeMap<Integer, Meeting> meetings = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            meetings.put(startTimes[i], new Meeting(startTimes[i], endTimes[i], i + 1));
        }

        int[] keys = meetings.keySet().stream()
                .mapToInt(Integer::intValue)
                .toArray();

        ArrayList<Meeting>[] times = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            ArrayList<Meeting> meetingsRange = new ArrayList<>();
            Meeting meeting = findNextMeeting(meetings, keys[i]);
            int jlastFinish = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                int lastFinish = Integer.MIN_VALUE;

                if (meetings.get(keys[j]).start > jlastFinish) {
                    for (int k = j; k < n; k++) {
                        if (meetings.get(keys[k]).start > lastFinish) {
                            meetingsRange.add(meetings.get(keys[k]));
                            lastFinish = meetings.get(keys[k]).end;
                        }

                    }
                }
                jlastFinish = meetings.get(keys[i]).end;
            }
            times[i] = meetingsRange;
        }
        int maxMeetings = 0;
        int maxMeetingsIndex = 0;
        for (int k = 0; k < times.length; k++) {
            if (times[k] != null && times[k].size() > maxMeetings) {
                maxMeetings = times[k].size();
                maxMeetingsIndex = k;
            }
        }
        int[] result = new int[maxMeetings];
        for (int i = 0; i < times[maxMeetingsIndex].size(); i++) {
            Meeting meeting = times[maxMeetingsIndex].get(i);
            result[i] = meeting.originalIndex;
            System.out.println("Start: " + meeting.start + ", End: " + meeting.end + ", Original Meeting Number: " + meeting.originalIndex);
        }
        return result;
    }

}