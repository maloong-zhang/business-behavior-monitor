package ae.zerotone.monitor.infrastructure.po;


import java.util.Date;
import lombok.Data;

@Data
public class MonitorDataMapNodeField {

    // 自增ID
    private Long id;
    // 监控ID
    private String monitorId;
    // 节点ID
    private String monitorNodeId;
    // 日志名称
    private String logName;
    // 解析顺序；第几个字段
    private Integer logIndex;
    // 字段类型；Object、String
    private String logType;
    // 属性名称
    private String attributeName;
    // 属性字段
    private String attributeField;
    // 解析公式
    private String attributeOgnl;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;

}
