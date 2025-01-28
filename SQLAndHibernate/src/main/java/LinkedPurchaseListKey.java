import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


public class LinkedPurchaseListKey implements Serializable {

    @Id
    @Column(name = "student_id")
    private int studentId;

    @Id
    @Column(name = "course_id")
    private int courseId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedPurchaseListKey that = (LinkedPurchaseListKey) o;
        return studentId == that.studentId && courseId == that.courseId;
    }

    @Override public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
