package ae.zerotone.monitor.sdk.model;

import java.util.List;

/**
 * @description 日志消息
 */
public class LogMessage {

  private String systemName;

  private String className;

  private String methodName;

  private List<String> logList;

  public LogMessage() {}

  public LogMessage(String systemName, String className, String methodName, List<String> logList) {
    this.systemName = systemName;
    this.className = className;
    this.methodName = methodName;
    this.logList = logList;
  }

  public String getSystemName() {
    return systemName;
  }

  public String getClassName() {
    return className;
  }

  public String getMethodName() {
    return methodName;
  }

  public List<String> getLogList() {
    return logList;
  }
}
