package ae.zerotone.monitor.sdk.push;

import ae.zerotone.monitor.sdk.model.LogMessage;

/**
 * @description 发布
 */
public interface IPush {

  void open(String host, int port);

  void send(LogMessage logMessage);
}
