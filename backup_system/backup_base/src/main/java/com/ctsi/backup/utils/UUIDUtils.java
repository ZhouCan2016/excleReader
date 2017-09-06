package com.ctsi.backup.utils;

import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

public class UUIDUtils {
	
	 public static String getUUID() {
	        UUID uuid = UUID.randomUUID();
	        return StringUtils.replace(uuid.toString().trim(), "-", "");
	    }

}
