package ae.zerotone.monitor.domain.repository;

import ae.zerotone.monitor.domain.model.entity.MonitorDataEntity;
import ae.zerotone.monitor.domain.model.entity.MonitorDataMapEntity;
import ae.zerotone.monitor.domain.model.entity.MonitorFlowDesignerEntity;
import ae.zerotone.monitor.domain.model.vo.GatherNodeExpressionVO;
import ae.zerotone.monitor.domain.model.vo.MonitorTreeConfigVO;
import java.util.List;

public interface IMonitorRepository {
  List<GatherNodeExpressionVO> queryGatherNodeExpressionVO(
      String systemName, String className, String methodName);

  String queryMonitoryNameByMonitoryId(String monitorId);

  void saveMonitoryData(MonitorDataEntity monitorDataEntity);

  List<MonitorDataMapEntity> queryMonitorDataMapEntityList();

  MonitorTreeConfigVO queryMonitorFlowData(String monitorId);

  List<MonitorDataEntity> queryMonitorDataEntityList(MonitorDataEntity monitorDataEntity);

  void updateMonitorFlowDesigner(MonitorFlowDesignerEntity monitorFlowDesignerEntity);
}
