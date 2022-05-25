package com.company.controller;

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
}
