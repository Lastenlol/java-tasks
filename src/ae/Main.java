package ae;

import ae.common.Lesson;
import ae.lesson.first.FirstLesson;
import ae.lesson.second.SecondLesson;

public class Main {

    public static void main(String[] args) {
        final Lesson firstLesson = new FirstLesson();
        final Lesson secondLesson = new SecondLesson();

        firstLesson.run();
        secondLesson.run();
    }

}
