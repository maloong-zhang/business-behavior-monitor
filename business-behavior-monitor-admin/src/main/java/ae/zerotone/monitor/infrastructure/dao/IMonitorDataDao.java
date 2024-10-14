package ae.zerotone.monitor.infrastructure.dao;

import java.util.List;

import ae.zerotone.monitor.infrastructure.po.MonitorData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMonitorDataDao {

  List<MonitorData> queryMonitorDataList(MonitorData monitorDataReq);

  void insert(MonitorData monitorDataReq);
}
