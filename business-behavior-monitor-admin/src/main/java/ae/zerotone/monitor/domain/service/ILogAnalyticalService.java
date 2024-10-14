package ae.zerotone.monitor.domain.service;

import ae.zerotone.monitor.domain.model.entity.MonitorDataEntity;
import ae.zerotone.monitor.domain.model.entity.MonitorDataMapEntity;
import ae.zerotone.monitor.domain.model.entity.MonitorFlowDesignerEntity;
import ae.zerotone.monitor.domain.model.vo.MonitorTreeConfigVO;
import java.util.List;
import ognl.OgnlException;

public interface ILogAnalyticalService {
  void doAnalytical(String systemName, String className, String methodName, List<String> logList)
      throws OgnlException;

  List<MonitorDataMapEntity> queryMonitorDataMapEntityList();

  MonitorTreeConfigVO queryMonitorFlowData(String monitorId);

  List<MonitorDataEntity> queryMonitorDataEntityList(MonitorDataEntity monitorDataEntity);

  void updateMonitorFlowDesigner(MonitorFlowDesignerEntity monitorFlowDesignerEntity);
}
