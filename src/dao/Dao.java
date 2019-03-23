package dao;
import dbutil.SQLHelper;
import entity.Course;
import entity.Student;
import entity.Experiment;
import entity.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Dao {
    public int updatePassword(String type, String newPassword, String id) {
        int r=0;
        String sql = "update "+type+" set password = HEX(AES_ENCRYPT('"+newPassword+"','key1234')) where id='"+id+"'";
        r=SQLHelper.executeUpdate(sql);
        return r;
    }
    public ArrayList<Experiment> allExperimentByclass(String classno, String courseId) {
        ArrayList<Experiment> list = new ArrayList<>();
        String sql = "SELECT * FROM ex_status2 where classno = '"+classno+"' and c_id = '"+courseId+"';";
        ResultSet rs = SQLHelper.executeQuery(sql);
        try{
            while (rs.next()) {
                Experiment experiment = new Experiment();
                experiment.setId(rs.getInt(1));
                experiment.setExp_name(rs.getString(3));
                experiment.setStuId(rs.getString(4));
                experiment.setUpload(rs.getBoolean(5));
                experiment.setLocation(rs.getString(7));
                list.add(experiment);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SQLHelper.closeConnection();
        return list;
    }
    public ArrayList<Experiment> allExperimentBySno(String sno, String c_id) {
        ArrayList<Experiment> list = new ArrayList<>();
        String sql = "SELECT * FROM ex_status2 where stuId = '"+sno+"' and c_id  = '"+c_id+"' group by id;";
        ResultSet rs = SQLHelper.executeQuery(sql);
        try{
            while (rs.next()) {
                Experiment experiment = new Experiment();
                experiment.setId(rs.getInt(1));
                experiment.setCourseId(rs.getString(2));
                experiment.setExp_name(rs.getString(3));
                experiment.setStuId(rs.getString(4));
                experiment.setUpload(rs.getBoolean(5));
                experiment.setLocation(rs.getString(7));
                experiment.setContent(rs.getString(8));
                list.add(experiment);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SQLHelper.closeConnection();
        return list;
    }
    public int resetPassword(String type,String Id) {
        int r=0;
        String sql = "update "+type+" set password = HEX(AES_ENCRYPT('123456','key1234')) where id='"+Id+"'";
        r=SQLHelper.executeUpdate(sql);
        return r;
    }
    public ArrayList<Student> queryByStuID(String stuId) {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "select * from students where id ='"+stuId+"'";
        ResultSet rs = SQLHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString(1));
                student.setName(rs.getString(2));
                student.setClassno(rs.getString(4));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQLHelper.closeConnection();
        return list;
    }
    public int repairStuInf(String stuId, String stuName, String classId) {
        int r=0;
        String sql = "update students set classno= '"+classId+"' , name = '"+stuName+"' where id='"+stuId+"'";
        r=SQLHelper.executeUpdate(sql);
        return r;
    }
    public boolean Verification(String id, String password, String user_type) {
        String sql = "call verification('"+user_type+"','"+id+"','"+password+"');";
        ResultSet rs = SQLHelper.executeQuery(sql);
        boolean a = false;
        try {
            if (rs.next()){
                a = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public void uploadExperiment(String id,String exp_id,String courseId, String filename) {
        String sql = "call uploadExperiment('"+id+"','"+exp_id+"','"+courseId+"','"+filename+"');";
        ResultSet rs = SQLHelper.executeQuery(sql);
    }

    public void assignment(Experiment exper) {
        String sql = "INSERT INTO experiments(c_id,exp_name,demand,content,classno) " +
                "VALUES  ( '"+exper.getCourseId()+"','"+exper.getExp_name()+"','"+exper.getDemand()+"','"+exper.getContent()+"','"+exper.getClassno()+"');";
         SQLHelper.executeUpdate(sql);

        sql = "SELECT * FROM experiments where exp_name = '"+exper.getExp_name()+"';";
        ResultSet rs = SQLHelper.executeQuery(sql);
        int exp_id = 0;
        try{
            while (rs.next()) {
             exp_id = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        sql = "SELECT * FROM students where classno = "+exper.getClassno()+";";
        rs = SQLHelper.executeQuery(sql);
        try{
            while (rs.next()) {
                String stu_Id = rs.getString(1);
                sql="INSERT INTO if_do(expId,c_id,stuId)  VALUES ("+exp_id+",'"+exper.getCourseId()+"'"+",'"+stu_Id+"');";
                SQLHelper.executeUpdate(sql);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SQLHelper.closeConnection();
    }

    public String getName(String id, String user_type) {
        String sql = "select name from "+user_type+" where id = '"+id+"';";
        ResultSet rs = SQLHelper.executeQuery(sql);
        String name = null;
        try {
            if (rs.next()){
                name = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    public ArrayList<Student> queryByClassno(String classno) {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "select * from students where classno = '"+classno+"';";
        ResultSet rs = SQLHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString(1));
                student.setName(rs.getString(2));
                student.setClassno(rs.getString(4));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQLHelper.closeConnection();
        return list;
    }

    public ArrayList<Teacher> queryByTeaID(String teaId) {
        ArrayList<Teacher> list = new ArrayList<>();
        String sql = "select * from teachers where id ='"+teaId+"'";
        ResultSet rs = SQLHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                Teacher tea = new Teacher();
                tea.setId(rs.getString(1));
                tea.setName(rs.getString(2));
                list.add(tea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQLHelper.closeConnection();
        return list;
    }

    public void repairTeaInf(String teaId, String teaName) {
        String sql = "update teachers set name = '"+teaName+"' where id='"+teaId+"'";
        SQLHelper.executeUpdate(sql);
    }

    public void InsertStu(String stuId, String stuName, String classno) {
        String sql = "INSERT INTO students VALUES ('"+stuId+"','"+stuName+"',HEX(AES_ENCRYPT('123456','key1234')),'"+classno+"');";
        SQLHelper.executeUpdate(sql);
        sql = "SELECT * FROM experiments where classno = "+classno+";";
        ResultSet rsExpid = SQLHelper.executeQuery(sql);
        try{
            while (rsExpid.next()){
                   String exp_id = rsExpid.getString(1);
                    sql="INSERT INTO if_do(expId,stuId) VALUES ("+exp_id+",'"+stuId+"');";
                    SQLHelper.executeUpdate(sql);
                }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SQLHelper.closeConnection();
    }

    public void InsertTea(String teaId, String teaName) {
        String sql = "INSERT INTO teachers VALUES ('"+teaId+"', '"+teaName+"',HEX(AES_ENCRYPT('123456','key1234')));";
        SQLHelper.executeUpdate(sql);
    }

    public ArrayList<Course> courseStatus(String id) {
        ArrayList<Course> list = new ArrayList<>();
        String sql = "select course.id,course.cname from course,sc where course.id = sc.c_id and sc.s_id = '"+id+"';";
        ResultSet rs = SQLHelper.executeQuery(sql);
        try {
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getString(1));
                course.setC_name(rs.getString(2));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQLHelper.closeConnection();
        return list;
    }
}
