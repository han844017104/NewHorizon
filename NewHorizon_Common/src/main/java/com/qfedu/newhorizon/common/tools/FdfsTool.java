package com.qfedu.newhorizon.common.tools;


import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.IOException;

public class FdfsTool {

    private TrackerClient trackerClient;
    private TrackerServer trackerServer;
    private StorageClient1 storageClient;
    private StorageServer storageServer;

    public FdfsTool(String confaddr) throws IOException, MyException {
        if (confaddr.startsWith("classpath")){
            confaddr=confaddr.replace("classpath:", getClass().getResource("/").getPath());
        }
        ClientGlobal.init(confaddr);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageClient = new StorageClient1(trackerServer,storageServer);
    }

    public String upload(byte[] data, String endName, NameValuePair [] pairs) throws IOException, MyException {
        return storageClient.upload_file1(data, endName, pairs);
    }

}
