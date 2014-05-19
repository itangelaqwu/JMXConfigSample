package main.java.cm.angela.JMXConfig;

/**
 * Created by Angela on 5/18/2014.
 */
public class GlobleConfigs implements GlobleConfigsMBean{
    private String ipDir;

    public String getIpDir(){
        return ipDir;
    }

    public void setIpDir(String ipDir) {
        this.ipDir = ipDir;
    }

}
