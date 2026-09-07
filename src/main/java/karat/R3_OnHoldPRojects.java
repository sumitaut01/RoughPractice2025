package karat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class R3_OnHoldPRojects {

    /*
    Plain Text

project names = ["Athena", "Zeus", "Odyssey", "Zeus", "Phoeni
"Apollo"]
project on hold = "Zeus"
Show more lines
Expected Output:
Plain Text

["Athena", "Odyssey", "Phoenix", "Apollo", "Zeus", "Zeus"]
     */

    public static void main(String[] args) {


        String nullString=null;

        String emptyString="";

        //System.out.println(nullString.isEmpty());//exception
        System.out.println(Objects.isNull(nullString));
        System.out.println(emptyString.isEmpty());//true
        System.out.println(emptyString.isBlank());//true



    }






public static void moveOnHoldProjects(String[] projects, String onHoldProjects){
        if(Objects.isNull(projects)||Objects.isNull(onHoldProjects)||onHoldProjects.isEmpty()||projects.length==0){
            return;
        }

        List<String> lstActive=new ArrayList<>();
        List<String> lstOnhold=new ArrayList<>();

        for(String s:projects){
            if(!String.valueOf(s).equals(onHoldProjects)){
                lstActive.add(s);
            }
            else{
                lstOnhold.add(s);
            }
        }

        int index=0;
        for(String s:lstActive){
            projects[index++]=s;
        }

    for(String s:lstOnhold){
        projects[index++]=s;
    }




}
}
