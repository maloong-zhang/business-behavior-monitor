package ae.zerotone.monitor.infrastructure.dao;

import ae.zerotone.monitor.infrastructure.po.MonitorDataMapNode;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMonitorDataMapNodeDao {
  List<MonitorDataMapNode> queryMonitoryDataMapNodeList(MonitorDataMapNode monitorDataMapNodeReq);

  List<MonitorDataMapNode> queryMonitorNodeConfigByMonitorId(String monitorId);

  void updateNodeConfig(MonitorDataMapNode monitorDataMapNodeReq);
}
