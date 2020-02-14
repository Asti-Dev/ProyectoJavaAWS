package pe.isil.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;

import java.io.InputStream;

public class S3Manager {

    AWSCredentials credentials =
            new BasicAWSCredentials("AKIAQKS6V3RVIDNBC4F5", "EzGkWZ/nfhkZIR9/39gNEbNqrBmYQhM0lDNW4be9");

    AmazonS3 s3Client = AmazonS3ClientBuilder
            .standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion(Regions.US_WEST_1)
            .build();

    final String bucketName = "isil-dsc-asti2";
    
    public void createBucket() {
    	if (!s3Client.doesBucketExistV2(bucketName)){
            s3Client.createBucket(bucketName);
        }

    	
    }
    
    public void uploadFileToS3(String name, InputStream is){

        	s3Client.putObject(bucketName, name, is, new ObjectMetadata());

    }
}
