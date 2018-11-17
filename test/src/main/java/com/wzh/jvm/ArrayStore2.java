
package com.wzh.jvm;

import java.util.ArrayList;


public class ArrayStore2 {
    static int j = 0;
    static int k = 0;
    static ArrayList list=new ArrayList<byte[]>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(j);
       // recursive(j);
        byte[] b=new byte[Integer.MAX_VALUE/2];
        byte[] b1=new byte[Integer.MAX_VALUE/2];
        byte[] b3=new byte[Integer.MAX_VALUE/8];
        byte[] b4=new byte[Integer.MAX_VALUE/16];
        byte[] b5=new byte[Integer.MAX_VALUE/2];
        while(true){
            new Thread(){
                @Override
                public void run() {
                    System.out.println(j++);
                    try {
                        Thread.sleep(3000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }


    public static void recursive(int i) throws InterruptedException {
        j++;
        System.out.println(i++);
    /*    byte[] b = new byte[600 * 1028];
        list.add(b);*/
        recursive(i );
    }

}
/**
 * byte[] b = new byte[300 * 1028];
 [Full GC (Ergonomics) [PSYoungGen: 139264K->139148K(216576K)] [ParOldGen: 683651K->683651K(684032K)] 822915K->822800K(900608K), [Metaspace: 3490K->3490K(1056768K)], 0.0174024 secs] [Times: user=0.03 sys=0.00, real=0.02 secs]
 2730
 [Full GC (Ergonomics) [PSYoungGen: 139264K->139148K(216576K)] [ParOldGen: 683953K->683953K(684032K)] 823217K->823101K(900608K), [Metaspace: 3490K->3490K(1056768K)], 0.0577418 secs] [Times: user=0.05 sys=0.00, real=0.06 secs]
 [Full GC (Allocation Failure) [PSYoungGen: 139148K->139148K(216576K)] [ParOldGen: 683953K->683934K(684032K)] 823101K->823083K(900608K), [Metaspace: 3490K->3490K(1056768K)], 0.2568886 secs] [Times: user=0.28 sys=0.00, real=0.26 secs]


 byte[] b = new byte[600 * 1028];
 1385
 Java heap space
 thead 1 finally :1385
 Heap
 PSYoungGen      total 193024K, used 151040K [0x00000000eb200000, 0x00000000fa800000, 0x0000000100000000)
 eden space 151040K, 100% used [0x00000000eb200000,0x00000000f4580000,0x00000000f4580000)
 from space 41984K, 0% used [0x00000000f7580000,0x00000000f7580000,0x00000000f9e80000)
 to   space 49152K, 0% used [0x00000000f4580000,0x00000000f4580000,0x00000000f7580000)
 ParOldGen       total 684032K, used 683917K [0x00000000c1600000, 0x00000000eb200000, 0x00000000eb200000)
 object space 684032K, 99% used [0x00000000c1600000,0x00000000eb1e3440,0x00000000eb200000)
 Metaspace       used 3522K, capacity 4500K, committed 4864K, reserved 1056768K
 class space    used 378K, capacity 388K, committed 512K, reserved 1048576K

 */


