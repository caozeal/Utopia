package com.caozeal.sometry;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**.
 * 关于NIO.2的一些尝试
 * <p>创建时间： 2017年8月02日上午10:35:49
 * <p>com.caozeal.sometry
 * @author  caozeal
 * @version 1.0
 *
 */
@Controller
public class TryAboutNIO2 {

	private static final Logger logger = LoggerFactory.getLogger(TryAboutNIO2.class);
	
	/**
	 * 测试处理一些path相关的特性
	 * <p>
	 * 创建时间：2017年8月4日上午11:23:08
	 * @author caozhiyong
	 * @param path
	 */
	public static void handlePath(String path){
		Path list = Paths.get(path);
		try {
			logger.debug("Path: " + list);
			logger.debug("Path.normalize: " + list.normalize());
			//toRealPath()需要存在真实路径，否则会抛出 java.nio.file.NoSuchFileException 异常
			//不会改变Path的值
			logger.debug("Path.toRealPath: " + list.toRealPath());
			logger.debug("Path: " + list);
			logger.debug("Path.getNameCount: " + list.getNameCount());
			logger.debug("Path.getFileName: " + list.getFileName());
			logger.debug("Path.getRoot: " + list.getRoot());
			logger.debug("Path.isAbsolute: " + list.isAbsolute());
			logger.debug("Path.getFileSystem: " + list.getFileSystem());
			logger.debug("Path.getParent: " + list.getParent());
			logger.debug("Path.subpath: " + list.subpath(0, 1));
		} catch (IOException e) {
			logger.error("处理path出现问题", e);
		}
	}
	
	/**
	 * 查找目录下所有pdf文件
	 * <p>
	 * 问题：会把以.pdf结尾的文件夹也搜索出来
	 * <p>
	 * 创建时间：2017年8月4日下午6:25:27
	 * @author caozhiyong
	 * @param path
	 */
	public static void searchPdf(String path){
		Path list = Paths.get(path);
		searchPdf(list);
	}
	/**
	 * 查找目录下所有pdf文件
	 * <p>
	 * 问题：会把以.pdf结尾的文件夹也搜索出来
	 * <p>
	 * 创建时间：2017年8月4日下午6:24:01
	 * @author caozhiyong
	 * @param path
	 */
	public static void searchPdf(Path path){
		//直接查找会把以.pdf结尾的文件夹也搜索出来
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.pdf")) {
			for(Path entry : stream){
				logger.debug("目录下的pdf文件有：" + entry.getFileName());
			}
		} catch (IOException e) {
			logger.error("查找pdf文件出错", e);
		} 
	}
	
	public static void handleFiles(String path){
		Path target = Paths.get(path);
		try {
			//如果文件已经存在，会抛出FileAlreadyExistsException
			Path file = Files.createFile(target);
			logger.info("创建文件成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("处理file出错", e);
		}
	}
}
