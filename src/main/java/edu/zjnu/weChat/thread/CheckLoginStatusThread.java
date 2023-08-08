package edu.zjnu.weChat.thread;

import edu.zjnu.weChat.core.Core;
import edu.zjnu.weChat.utils.SleepUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 检查微信在线状态
 * <p>
 * 如何来感知微信状态？
 * 微信会有心跳包，LoginServiceImpl.syncCheck()正常在线情况下返回的消息中retcode报文应该为"0"，心跳间隔一般在25秒，
 * 那么可以通过最后收到正常报文的时间来作为判断是否在线的依据。若报文间隔大于60秒，则认为已掉线。
 * </p>
 *
 * @author SetsunaYang
 * @version 1.0
 * @date
 */
public class CheckLoginStatusThread implements Runnable {
    private static Logger LOG = LoggerFactory.getLogger(CheckLoginStatusThread.class);
    private Core core = Core.getInstance();

    @Override
    public void run() {
        while (core.isAlive()) {
            // 秒为单位
            long t1 = System.currentTimeMillis();
            // 超过60秒，判为离线
            if (t1 - core.getLastNormalRetcodeTime() > 60 * 1000) {
                core.setAlive(false);
                LOG.info("微信已离线");
            }
            SleepUtils.sleep(10 * 1000); // 休眠10秒
        }
    }

}
