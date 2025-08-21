package basics.equalshashcodetostring;

import lombok.*;

public class Demo {
    public static void main(String[] args) {

        Student stu=new Student("KITS", 30, "Sumit", "Raut") ;
        Student stu2=new Student("KITS", 30, "Amit", "Nitn") ;

        System.out.println(stu);//basics.equalshashcodetostring.Student@7dc5e7b4
        System.out.println(stu.toString());//basics.equalshashcodetostring.Student@7dc5e7b4



        StudentWithEquals stux=new StudentWithEquals("KITS", 30, "Sumit", "Raut") ;
        System.out.println(stux);//StudentWithEquals(college=KITS, age=30, firstName=Sumit, lastName=Raut)


    }

}

class Student{
    String college;
    Integer age;
    String firstName;
    String lastName;

    public Student(){};

    public Student(String college,Integer age,String firstName,String lastName){
        this.college=college;
        this.age=age;
        this.firstName=firstName;
    }


    public String getCollege(){
        return college;
    }

    public void setCollege(String college){
        this.college=college;
    }
    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age=age;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
}



@Data
@AllArgsConstructor
@EqualsAndHashCode// @Data will take care of this. Redundant
class StudentWithEquals{
    @Getter// @Data will take care of this. Redundant
    @Setter// @Data will take care of this. Redundant
    String college;
    Integer age;
    String firstName;
    String lastName;
}

