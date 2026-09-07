package karat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class R9_IPAddressValidation {

    public static void main(String[] args) {



       // String []arr={"192.168.1.100","192.168.001.999","256.168.1","192.168.1"};

        String []arr2={"192.168.1.100","192.168.001.100","999.0.1.1","","12a.123."};



        var x=validateIP(arr2);
        System.out.println(x);
    }

    public static List<Boolean> validateIP(String[] ips){
        List<Boolean> res=new ArrayList<>();
       //null or empty array
        if(Objects.isNull(ips) || (ips.length==0)) return  res;


        for(String ip:ips){
            //1 null check
            if((ip==null)|| ip.isEmpty()){
                res.add(false);
                continue;
            }

            String []ipSplitArray=ip.split("\\.");
            //ip shud have 4 things
            if(ipSplitArray.length!=4)
            {
                res.add(false);
            continue;
            }



            boolean isValid=true;
            for(String seg: ipSplitArray){
                if(!seg.matches("\\d+"))
                {
                    isValid=false;
                    break;
                }

                //001
                if(seg.length()==3 && seg.startsWith("0"))
                {
                    isValid=false;
                    break;
                }

                // -1   255
                if(Integer.parseInt(seg)<0 || Integer.parseInt(seg)>255) {
                    isValid=false;
                    break;
                }
            }

            res.add(isValid);
        }


return res;

    }
}
