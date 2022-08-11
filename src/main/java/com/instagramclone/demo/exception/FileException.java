package com.instagramclone.demo.exception;

public class FileException extends BaseException {

    public FileException(String code) {
        super("File : " + code);
    }

    public static FileException filenull() {
        return new FileException("is Empty");
    }

    public static FileException fileMaxSize() {
        return new FileException("is over SizeLimit");
    }

    public static FileException unsupport() {
        return new FileException("unsupported File Type");
    }

    public static FileException filedetailempty() {
        return new FileException("Detail Of File is Empty");
    }

    public static FileException createFileError() {
        return new FileException("Create File Error.");
    }

}
