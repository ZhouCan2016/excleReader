package com.ctsi.backup.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.StringTokenizer;

public class DllLoder {
	private static DllLoder dll;  
	private DllLoder() {
		try {
			//动态获取项目根目录下的文件路径
			String path = Thread.currentThread().getContextClassLoader().getResource("./Vix.dll").getPath();
			// LIBFILENAME dll文件的路径
			String LIBFILENAME = URLDecoder.decode(path, "utf-8");
			// 获取到java.library.path 及系统变量中Path中的内容
			String libpath = System.getProperty("java.library.path");
			if (libpath == null || libpath.length() == 0) {
				throw new RuntimeException("java.library.path is null");
			}
			// javaBinPath jdk的bin目录
			String javaBinPath = null;
			StringTokenizer st = new StringTokenizer(libpath, System.getProperty("path.separator"));
			if (st.hasMoreElements()) {
				javaBinPath = st.nextToken();
			} else {
				throw new RuntimeException("can not split library path:" + libpath);
			}
			// 把dll文件写入到java.library.path中该dll放在ConvertWord2HM相同目录下，这个可以是你的类名
			InputStream inputStream = DllLoder.class.getResourceAsStream(LIBFILENAME);
			final File dllFile = new File(LIBFILENAME);
			if (!dllFile.exists()) {
				FileOutputStream outputStream = new FileOutputStream(dllFile);
				byte[] array = new byte[1024];
				int bytesRead = -1;
				while ((bytesRead = inputStream.read(array)) != -1) {
					outputStream.write(array, 0, bytesRead);
				}
				outputStream.flush();
				outputStream.close();
			}
			// 动态加载dll
			System.load(dllFile.getPath());
			// 在虚拟机关闭的时候删除dll
			dllFile.deleteOnExit();
		} catch (Throwable e) {
			throw new RuntimeException("load Convert.dll error!", e);
		}
	}  

	public static synchronized DllLoder getInstance() {
		if (dll == null) {
			dll = new DllLoder();
		}
		return dll;
	}
}
