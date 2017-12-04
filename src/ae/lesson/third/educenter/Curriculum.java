package ae.lesson.third.educenter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Curriculum {

    public final String title;
    public final Date startDate;

    public Schedule schedule = new Schedule();
    public List<Course> courses = new ArrayList<>();

    public Curriculum(String title, Date startDate) {
        this.title = title;
        this.startDate = startDate;
    }

    public Curriculum(String title, Date startDate, Collection<Course> courses) {
        this(title, startDate);
        this.courses = new ArrayList<>(courses);
    }

    public Curriculum(String title, Date startDate, Collection<Course> courses, Schedule schedule) {
        this(title, startDate, courses);
        this.schedule = schedule;
    }

    public int getDurationInHours() {
        return courses
                .stream()
                .reduce(0, (sum, course) -> sum += course.duration, (sum1, sum2) -> sum1 + sum2);
    }

    public Date getFinishDate() {
        final int requiredDays = schedule.getRequiredDaysForHours(getDurationInHours());
        return Date.from(startDate.toInstant().plus(Duration.ofDays(requiredDays)));
    }

}
