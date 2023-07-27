package top.gzk.wy.config.gridfs;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Configuration
public class GridFsConfig {


    //获取配置文件中数据库信息
    @Value("${spring.data.mongodb.database}")
    String db;

    //注入操作桶对象
    @Bean(name = "gridFsMp4Template")
    public GridFsTemplate gridFsTestTemplate(SimpleMongoClientDatabaseFactory dbFactory, MongoConverter converter) {
        return new GridFsTemplate(dbFactory, converter, "mp4");
    }

    //GridFSBucket用于打开下载流
    @Bean(name="gridMp4BucketTemplate")
    public GridFSBucket getGridFSBucket(MongoClient mongoClient){
        MongoDatabase mongoDatabase = mongoClient.getDatabase(db);
        GridFSBucket bucket = GridFSBuckets.create(mongoDatabase,"mp4");
        return bucket;
    }
}