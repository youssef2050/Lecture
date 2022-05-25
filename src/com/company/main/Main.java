package com.company.main;

import com.company.controller.LectureController;
import com.company.modle.Appointments;
import com.company.modle.Day;
import com.company.modle.Lecture;
import com.company.modle.Status;

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
        System.out.print("ادخل رقم المحاضر :");
        int numberId = scanner.nextInt();
        Lecture lecture = lectureController.getLecture(numberId);
        if (lecture == null) {
            System.out.println("لا يوجد محاضر بهذا الرقم، هل تريد المحاولة مرة أخرى (نعم / لا)؟");
            String answer = scanner.next();
            if (answer.equals("نعم")) {
                listAppointments();
            } else {
                run();
            }
        } else {
            System.out.println("المواعيد الحالية للمحاضر:");
            System.out.println(lecture.showAppointments());
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
                case 2:
                    removeAppointment(lecture);
                    break;
                case 3:
                    postponementAppointment(lecture);
                    break;
                case 4:
                    caseChangeAppointment(lecture);
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
    }

    private void caseChangeAppointment(Lecture lecture) {
        System.out.println("رقم المحاضر: " + lecture.getLectureId() + " اسم المحاضر: " + lecture.getLectureName());
        System.out.println("المواعيد الحالية للمحاضر:");
        System.out.println(lecture.showAppointments());
        System.out.println("ادخل رقم الموعد :");
        int numberId = scanner.nextInt();
        Appointments appointments = lecture.getAppointments(numberId);
        System.out.println("اختر حالة [ 1 .ملغاة، 2 .اكتمل]");
        int caseNumber = scanner.nextInt();
        if (caseNumber == 2) {
            appointments.setCompleted(Status.مكتمل);
            System.out.println("تم تغيير حالة المو عد من معلق الى مكتمل ");
        } else {
            appointments.setCompleted(Status.ملغاة);
            System.out.println("تم تغيير حالة المو عد من معلق الى ملغي ");
        }
        listAppointments();
    }

    private void postponementAppointment(Lecture lecture) {
        System.out.println("رقم المحاضر: " + lecture.getLectureId() + " اسم المحاضر: " + lecture.getLectureName());
        System.out.println("المواعيد الحالية للمحاضر:");
        System.out.println(lecture.showAppointments());
        System.out.println("أدخل موعد حسب الترتيب او التاريخ :");
        String date = scanner.next();
        Appointments postponement;
        if (date.length() < 2) {
            postponement = lecture.getAppointments(Integer.parseInt(date));
        } else
            postponement = lecture.getAppointments(date);

        if (postponement == null) {
            System.out.println("المدخل خطأ اعد من جديد");
            removeAppointment(lecture);
        } else {
            System.out.print("أدخل تاريخ اليوم الجديد:");
            String dateNew = scanner.next();
            System.out.println("الفترات الزمنية لذلك اليوم: ");
            Appointments appointments = new Appointments(dateNew);
            Day[] days = lectureController.getDays(dateNew);
            appointments.setDays(days);
            for (Day day : days) {
                System.out.println(day.toString());
            }
            System.out.println("ادخل رقم الموعد :");
            int numberTime = scanner.nextInt();
            if (appointments.getDays()[numberTime - 1].isAvailable()) {
                appointments.getDays()[numberTime - 1].setAvailable(false);
                lecture.postponementAppointments(postponement.getId(), dateNew);
                System.out.println("تم الموعد تأجيل " + postponement.getDate());
            } else {
                System.out.println("اختر موعد متاح ان وجد");
            }
        }
        System.out.println("المواعيد الحالية للمحاضر:");
        System.out.println(lecture.showAppointments());
        listAppointments();
    }

    private void removeAppointment(Lecture lecture) {
        System.out.println("رقم المحاضر: " + lecture.getLectureId() + " اسم المحاضر: " + lecture.getLectureName());
        System.out.println("المواعيد الحالية للمحاضر:");
        System.out.println(lecture.showAppointments());
        System.out.println("أدخل موعد حسب الترتيب او التاريخ :");
        String date = scanner.next();
        Appointments removed;
        if (date.length() < 2) {
            removed = lecture.getAppointments(Integer.parseInt(date));
        } else
            removed = lecture.getAppointments(date);

        if (removed == null) {
            System.out.println("المدخل خطأ اعد من جديد");
            removeAppointment(lecture);
        } else {
            System.out.println("سيتم حذف الموعد " + removed.getDate() + "(نعم / لا ) ؟ ");
            String answer = scanner.next();
            if (answer.equals("نعم")) {
                lecture.getAppointments().remove(removed);
                System.out.println("تم حذف الموعد");

            }
        }
        System.out.println("المواعيد الحالية للمحاضر:");
        System.out.println(lecture.showAppointments());
        listAppointments();
    }

    private void addAppointment(Lecture lecture) {
        System.out.print("دخل تاريخ اليوم الذي تريد إضافة موعد به: ");
        String date = scanner.next();
        System.out.println("الفترات الزمنية لذلك اليوم: ");
        Appointments appointments = new Appointments(date);
        Day[] days = lectureController.getDays(date);
        appointments.setDays(days);
        for (Day day : days) {
            System.out.println(day.toString());
        }
        System.out.println("ادخل رقم الموعد :");
        int numberTime = scanner.nextInt();
        if (appointments.getDays()[numberTime - 1].isAvailable()) {
            appointments.getDays()[numberTime - 1].setAvailable(false);
            lecture.addAppointments(appointments);
            System.out.println("تم الاضافة بنجاح");
        } else {
            System.out.println("اختر موعد متاح ان وجد");
        }
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
