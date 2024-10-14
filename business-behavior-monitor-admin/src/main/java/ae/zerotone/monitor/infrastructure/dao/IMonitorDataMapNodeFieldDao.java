package ae.zerotone.monitor.infrastructure.dao;

import ae.zerotone.monitor.infrastructure.po.MonitorDataMapNodeField;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMonitorDataMapNodeFieldDao {
  List<MonitorDataMapNodeField> queryMonitorDataMapNodeList(
      MonitorDataMapNodeField monitorDataMapNodeFieldReq);
}
