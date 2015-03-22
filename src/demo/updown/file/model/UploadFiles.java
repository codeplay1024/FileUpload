package demo.updown.file.model;
public class UploadFiles {
	private String uploadFileName;// 上传的文件名称
	private String uploadContentType;// 类型
	private String uploadRealName;// 保存的文件真实名称，UUID

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadRealName() {
		return uploadRealName;
	}

	public void setUploadRealName(String uploadRealName) {
		this.uploadRealName = uploadRealName;
	}
}