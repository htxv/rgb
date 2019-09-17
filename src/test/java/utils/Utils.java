package utils;

public class Utils {

    public static String getSystemName(){
        return System.getProperty("os.name");
    }

    public static SystemEnum getSystemEnum() {
        return getSystemName().contains("Win") ? SystemEnum.WINDOWS :
                getSystemName().contains("Mac") ? SystemEnum.MAC : SystemEnum.UNIX;
    }

}