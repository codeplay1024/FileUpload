package demo.updown.file.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.struts.upload.FormFile;

import demo.updown.file.model.UploadFiles;

public class UpDownLoadImpl implements UpDownLoad {

	String path = "C:/source/tomcat8.0.20/wtpwebapps/FileUpload/file/";

	public UploadFiles uploadfile(FormFile file) throws IOException {
		String fileName = file.getFileName();// 原文件名
		String realName = UUID.randomUUID().toString()
				+ fileName.substring(fileName.lastIndexOf("."));// 保存的文件名称，使用UUID+后缀进行保存
		// 创建文件夹，保存上传文件
		File filepath = new File(path);
		if (!filepath.isDirectory()) {
			filepath.mkdir();
		}
		// 文件上传后的路径
		String filePath = filepath + "/" + realName;

		InputStream stream = file.getInputStream();
		OutputStream bos = new FileOutputStream(filePath);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
			bos.write(buffer, 0, bytesRead);
		}
		bos.close();
		stream.close();

		// 页面上显示上传的文件信息
		UploadFiles files = new UploadFiles();
		files.setUploadFileName(file.getFileName());
		files.setUploadContentType(file.getContentType());
		files.setUploadRealName(realName);

		return files;
	}
}