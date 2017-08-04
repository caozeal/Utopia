package com.caozeal.someTry;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**.
 * 关于NIO.2的一些尝试
 * <p>创建时间： 2017年8月02日上午10:35:49
 * <p>com.caozeal.someTry
 * @author  caozeal
 * @version 1.0
 *
 */
@Controller
public class TryAboutNIO2 {

	private static final Logger logger = LoggerFactory.getLogger(TryAboutNIO2.class);
	
	public static void handlePath(String path){
		Path list = Paths.get(path);
		try {
			logger.info(""+list.toRealPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
