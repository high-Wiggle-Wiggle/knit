package com.ggumtle.ggumtle.presentation.file;

import com.ggumtle.ggumtle.application.file.FileService;
import com.ggumtle.ggumtle.infrastructure.s3.dto.response.UploadResponse;
import com.ggumtle.ggumtle.infrastructure.s3.enums.FileType;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "파일")
@RequiredArgsConstructor
@RequestMapping("/files")
@RestController
public class FileController {

    private final FileService fileService;

    @PostMapping
    public UploadResponse uploadFile(
            @RequestParam FileType type,
            @RequestParam MultipartFile file
    ) {
        return fileService.uploadFile(type, file);
    }
}
