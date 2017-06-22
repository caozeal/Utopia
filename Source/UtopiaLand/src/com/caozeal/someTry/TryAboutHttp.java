package com.caozeal.someTry;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/uploadFile")
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
	
	public static void main(String[] args) {
		TryAboutChild tryAboutChild = new TryAboutChild();
		tryAboutChild.setLastName("qwe");
		tryAboutChild.setHomeTown("222");
	}
}
