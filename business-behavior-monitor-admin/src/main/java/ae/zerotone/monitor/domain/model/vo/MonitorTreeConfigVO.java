package ae.zerotone.monitor.domain.model.vo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonitorTreeConfigVO {

    // 监控ID
    private String monitorId;
    // 节点集合
    private List<Node> nodeList;
    // 链路关系
    private List<Link> linkList;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Node {
        // 节点ID
        private String monitorNodeId;
        // 节点名称
        private String monitorNodeName;
        // 节点坐标
        private String loc;
        // 节点颜色
        private String color;
        // 监控节点值
        private String monitorNodeValue;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Link {
        // from 监控ID
        private String fromMonitorNodeId;
        // to 监控ID
        private String toMonitorNodeId;
        // 链路Key
        private String linkKey;
        // 链路停留值
        private String linkValue;

    }
}
