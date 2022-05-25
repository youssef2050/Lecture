package com.company.controller;

import com.company.modle.Appointments;
import com.company.modle.Day;
import com.company.modle.Lecture;

import java.util.ArrayList;
import java.util.List;

public class LectureController {
    private List<Lecture> lectures;

    public LectureController() {
        lectures = new ArrayList<Lecture>();
    }

    public boolean isEmpty() {
        return lectures.isEmpty();
    }

    public boolean addLecture(Lecture lecture) {
        return lectures.add(lecture);
    }

    public boolean removeLecture(int id) {
        for (int i = 0; i < lectures.size(); i++) {
            if (lectures.get(i).getLectureId() == id) {
                return lectures.remove(lectures.get(i));
            }

        }
        return false;
    }

    public String displayLecture(int id) {
        for (Lecture lecture : lectures) {
            if (lecture.getLectureId() == id)
                return lecture.toString();
        }
        return "رقم المدرس غير موجود!";
    }

    public boolean checkId(int id) {
        if (lectures.isEmpty()) {
            return true;
        }
        for (Lecture lecture : lectures) {
            if (lecture.getLectureId() != id)
                return true;
        }
        return false;
    }

    public boolean checkName(String name) {
        if (lectures.isEmpty()) {
            return false;
        }
        for (Lecture lecture : lectures) {
            if (lecture.getLectureName() == name)
                return true;
        }
        return false;
    }

    public Lecture getLecture(int id) {
        for (Lecture lecture : lectures) {
            if (lecture.getLectureId() == id)
                return lecture;
        }
        return null;
    }

    public boolean isAvailable(String date, String time) {
        for (Lecture lecture : lectures) {
            if (lecture.getAppointments().size() > 0)
                for (Appointments appointment : lecture.getAppointments()) {
                    if (appointment.getDate().equals(date)) {
                        for (Day day : appointment.getDays()) {
                            if ((day.getStartTime() + "-" + day.getEndTime()).equals(time) && day.isAvailable()) {
                                return true;
                            } else
                                return false;
                        }
                    }
                }
        }
        return true;
    }

    public Day[] getDays(String date) {
        for (Lecture lecture : lectures) {
            if (lecture.getAppointments().size() > 0)
                for (Appointments appointment : lecture.getAppointments()) {
                    if (appointment.getDate().equals(date))
                        return appointment.getDays();
                }
        }
        return new Day[]{new Day(1, "8:00", "9:00", true),
                new Day(2, "9:00", "10:00", true),
                new Day(3, "10:00", "11:00", true),
                new Day(4, "11:00", "12:00", true)};
    }
}
