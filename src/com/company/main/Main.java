package com.company.main;

import com.company.controller.LectureController;
import com.company.modle.Appointments;
import com.company.modle.Day;
import com.company.modle.Lecture;

import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private LectureController lectureController = new LectureController();

    public static void main(String[] args) {
        System.out.println("--------------------");
        System.out.println("|   Welcome Dear   |");
        System.out.println("|       !!!!       |");
        System.out.println("--------------------");

        new Main().run();
    }

    private void run() {
        System.out.println("***القائمة الرئيسية***\n" + "1. قائمة المحاضر" +
                ".\n" + "2. قائمة المواعيد \n" + "3. قائمة التقارير " +
                ".\n" + "4 .الخروج من النظام");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                listLecture();
                break;
            case 2:
                if (!lectureController.isEmpty())
                    listAppointments();
                else {
                    System.out.println("ادخل في قائمة المحاضرين");
                    run();
                }
                break;
            case 3:
                listReports();
                break;
            case 4:
                System.out.println("مع السلامة يا عزيزي");
                break;
            default:
                System.out.println("ادخل رقم من 1 الى 4 ");
                run();
                break;
        }
    }

    private void listReports() {
        System.out.println("3. قائمة التقارير \n" +
                "1. عرض جميع المواعيد ليوم محدد.\n" +
                "2. عرض موعد للمحاضر المحدد.\n" +
                "3 .عرض جميع القاعات\n" +
                "4 .العو دة إلى القائمة الرئيسية");

        int answer = scanner.nextInt();
        switch (answer) {

            case 1:

                break;

        }

    }


    private void listAppointments() {
        System.out.println("ادخل رقمك");
        int numberId = scanner.nextInt();
        Lecture lecture = lectureController.getLecture(numberId);
        System.out.println("المواعيد الحالية للمحاضر:");
        System.out.println(lecture.showAppointments(numberId));
        System.out.println("***قائمة التعديل***\n" +
                "ما الذي تريد تعديله؟ \n" +
                "1. إضافة موعد جديد.\n" +
                "2. حذف الموعد.\n" +
                "3. تأجيل الموعد.\n" +
                "4. تغيير حالة الموعد.\n" +
                "5.العودة إلى القائمة الرئيسية.");
        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                addAppointment(lecture);
                break;
            case 5:
                run();
                break;
            default:
                System.out.println(" أدخل رقم من 1 إلى 5 ");
                listAppointments();
                break;
        }
    }

    private void addAppointment(Lecture lecture) {
        System.out.print("دخل تاريخ اليوم الذي تريد إضافة موعد به: ");
        String date = scanner.next();
        System.out.println("الفترات الزمنية لذلك اليوم: ");
//        for (Day days : LectureController.DAYS) {
//            System.out.println(days.toString());
//        }
        int numberTime = scanner.nextInt();
        String time = "";
//        switch (numberTime) {
//            case 1:
//                time = LectureController.DAYS.get(0).getStartTime() + "-" + LectureController.DAYS.get(0).getEndTime();
//                break;
//            case 2:
//                time = LectureController.DAYS.get(1).getStartTime() + "-" + LectureController.DAYS.get(1).getEndTime();
//                break;
//            case 3:
//                time = LectureController.DAYS.get(2).getStartTime() + "-" + LectureController.DAYS.get(2).getEndTime();
//                break;
//            case 4:
//                time = LectureController.DAYS.get(3).getStartTime() + "-" + LectureController.DAYS.get(3).getEndTime();
//                break;

//        }
//        if (lectureController.isAvailable(date, time)) {
//            Appointments appointment = new Appointments(1, date, false);
//            appointment.addDay(new Day(1, time.split("-")[0], time.split("-")[1], false));
//            lecture.addAppointments(appointment);
//            System.out.println("تم الاضافة بنجاح");
//        } else {
//            System.out.println("اختر موعد متاح ان وجد");
//        }
        listAppointments();


    }


    private void listLecture() {
        System.out.println("***قائمة المدرس***\n" + "1. إضافة مدرس جديد " +
                ".\n" + "2. حذف المدرس.\n" + "3. عرض المدرس" +
                ".\n" + "4. العودة إلى القائمة الرئيسية");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                addLecture();
                break;
            case 2:
                removeLecture();
                break;
            case 3:
                showLecture();
                break;
            case 4:
                run();
                break;
            default:
                System.out.println("أدخل رقم يمعلم من 1 إلى 4");
                listLecture();
                break;
        }
    }

    private void showLecture() {
        int id = getId();
        System.out.println(lectureController.displayLecture(id));
        listLecture();
    }

    private void removeLecture() {
        int id = getId();
        if (lectureController.removeLecture(id))
            System.out.println("مع السلام تم حذف المدرس");
        else
            System.out.println("رقم المدرس غير موجود !");
        listLecture();


    }

    private void addLecture() {
        int id = getId();
        if (lectureController.checkId(id)) {
            System.out.println("ادخل اسمك");
            String name = scanner.next();
            System.out.println("ادخل القسم الخاص بك");
            String department = scanner.next();
            lectureController.addLecture(new Lecture(id, name, department));
            System.out.println("تم الاضافة بنجاح");
            listLecture();
        } else {
            System.out.println("رقم المدرس موجود هات غيره");
            addLecture();
        }
    }

    private int getId() {
        System.out.println("ادخل رقم المدرس");
        int id = scanner.nextInt();
        return id;
    }
}
