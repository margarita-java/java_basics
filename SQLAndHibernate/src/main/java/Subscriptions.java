import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscriptions {
    @EmbeddedId
    private SubscriptionKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Students student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Courses course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;


    public SubscriptionKey getId() {
        return id;
    }

    public void setId(SubscriptionKey id) {
        this.id = id;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}