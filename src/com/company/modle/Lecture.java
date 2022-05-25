package com.company.modle;

import java.util.ArrayList;
import java.util.List;

public class Lecture {

    private String date;
    private int lectureId;
    private String lectureName;
    private String department;
    private List<Appointments> appointments;

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }

    public Lecture(int lectureId, String lectureName, String department) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.department = department;
        appointments = new ArrayList<Appointments>();
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "بيانات المدرس {" +
                "رقم المدرس =" + lectureId +
                ", اسم المدرس='" + lectureName + '\'' +
                ", قسم المدرس='" + department + '\'' +
                '}';
    }

    public boolean addAppointments(Appointments appointment) {
        return appointments.add(appointment);

    }

    public boolean removeAppointments(int id) {
        for (Appointments appointment : appointments) {
            if (appointment.getId() == id)
                return appointments.remove(appointment);
        }
        return false;
    }

    public String showAppointments() {
        String result = "الترتيب  \t تاريخ/الوقت \t حالة";
        for (Appointments appointment : appointments) {
            result += "\n" + appointment.toString();
        }
        return result;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean postponementAppointments(int id, String date) {
        for (Appointments appointment : appointments) {
            if (appointment.getId() == id) {
                appointment.setDate(date);
                return true;
            }
        }
        return false;
    }
}
