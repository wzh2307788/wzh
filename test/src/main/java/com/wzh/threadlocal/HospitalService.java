package com.wzh.threadlocal;
import java.util.*;
import java.util.function.Consumer;

public class HospitalService {
   ThreadLocal<List> medicineList=new ThreadLocal<List>();

   public void seeDoctor(){
       List<String> medicines=Arrays.asList("a","b","c","d","e","f");
       ArrayList<String> list=new ArrayList<String>();
       Random random=new Random();
       int begin=random.nextInt(medicines.size()/2);
       int end=random.nextInt(medicines.size());

       if(begin>end){
           int tmp=end;
           end=begin;
           begin=tmp;
       }
       list.addAll(medicines.subList(begin,end ));
       medicineList.set(list);
   }

    public boolean charge(final String patientId){
                List<String> list = medicineList.get();
                list.stream().forEach(new Consumer<String>() {
                    @Override
            public void accept(String o) {
                System.out.println("patientId="+patientId+"is paying the medicine："+o);
            }
        });
        return true;
    }
    public void clear(){
        medicineList.remove();
    }
}
