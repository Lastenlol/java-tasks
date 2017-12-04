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

                if (!finished) System.out.print("До окончания осталось ");
                else System.out.print("После окончания прошло ");

                final long duration = Math.abs(currentDate.getTime() - finishDate.getTime());
                final TimeUnit ms = TimeUnit.MILLISECONDS;
                final long days = ms.toDays(duration);

                System.out.print((days > 0 ? days + "д. " : "") + ms.toHours(duration) + "ч.");
            });
        } else {
            // in details here
        }

    }

}
