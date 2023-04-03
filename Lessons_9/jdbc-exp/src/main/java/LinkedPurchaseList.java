import jakarta.persistence.*;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private Key id;

    @JoinColumn(name = "student_id", updatable = false, insertable = false)
    private String student;

    @JoinColumn(name = "course_id", updatable = false, insertable = false)
    private String course;

    public LinkedPurchaseList() {

    }

    public LinkedPurchaseList(Key id, String student, String course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
