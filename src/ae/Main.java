package ae;

import ae.common.Lesson;
import ae.lesson.first.FirstLesson;
import ae.lesson.second.SecondLesson;
import ae.lesson.third.ThirdLesson;

public class Main {

    public static void main(String[] args) {
        final Lesson firstLesson = new FirstLesson();
        final Lesson secondLesson = new SecondLesson();
        final Lesson thirdLesson = new ThirdLesson();

        firstLesson.run();
        secondLesson.run();
        thirdLesson.run();
    }

}
