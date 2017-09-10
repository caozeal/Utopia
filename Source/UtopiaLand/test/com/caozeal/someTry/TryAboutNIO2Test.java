package com.caozeal.someTry;
/**.
 * <p>创建时间：2017年8月3日下午5:29:58
 * <p>com.caozeal.someTry
 * @author  caozhiyong
 * @version 1.0
 */

import org.junit.Test;

public class TryAboutNIO2Test {

	
	@Test
	public void pathTest(){
		String path = "C:/Users/hy/Downloads";
		TryAboutNIO2.handlePath(path);
		TryAboutNIO2.searchPdf(path);
	}
	
	@Test
	public void filesTest(){
		String path = "F:/下载/test.txt";
		TryAboutNIO2.handleFiles(path);
	}
}
