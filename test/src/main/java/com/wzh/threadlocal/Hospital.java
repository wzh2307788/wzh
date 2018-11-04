package com.wzh.threadlocal;

public class Hospital {

    public static void main(String[] args) {
        HospitalService service = new HospitalService();
        for ( int i = 0; i < 3; i++) {
             new Thread( String.valueOf(i)) {
                int patientId;

                @Override
                public void run() {
                   /* service.seeDoctor();

                    service.charge(getName());*/
                }
            }.start();
        }
    }
}
