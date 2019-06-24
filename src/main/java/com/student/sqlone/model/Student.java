package com.student.sqlone.model;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Timestamp;

public class Student {

    private int db_id;
    private String name;
    @Min(1)
    private int age;
    @Max(12)
    @Min(1)
    private int standard;
    private String section;
    private Timestamp date;

    // Setter
      public void setId(int id) {
        this.db_id = id;
      }

      //Getter
    public int getId() {
        return db_id;
      }
    
    // Setter
      public void setName(String newName) {
        this.name = newName;
      }

    //Getter
    public String getName() {
        return name;
      }

      // Setter
      public void setAge(int newAge) {
        this.age = newAge;
      }

    //Getter
    public int getAge() {
        return age;
      }

      // Setter
      public void setStandard(int newStandard) {
        this.standard = newStandard;
      }

    //Getter
    public int getStandard() {
        return standard;
      }

      // Setter
      public void setSection(String newSection) {
        this.section = newSection;
      }

    //Getter
    public String getSection() {
        return section;
      }

    // Setter
    public void setDate(Timestamp date) {
      this.date = date;
      }

    //Getter
    public Timestamp getDate() {
        return date;
      } 

  }