
package com.wzh.jvm;

import java.util.ArrayList;

/*
1、默认  37592
2、-Xss1M  -XX:+PrintGCDetails -XX:+PrintGC

[GC (Allocation Failure) [PSYoungGen: 337920K->0K(340480K)] 419493K->81573K(457728K), 0.0076375 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
java.lang.StackOverflowError
finally :24750
Heap
 PSYoungGen      total 335360K, used 122777K [0x00000000eb200000, 0x00000000fff00000, 0x0000000100000000)
  eden space 330240K, 37% used [0x00000000eb200000,0x00000000f29e66b0,0x00000000ff480000)
  from space 5120K, 0% used [0x00000000ff480000,0x00000000ff480000,0x00000000ff980000)
  to   space 4608K, 0% used [0x00000000ffa80000,0x00000000ffa80000,0x00000000fff00000)
 ParOldGen       total 118784K, used 81566K [0x00000000c1600000, 0x00000000c8a00000, 0x00000000eb200000)
  object space 118784K, 68% used [0x00000000c1600000,0x00000000c65a78c8,0x00000000c8a00000)
 Metaspace       used 3534K, capacity 4500K, committed 4864K, reserved 1056768K
  class space    used 377K, capacity 388K, committed 512K, reserved 1048576K
3、-Xss2M  -XX:+PrintGCDetails -XX:+PrintGC
[GC (Allocation Failure) [PSYoungGen: 340833K->0K(341504K)] 422699K->81866K(457728K), 0.0073050 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
50951
java.lang.StackOverflowError
Heap
 PSYoungGen      total 341504K, used 174456K [0x00000000eb200000, 0x0000000100000000, 0x0000000100000000)
  eden space 340992K, 51% used [0x00000000eb200000,0x00000000f5c5e000,0x00000000fff00000)
  from space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
  to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
java.lang.StackOverflowError
 ParOldGen       total 116224K, used 81866K [0x00000000c1600000, 0x00000000c8780000, 0x00000000eb200000)

  object space 116224K, 70% used [0x00000000c1600000,0x00000000c65f2b70,0x00000000c8780000)
 Metaspace       used 3531K, capacity 4500K, committed 4864K, reserved 1056768K
 class space    used 377K, capacity 388K, committed 512K, reserved 1048576K
 */
public class ArrayStore {
    static int j = 0;
    static int k = 0;
    static ArrayList list=new ArrayList<byte[]>();

    public static void main(String[] args) {
        Object c = new Object();
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(j);
                    recursive(j);
                } catch (Throwable e) {
                    e.printStackTrace();
                    System.out.println(j);
                    System.out.println(e.getMessage());
                } finally {
                    System.out.println("thead 1 finally :" + j);
                }
            }
        }.start();
    }


    public static void recursive(int i) throws InterruptedException {
        j++;
        System.out.println(i++);
        byte[] b = new byte[600 * 1028];
        list.add(b);
        recursive(i );
    }

}
/**
 *
 * -XX:+PrintGCDetails -XX:+PrintGC -Xss1M
 *
 *
 *
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


