package configuration.utilities;

import java.util.Properties;

public class ReadSystemProperties {

    public static void getSystemInfo(){
        System.out.println( System.getProperty("os.name"));
    }

    static Properties readProperty = ReadProperties.loadProperties("src/main/resources/config.properties");

    public static String getEnvUrl(){
        String url = null;
        if (envName.equalsIgnoreCase("dev")){
           url =readProperty.getProperty("DEV_URL");
       } else if (envName.equalsIgnoreCase("qa")) {
           url =readProperty.getProperty("QA_URL");
       } else if (envName.equalsIgnoreCase("prod")){
           url =readProperty.getProperty("PROD_URL");
       }
       return url;
   }

//   Default Environment
   public static String envName = System.getProperty("env","Prod");

}
