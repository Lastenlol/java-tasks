package ae.lesson.third.educenter;

public class Course {

    final String title;
    final int duration;

    public Course(String title, int duration) {
        this.title = title;
        this.duration = Math.max(duration, 0);
    }

}
