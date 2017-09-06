package com.ctsi.backup.app;

import com.ctsi.backup.launcher.AppLauncher;
import com.ctsi.backup.utils.DllLoder;

public class App extends AppLauncher{
	public static void main(String[] args) {
		AppLauncher.main(args);
		DllLoder.getInstance();
        System.out.println("----------------->start hahhahhaahahahh end!!!");
	}
}