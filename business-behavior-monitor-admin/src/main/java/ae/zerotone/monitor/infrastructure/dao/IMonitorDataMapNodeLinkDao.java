package ae.zerotone.monitor.infrastructure.dao;

import ae.zerotone.monitor.infrastructure.po.MonitorDataMapNodeLink;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMonitorDataMapNodeLinkDao {
  List<MonitorDataMapNodeLink> queryMonitorNodeLinkConfigByMonitorId(String monitorId);

  void deleteLinkFromByMonitorId(String monitorId);

  void insert(MonitorDataMapNodeLink monitorDataMapNodeLinkReq);
}
