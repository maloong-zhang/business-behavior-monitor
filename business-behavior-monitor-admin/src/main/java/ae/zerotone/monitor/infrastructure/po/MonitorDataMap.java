package ae.zerotone.monitor.infrastructure.po;

import lombok.Data;

import java.util.Date;

@Data
public class MonitorDataMap {

  // 自增ID
  private Long id;
  // 监控ID
  private String monitorId;
  // 监控名称
  private String monitorName;
  // 创建日期
  private Date createTime;
  // 更新日期
  private Date updateTime;
}
