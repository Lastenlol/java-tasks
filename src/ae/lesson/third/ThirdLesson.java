package ae.lesson.third;

import ae.common.Lesson;
import ae.lesson.first.calculator.Calculator;
import ae.lesson.third.educenter.Student;
import ae.util.ConsoleHelpers;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ThirdLesson extends Lesson {

    public void run() {
        task1(false);
        task1(true);
    }

    protected static void task1(boolean inDetails) {

        // create all stuff here

        List<Student> students = new ArrayList<>();

        Date currentDate = new Date();
        if (!inDetails) {
            students.forEach(student -> {
                final Date finishDate = student.curriculum.getFinishDate();
                final boolean finished = finishDate.after(currentDate);

                System.out.print(student.name + " (" + student.curriculum.title + ") – ");
                System.out.print("Обучение " + (finished ? "не " : "") + "закончено.");

                final long duration = Math.abs(currentDate.getTime() - finishDate.getTime());

                if (!finished) {
                    System.out.print("До окончания осталось ");
                } else {
                    System.out.print("После окончания прошло ");
                }

                TimeUnit ms = TimeUnit.MILLISECONDS;
                System.out.print(ms.toDays(duration) + "д " + ms.toHours(duration));
            });
        } else {
            // in details here
        }

    }

}
