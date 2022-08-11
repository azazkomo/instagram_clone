package com.instagramclone.demo.business;

import com.instagramclone.demo.exception.BaseException;
import com.instagramclone.demo.exception.FileException;
import com.instagramclone.demo.exception.RegisterException;
import com.instagramclone.demo.model.MRegisterRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class TestBusiness {

    public String register(MRegisterRequest request) throws BaseException {
        if(request == null) {
            throw RegisterException.registernull();
        }

        if(Objects.isNull(request.getEmail())) {
            throw RegisterException.checkDataEmpty();
        }
        return "" + request.getEmail();
    }

    public String uploadProfilePicture(MultipartFile file) throws BaseException {
        if(file == null) {
            throw FileException.filenull();
        }

        if(file.getSize() > 1048576 * 2) {
            throw FileException.fileMaxSize();
        }

        String contentType = file.getContentType();
        List<String> supportContentType = Arrays.asList("image/jpeg", "image/png");
        if(contentType == null) {
            throw FileException.filedetailempty();
        }

        if(!supportContentType.contains(contentType)) {
            throw FileException.unsupport();
        }

        try {
            String FileLocation = new File("src/main/resources/static/uploads").getAbsolutePath() + "/" + file.getOriginalFilename();
            FileOutputStream output = new FileOutputStream(FileLocation);
            byte[] bytes = file.getBytes();
            output.write(bytes);
            output.close();
//            return "Upload and Create File Success";
            return new ClassPathResource("static/uploads/" + file.getOriginalFilename()).getPath();
        } catch (IOException e) {
            e.printStackTrace();
            throw FileException.createFileError();
        }

    }
}
