package com.wzh.hadoop;

import org.apache.hadoop.conf.Configuration;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Test;

public class HDFSApp {
    public static final String  HDFS_PATH="hdfs://192.168.245.131:9000";
    FileSystem fileSystem;
    Configuration configuration;

    @Before
    public void setUp() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("setUp……");
        Configuration configuration=new Configuration();
        fileSystem= FileSystem.get(new URI(HDFS_PATH),configuration,"wzh");


    }

    @Test
    public void mkdir() throws IOException {
        System.out.println("mkdir……");
        fileSystem.mkdirs(new Path("/hdfsapi/test"));
    }


    @Test
    public void ls() throws IOException {
        RemoteIterator<LocatedFileStatus> remoteIterator = fileSystem.listFiles(new Path("/"), true);
        while(remoteIterator.hasNext()){
            System.out.println(remoteIterator.next().getPath().getName());
        }
    }
    @Test
    public void testPut() throws IOException {
        String file="D:\\learn\\spring\\spring-framework-5.0.1.RELEASE\\license.txt";
        fileSystem.copyFromLocalFile(new Path(file),new Path("/user/wzh"));
    }
}
