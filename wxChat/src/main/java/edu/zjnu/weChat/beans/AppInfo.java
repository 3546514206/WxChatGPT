package edu.zjnu.weChat.beans;

import java.io.Serializable;

/**
 * AppInfo
 *
 * @author SetsunaYang
 * @version 1.0
 */
public class AppInfo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int type;
    private String appId;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

}
