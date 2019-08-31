package com.caozeal.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**.
 * 关于Http的一些尝试
 * <p>创建时间：2017年6月10日下午10:35:49
 * <p>com.writ.practice
 * @author  writ
 * @version 1.0
 *
 */
@Controller
public class TryAboutHttp {
	
	private static final Logger logger = LoggerFactory.getLogger(TryAboutHttp.class);
	
	/**
	 * 上传文件测试，从页面上传文件到服务器
	 * <p>
	 * 创建时间：2017年8月4日上午11:20:14
	 * @author caozhiyong
	 * @param file
	 * @return
	 */
	@RequestMapping("uploadFile")
	@ResponseBody
	public String uploadFile(
			@RequestParam(value = "file", required = false) MultipartFile file ){
		String fileName = file.getOriginalFilename();
		File targetFile = new File("./file", fileName);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		//保存
		try {
			file.transferTo(targetFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "result";
	}
	
	/**
	 * 打开文件测试，这次是为了测试在浏览器中直接打开pdf文件
	 * <p>
	 * 直接给路径在页面打开没问题，以流的形式传输没能成功实现
	 * <p>
	 * 创建时间：2017年8月4日上午11:20:35
	 * @author caozhiyong
	 * @param request
	 * @param response
	 */
	@RequestMapping("openFile")
	@ResponseBody
	public void openFile(HttpServletRequest request,HttpServletResponse response){
		File file = new File("E:/atom/1.pdf");  
		try(FileInputStream fin = new FileInputStream(file);
				OutputStream ops = response.getOutputStream();){
			byte[] data = new byte[1024];
			//fin.read(data);
			response.setContentType("application/pdf");
			response.setCharacterEncoding("UTF-8");  
			response.setHeader("Content-Disposition","attachment;filename=test.pdf");
			
			int b = 0;
			while ((b = fin.read(data)) != -1) {  
                // 4.写到输出流(out)中  
                ops.write(data, 0, b);  
            } 
			//ops.write(data);
			ops.flush();
			ops.close();
		}catch (Exception e) {
			logger.error("打开文件出错", e);
		}
	}

}
