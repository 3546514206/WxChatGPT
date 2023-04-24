package edu.zjnu;

import edu.zjnu.weChat.Wechat;
import edu.zjnu.weChat.face.IMsgHandlerFace;
import edu.zjnu.weChat.handler.SimpleHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author: 杨海波
 * @date: 2023-02-14 17:20:14
 * @description: 启动类
 */
@SpringBootApplication
public class WxChatApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WxChatApplication.class, args);
        startWxGpt(context);
    }

    private static void startWxGpt(ApplicationContext context) {
        // 保存登陆二维码图片的路径，这里需要在本地新建目录
        String qrPath = context.getEnvironment().getProperty("tmp.files.path");
        // 实现IMsgHandlerFace接口的类
        IMsgHandlerFace msgHandler = context.getBean(SimpleHandler.class);
        // 【注入】
        Wechat wechat = new Wechat(msgHandler, qrPath);
        // 启动服务，会在qrPath下生成一张二维码图片，扫描即可登陆，注意，二维码图片如果超过一定时间未扫描会过期，过期时会自动更新，所以你可能需要重新打开图片
        wechat.start();
    }


}
