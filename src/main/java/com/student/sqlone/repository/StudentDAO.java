package com.student.sqlone.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.sql.*;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.dao.support;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.student.sqlone.model.Student;



@Repository
public class StudentDAO {

     @Autowired
     private JdbcTemplate jdbcTemplate;

     private static final String SQL = "select * from tbl_student_list";

     public List<Student> isData() {

          List<Student> students = new ArrayList<Student>();
          List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

          for (Map<String, Object> row : rows) 
          {
               Student student = new Student();
               student.setId((int)row.get("student_id"));
               student.setName((String)row.get("student_name"));
               student.setAge((int)row.get("student_age"));
               student.setStandard((int)row.get("student_standard"));
               student.setSection((String)row.get("student_section"));
               student.setDate((Timestamp)row.get("student_registration_date"));

               students.add(student);
           }

         return students;
     }

      // Saving a new Student
    public Student saveStudent(Student student) {
        String sqlinsert = "insert into tbl_student_list (student_name, student_age, student_standard, student_section) values (?,?,?,?)";
       // "insert into tbl_student_list values(?,?,?,?)";
        KeyHolder holder = new GeneratedKeyHolder();
        //Put Validation for age and class not equal to zero
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sqlinsert, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, student.getName());
                ps.setInt(2, student.getAge());
                ps.setInt(3, student.getStandard());
                ps.setString(4, student.getSection());
                return ps;
            }
        }, holder);
        int newStudentId = holder.getKey().intValue();
        student.setId(newStudentId);
        return student;

        /*
        int createresult = jdbcTemplate.update(sqlinsert, new Object[]{ 
          student.getName(), student.getAge(), student.getStandard(), student.getSection()});
        return createresult;
        */
        }


        /*
        public User create(final User user) 
        {
        final String sql = "insert into users(name,email) values(?,?)";

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                return ps;
            }
        }, holder);

        int newUserId = holder.getKey().intValue();
        user.setId(newUserId);
        return user;
        }

        */


        /*public Student getLastStudent() {
          String lastrowsql = "SELECT * FROM tbl_student_list ORDER BY student_id DESC LIMIT 1";
          Student lastrow = (Student)jdbcTemplate.queryForObject(lastrowsql, new Object[] {}, Student.class);
          return lastrow;


        }
      `*/
      
      // Deleting old Student
      //use only student id here
    public Student deleteStudent(int id) {
        Student foundstudent = this.findStudent(id);
        try {
          String sqldelete = "delete from tbl_student_list where student_id=?";
          jdbcTemplate.update(sqldelete, new Object[] { id });
            return foundstudent;
        } catch (EmptyResultDataAccessException e) {
              return null;
          } 

        /*       
        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sqlinsert);
                ps.setInt(1, student.getName());
                return ps;
            }
        }, holder);
        int newStudentId = holder.getKey().intValue();
        student.setId(newStudentId);
        return student;
        */

        }

         //Finding old Student
    private Student findStudent(int id) {

      try {


          String sqlfind = "select * from tbl_student_list where `student_id` = ?";
          Student foundstudent = (Student) jdbcTemplate.queryForObject(sqlfind, new Object[]
          { id }, new RowMapper()
          {
              @Override
              public Student mapRow(ResultSet rs, int rowNum) throws SQLException
                {
                  Student student = new Student();
                  student.setId(rs.getInt(1));
                  student.setName(rs.getString(2));
                  student.setAge(rs.getInt(3));
                  student.setStandard(rs.getInt(4));
                  student.setSection(rs.getString(5));
                  student.setDate(rs.getTimestamp(6));
                  return student;
                }
          });
        return foundstudent;
        } catch (EmptyResultDataAccessException e) {
          return null;
        }
      }


      // Updating old Student
    public Student updateStudent(Student student) {
        Student foundstudent = this.findStudent(student.getId());
        if(student.getName()!=null && student.getName()!="") {
          foundstudent.setName(student.getName());

        }
        if(student.getAge()!=0) {
          foundstudent.setAge(student.getAge());

        }
        if(student.getStandard()!=0) {
          foundstudent.setStandard(student.getStandard());

        }
        if(student.getSection()!=null  && student.getName()!="") {
          foundstudent.setSection(student.getSection());

        }
            String sqlupdate = "update tbl_student_list set student_name=?, student_age=?, student_standard=?, student_section=? where student_id =?";
            jdbcTemplate.update(sqlupdate, new Object[] { 
              foundstudent.getName(), foundstudent.getAge(), foundstudent.getStandard(), foundstudent.getSection(), foundstudent.getId() 
            });
              return foundstudent;
           
        }

    }