import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_name")
    private String courseName;
    private  int price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}
