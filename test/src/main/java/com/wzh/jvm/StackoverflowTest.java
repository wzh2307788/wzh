package com.wzh.jvm;

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
public class StackoverflowTest {
    static int j = 0;
    static int k = 0;

    public static void main(String[] args) {

        Object c = new Object();
        //   Class c=StackoverflowTest.class;

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {

                    //     synchronized (c){
                    //        c.wait();
                    System.out.println(j);
                    recursive(j);
                    //       c.notify();
                    //     }

                } catch (Throwable e) {
                    System.out.println(j);
                    System.out.println(e.getMessage());
                } finally {
                    System.out.println("thead 1 finally :" + j);
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    //   synchronized (c){
                    System.out.println(k);
                    c.wait();
                    recursive(k);
                    c.notify();
                    //    }
                } catch (Throwable e) {
                    System.out.println(k);
                    System.out.println(e.getMessage());
                } finally {
                    System.out.println("thead 2 finally :" + k);
                }
            }
        };
        thread1.start();
        //    thread2.start();


    }


    public static void recursive(int i) throws InterruptedException {
        j++;
        k++;
        byte[] b = new byte[300 * 1028];
        recursive(i + 1);
    }
}
