package demo;

import enums.EnvironmentType;

public class R_XEnum {
    public static void main(String[] args) {

        EnvironmentType env=EnvironmentType.UAT;
        switch (env){
            case QA, UAT -> System.out.println(env.getFullName());


        }

    }
}
