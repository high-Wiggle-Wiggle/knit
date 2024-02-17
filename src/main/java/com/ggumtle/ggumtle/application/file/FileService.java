package com.ggumtle.ggumtle.application.file;

import com.ggumtle.ggumtle.infrastructure.s3.UploadFileService;
import com.ggumtle.ggumtle.infrastructure.s3.dto.response.UploadResponse;
import com.ggumtle.ggumtle.infrastructure.s3.enums.FileType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FileService {

    private final UploadFileService uploadFileService;

    public UploadResponse uploadFile(FileType type, MultipartFile file) {
        return uploadFileService.execute(
                file,
                type.getFolder(),
                UUID.randomUUID().toString()
        );
    }
}
