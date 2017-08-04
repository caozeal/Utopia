package com.caozeal.someTry;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**.
 * 关于Http的一些尝试
 * <p>创建时间：2017年6月10日下午10:35:49
 * <p>com.caozeal.someTry
 * @author  caozeal
 * @version 1.0
 *
 */
@Controller
public class TryAboutHttp {
	
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
			// TODO: handle exception
		}
	}
//	public static void main(String[] args) {
//		TryAboutChild tryAboutChild = new TryAboutChild();
//		tryAboutChild.setLastName("qwe");
//		tryAboutChild.setHomeTown("222");
//	}
}
