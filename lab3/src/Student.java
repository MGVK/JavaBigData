import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student {

//    id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа

    private static final SimpleDateFormat s = new SimpleDateFormat("d MMM yyyy", new Locale("ru"));

    private Long   id;
    private String firstname;
    private String secondname;
    private String thirdname;
    private Date   date;
    private String address;
    private String phone;
    private String department;
    private String course;
    private String group;

    public Student(Long id, String firstname, String secondname, String thirdname, String date, String address,
                   String phone, String department, String course, String group) {


        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.thirdname = thirdname;
        try {
            this.date = s.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.address = address;
        this.phone = phone;
        this.department = department;
        this.course = course;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
               "id=" + id +
               ", firstname='" + firstname + '\'' +
               ", secondname='" + secondname + '\'' +
               ", thirdname='" + thirdname + '\'' +
               ", date=" + date +
               ", address='" + address + '\'' +
               ", phone='" + phone + '\'' +
               ", department='" + department + '\'' +
               ", course='" + course + '\'' +
               ", group='" + group + '\'' +
               '}';
    }
}
