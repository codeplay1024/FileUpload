package demo.updown.file.service;

import java.io.IOException;

import org.apache.struts.upload.FormFile;

import demo.updown.file.model.UploadFiles;

public interface UpDownLoad {
	public UploadFiles uploadfile(FormFile file) throws IOException;
}