package top.gzk.wy;

import com.mongodb.client.gridfs.GridFSBucket;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.io.FileInputStream;
import java.io.FileOutputStream;

@SpringBootTest
public class GridFSTest {
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;

    @Test //上传
    public void test() throws Exception{
        ObjectId fileId = gridFsTemplate.store(new FileInputStream("c://1.mp4"), "1.mp4");
        System.out.println(fileId.toString());
    }

    @Test //下载视频
    public void test2() throws Exception{
        gridFSBucket.downloadToStream(new ObjectId("64c0c96c5156760d9dff5fc3"),new FileOutputStream("c:\\2.mp4"));
    }
}
