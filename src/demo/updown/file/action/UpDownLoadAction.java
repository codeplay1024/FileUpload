package demo.updown.file.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import demo.updown.file.actionform.UpLoadActionForm;
import demo.updown.file.model.UploadFiles;
import demo.updown.file.service.UpDownLoad;
import demo.updown.file.service.UpDownLoadImpl;

public class UpDownLoadAction extends DispatchAction {
	/**
	 * 上传文件
	 * */
	public ActionForward upLoadFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		UpLoadActionForm upLoad = (UpLoadActionForm) form;
		List upLoads = upLoad.getFiles();

		UpDownLoad updownload = new UpDownLoadImpl();
		List fileList = new ArrayList();
		for (int i = 0; i < upLoads.size(); i++) {
			FormFile formFile = (FormFile) upLoads.get(i);
			// 调用单个文件上传的方法
			UploadFiles files = updownload.uploadfile(formFile);
			System.out.println("上传文件：" + files.getUploadFileName());
			fileList.add(files);
		}
		request.setAttribute("fileList", fileList);
		return mapping.findForward("download");
	}

	/**
	 * 文件下载
	 * */
	public ActionForward downLoadFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String filename = request.getParameter("name");
		String realname = request.getParameter("realname");

		response.reset();// 可以加也可以不加
		response.setContentType("application/x-download");// 设置为下载application/x-download
		/*
		 * 这个属性设置的是下载工具下载文件时显示的文件名,要想正确的显示中文文件名，我们需要对fileName再次编码
		 * 否则中文名文件将出现乱码，或无法下载的情况
		 */
		realname = URLEncoder.encode(realname, "UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ realname);// 下载文件时，显示的文件名

		// 下载文件的路径
		String path = this.servlet.getServletContext().getRealPath("/file")
				+ "/" + filename;

		OutputStream output = response.getOutputStream();
		FileInputStream fis = new FileInputStream(path);

		byte[] b = new byte[1024];
		int i = 0;

		while ((i = fis.read(b)) > 0) {
			output.write(b, 0, i);
		}
		output.flush();
		fis.close();
		output.close();

		return null;
	}

}