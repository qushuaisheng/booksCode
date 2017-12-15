package classDemo;

import java.io.File;

public class SystemUtils
{

    public SystemUtils(){
    }

    public static File getJavaIoTmpDir(){
        return org.apache.commons.lang.SystemUtils.getJavaHome();
    }

    public static final String FILE_ENCODING;
    public static final String FILE_SEPARATOR;
    public static final String LINE_SEPARATOR;
    public static final String USER_DIR;

    static{
        FILE_ENCODING = org.apache.commons.lang.SystemUtils.FILE_ENCODING;
        FILE_SEPARATOR = org.apache.commons.lang.SystemUtils.FILE_SEPARATOR;
        LINE_SEPARATOR = org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
        USER_DIR = org.apache.commons.lang.SystemUtils.USER_DIR;
    }
}
