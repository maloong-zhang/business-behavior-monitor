package ae.zerotone.monitor.infrastructure.po;


import java.util.Date;
import lombok.Data;

@Data
public class MonitorData {

    // 自增ID
    private Long id;
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
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;

}
