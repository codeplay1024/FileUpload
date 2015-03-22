package demo.updown.file.actionform;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UpLoadActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	/**
	 * struts1文件上传用的是调用的是专门上传的接口FormFile, 单文件上传只需在Form中给一个FormFile类型的属性，
	 * 多文件上传时，struts在页面端将多个文件封装成一个数组，转给Form类时转换成List
	 * 所以我们在页面上使用数组形式对文件进行提交，在Form类中用List对文件进行接收。
	 * 
	 * */
	private List<FormFile> files = new ArrayList<FormFile>();

	public FormFile getFile(int i) {
		return files.get(i);
	}

	public void setFile(int i, FormFile file) {
		files.add(file);
	}

	public List getFiles() {
		return files;
	}
}