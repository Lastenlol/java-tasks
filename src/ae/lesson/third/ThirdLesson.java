package ae.lesson.third;

import ae.common.Lesson;
import ae.lesson.first.calculator.Calculator;
import ae.lesson.third.educenter.Course;
import ae.lesson.third.educenter.Curriculum;
import ae.lesson.third.educenter.Schedule;
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
        List<Student> students = new ArrayList<>();
        students.add(
                new Student(
                        "Ivanov Ivan",
                        new Curriculum(
                                "J2EE Developer",
                                new Date(),
                                Arrays.asList(
                                        new Course("Технология Java Servlets", 16),
                                        new Course("Struts Framework", 24)
                                ),
                                new Schedule()
                        )
                )
        );
        students.add(
                new Student(
                        "Petrov Petr",
                        new Curriculum(
                                "Java Developer ",
                                new Date(),
                                Arrays.asList(
                                        new Course("Обзор технологий Java", 8),
                                        new Course("Библиотека JFC/Swing", 16),
                                        new Course("Технология JDBC", 16)
                                ),
                                new Schedule()
                        )
                )
        );

        Date currentDate = new Date();
        students.forEach(student -> {
            final Date finishDate = student.curriculum.getFinishDate();
            final boolean finished = finishDate.before(currentDate);

            System.out.print(student.name + " (" + student.curriculum.title + ")");

            if (inDetails) {
                System.out.println("Начало обучения: " + student.curriculum.startDate.toString());
                System.out.println("Конец обучения: " + student.curriculum.getFinishDate().toString());
                System.out.println("Длительность программы: " + student.curriculum.getDurationInHours());
            }

            System.out.print("Обучение " + (!finished ? "не " : "") + "закончено.");

            if (!finished) System.out.print("До окончания осталось ");
            else System.out.print("После окончания прошло ");

            final long duration = Math.abs(currentDate.getTime() - finishDate.getTime());
            final TimeUnit ms = TimeUnit.MILLISECONDS;
            final long days = ms.toDays(duration);

            System.out.print((days > 0 ? days + " д. " : "") + ms.toHours(duration) + " ч.");
        });

    }

}
