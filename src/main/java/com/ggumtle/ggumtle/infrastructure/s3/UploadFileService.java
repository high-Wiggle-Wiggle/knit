package com.ggumtle.ggumtle.infrastructure.s3;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ggumtle.ggumtle.infrastructure.s3.dto.response.UploadResponse;
import com.ggumtle.ggumtle.infrastructure.s3.error.S3ErrorProperty;
import com.ggumtle.ggumtle.shared.config.properties.S3Properties;
import com.ggumtle.ggumtle.shared.error.MatzipException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UploadFileService {

    private final S3Properties s3Properties;
    private final AmazonS3Client amazonS3Client;

    public UploadResponse execute(MultipartFile file, String folder, String fileName) {
        String fullFileName = createFileName(folder, fileName);

        try {
            PutObjectRequest request = new PutObjectRequest(
                    s3Properties.getBucket(),
                    fullFileName,
                    file.getInputStream(),
                    getObjectMetadata(file)
            );

            amazonS3Client.putObject(request);
        } catch (SdkClientException | IOException e) {
            throw new MatzipException(S3ErrorProperty.FAILED_TO_SAVE);
        }

        return new UploadResponse(
                amazonS3Client.getUrl(s3Properties.getBucket(), fullFileName).toString()
        );
    }

    private String createFileName(String folder, String fileName) {
        return folder + "/" + fileName;
    }

    private ObjectMetadata getObjectMetadata(MultipartFile file) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());
        return objectMetadata;
    }
}