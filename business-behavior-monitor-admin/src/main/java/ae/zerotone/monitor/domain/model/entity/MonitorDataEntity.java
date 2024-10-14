package ae.zerotone.monitor.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonitorDataEntity {

  // 监控ID
  private String monitorId;
  // 监控名称
  private String monitorName;
  // 节点ID
  private String monitorNodeId;
  // 系统名称
  private String systemName;
  // 类的名称
  private String clazzName;
  // 方法名称
  private String methodName;
  // 属性名称
  private String attributeName;
  // 属性字段
  private String attributeField;
  // 属性的值
  private String attributeValue;
}
