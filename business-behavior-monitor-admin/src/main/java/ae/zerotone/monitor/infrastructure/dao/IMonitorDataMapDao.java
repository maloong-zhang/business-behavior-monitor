package ae.zerotone.monitor.infrastructure.dao;

import ae.zerotone.monitor.infrastructure.po.MonitorDataMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMonitorDataMapDao {
  String queryMonitorNameByMonitoryId(String monitorId);

  List<MonitorDataMap> queryMonitorDataMapEntityList();
}
