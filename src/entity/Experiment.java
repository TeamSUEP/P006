package entity;

public class Experiment {
    private int id;
    private String stuId;
    private String courseId;
    private String classno;
    private String exp_name;
    private String demand;
    private String content;
    private String location;
    private boolean upload;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public String getExp_name() {
        return exp_name;
    }

    public void setExp_name(String exp_name) {
        this.exp_name = exp_name;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isUpload() {
        return upload;
    }

    public void setUpload(boolean upload) {
        this.upload = upload;
    }
}
