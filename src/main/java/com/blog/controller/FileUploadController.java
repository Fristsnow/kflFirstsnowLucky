package com.blog.controller;

import com.blog.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
@Slf4j
public class FileUploadController {

    private static final String url = "http://localhost:9090/api/v1/images/";

    @PostMapping
    public Result<String> upload(MultipartFile file) {
        if (file.isEmpty()) return Result.error(422, "upload error");
        String filename = file.getOriginalFilename();
        // aaa txt java txt
        String ext = "." + filename.split("\\.")[1];
        if (!ext.equals(".png")) {
            return Result.error(422, "images error");
        }
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String newFileName = uuid + ext;
        // 保存文件到本地
        getFileMontage(file, newFileName);
        String path = url + newFileName;
        // 返回文件路径
        return Result.success(path);
    }

    /**
     * 路径拼接
     *
     * @param file
     * @param newFileName
     * @return
     */
    private String getFileMontage(MultipartFile file, String newFileName) {
        ApplicationHome home = new ApplicationHome(this.getClass());
        String pre = home.getDir().getParentFile().getParentFile().getAbsoluteFile() +
                "\\src\\main\\resources\\static\\images\\";
        String path = pre + newFileName;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
