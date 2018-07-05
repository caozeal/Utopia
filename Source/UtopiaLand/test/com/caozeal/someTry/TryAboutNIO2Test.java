package com.caozeal.sometry;
/**.
 * <p>创建时间：2017年8月3日下午5:29:58
 * <p>com.caozeal.sometry
 * @author  caozhiyong
 * @version 1.0
 */

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

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

	@Test
    public void assertTest(){
	    assertThat(true);
    }


}
