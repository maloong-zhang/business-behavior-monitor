package ae.zerotone.monitor.trigger.http;


import ae.zerotone.monitor.domain.model.entity.MonitorDataEntity;
import ae.zerotone.monitor.domain.model.entity.MonitorDataMapEntity;
import ae.zerotone.monitor.domain.model.entity.MonitorFlowDesignerEntity;
import ae.zerotone.monitor.domain.model.vo.MonitorTreeConfigVO;
import ae.zerotone.monitor.domain.service.ILogAnalyticalService;
import ae.zerotone.monitor.trigger.http.dto.MonitorDataDTO;
import ae.zerotone.monitor.trigger.http.dto.MonitorDataMapDTO;
import ae.zerotone.monitor.trigger.http.dto.MonitorFlowDataDTO;
import ae.zerotone.monitor.types.Response;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController()
@CrossOrigin("*")
@RequestMapping("/api/v1/monitor/")
public class MonitorController {

    @Resource
    private ILogAnalyticalService logAnalyticalService;

    /**
     * http://localhost:8091/api/v1/monitor/query_monitor_data_map_entity_list
     */
    @RequestMapping(value = "query_monitor_data_map_entity_list", method = RequestMethod.GET)
    public Response<List<MonitorDataMapDTO>> queryMonitorDataMapEntityList() {
        try {
            List<MonitorDataMapEntity> monitorDataMapEntities = logAnalyticalService.queryMonitorDataMapEntityList();
            List<MonitorDataMapDTO> monitorDataMapDTOS = new ArrayList<>(monitorDataMapEntities.size());
            for (MonitorDataMapEntity monitorDataMapEntity : monitorDataMapEntities) {
                monitorDataMapDTOS.add(MonitorDataMapDTO.builder()
                        .monitorId(monitorDataMapEntity.getMonitorId())
                        .monitorName(monitorDataMapEntity.getMonitorName())
                        .build());
            }
            return Response.<List<MonitorDataMapDTO>>builder()
                    .code("0000")
                    .info("调用成功")
                    .data(monitorDataMapDTOS)
                    .build();
        } catch (Exception e) {
            log.error("查询监控列表数据失败", e);
            return Response.<List<MonitorDataMapDTO>>builder()
                    .code("0001")
                    .info("调用失败")
                    .build();
        }
    }

    @RequestMapping(value = "query_monitor_flow_map", method = RequestMethod.GET)
    public Response<MonitorFlowDataDTO> queryMonitorFlowMap(@RequestParam String monitorId) {
        try {
            log.info("查询监控流数据 monitorId:{}", monitorId);
            MonitorTreeConfigVO monitorTreeConfigVO = logAnalyticalService.queryMonitorFlowData(monitorId);
            List<MonitorTreeConfigVO.Node> nodeList = monitorTreeConfigVO.getNodeList();
            List<MonitorTreeConfigVO.Link> linkList = monitorTreeConfigVO.getLinkList();

            List<MonitorFlowDataDTO.NodeData> nodeDataList = new ArrayList<>();
            for (MonitorTreeConfigVO.Node node : nodeList) {
                nodeDataList.add(new MonitorFlowDataDTO.NodeData(
                        node.getMonitorNodeId(),
                        node.getMonitorNodeId(),
                        node.getMonitorNodeName(),
                        node.getMonitorNodeValue(),
                        node.getLoc(),
                        node.getColor()));
            }

            List<MonitorFlowDataDTO.LinkData> linkDataList = new ArrayList<>();
            for (MonitorTreeConfigVO.Link link : linkList) {
                String linkValue = link.getLinkValue();
                linkDataList.add("0".equals(linkValue) ?
                        new MonitorFlowDataDTO.LinkData(link.getFromMonitorNodeId(), link.getToMonitorNodeId()) :
                        new MonitorFlowDataDTO.LinkData(link.getFromMonitorNodeId(), link.getToMonitorNodeId(), link.getLinkKey(), linkValue));
            }

            MonitorFlowDataDTO monitorFlowDataDTO = new MonitorFlowDataDTO();
            monitorFlowDataDTO.setNodeDataArray(nodeDataList);
            monitorFlowDataDTO.setLinkDataArray(linkDataList);

            // 返回结果
            return Response.<MonitorFlowDataDTO>builder()
                    .code("0000")
                    .info("调用成功")
                    .data(monitorFlowDataDTO).build();
        } catch (Exception e) {
            log.error("查询监控流数据失败 monitorId:{}", monitorId, e);
            return Response.<MonitorFlowDataDTO>builder()
                    .code("0001")
                    .info("调用失败")
                    .build();
        }
    }

    @RequestMapping(value = "query_monitor_data_list", method = RequestMethod.GET)
    public Response<List<MonitorDataDTO>> queryMonitorDataList(@RequestParam String monitorId, @RequestParam String monitorName, @RequestParam String monitorNodeId) {
        try {
            log.info("查询监控数据 monitorId:{}", monitorId);
            List<MonitorDataEntity> monitorDataEntities = logAnalyticalService.queryMonitorDataEntityList(MonitorDataEntity.builder()
                    .monitorId(StringUtils.isBlank(monitorId.trim()) ? null : monitorId)
                    .monitorName(StringUtils.isBlank(monitorName.trim()) ? null : monitorName)
                    .monitorNodeId(StringUtils.isBlank(monitorNodeId.trim()) ? null : monitorNodeId)
                    .build());

            List<MonitorDataDTO> monitorDataDTOS = new ArrayList<>();
            for (MonitorDataEntity monitorDataEntity : monitorDataEntities) {
                monitorDataDTOS.add(MonitorDataDTO.builder()
                        .monitorId(monitorDataEntity.getMonitorId())
                        .monitorName(monitorDataEntity.getMonitorName())
                        .monitorNodeId(monitorDataEntity.getMonitorNodeId())
                        .systemName(monitorDataEntity.getSystemName())
                        .clazzName(monitorDataEntity.getClazzName())
                        .methodName(monitorDataEntity.getMethodName())
                        .attributeName(monitorDataEntity.getAttributeName())
                        .attributeField(monitorDataEntity.getAttributeField())
                        .attributeValue(monitorDataEntity.getAttributeValue())
                        .build());
            }
            return Response.<List<MonitorDataDTO>>builder()
                    .code("0000")
                    .info("调用成功")
                    .data(monitorDataDTOS)
                    .build();
        } catch (Exception e) {
            log.error("查询监控数据失败 monitorId:{}", monitorId, e);
            return Response.<List<MonitorDataDTO>>builder()
                    .code("0001")
                    .info("调用失败")
                    .build();
        }
    }

    @RequestMapping(value = "update_monitor_flow_designer", method = RequestMethod.POST)
    public Response<Boolean> updateMonitorFlowDesigner(@RequestParam String monitorId, @RequestBody MonitorFlowDataDTO request) {
        try {
            log.info("更新监控图配置 monitorId:{}", monitorId);
            List<MonitorFlowDataDTO.NodeData> nodeDataList = request.getNodeDataArray();
            List<MonitorFlowDataDTO.LinkData> linkDataList = request.getLinkDataArray();

            List<MonitorFlowDesignerEntity.Node> nodeList = new ArrayList<>();
            for (MonitorFlowDataDTO.NodeData nodeData : nodeDataList) {
                nodeList.add(MonitorFlowDesignerEntity.Node.builder()
                        .monitorNodeId(nodeData.getKey())
                        .loc(nodeData.getLoc())
                        .build());
            }

            List<MonitorFlowDesignerEntity.Link> linkList = new ArrayList<>();
            for (MonitorFlowDataDTO.LinkData linkData : linkDataList) {
                linkList.add(MonitorFlowDesignerEntity.Link.builder()
                        .from(linkData.getFrom())
                        .to(linkData.getTo())
                        .build());
            }

            MonitorFlowDesignerEntity monitorFlowDesignerEntity = MonitorFlowDesignerEntity.builder()
                    .monitorId(monitorId)
                    .nodeList(nodeList)
                    .linkList(linkList)
                    .build();

            logAnalyticalService.updateMonitorFlowDesigner(monitorFlowDesignerEntity);

            return Response.<Boolean>builder().code("0000").info("调用成功").data(true).build();
        } catch (Exception e) {
            log.error("更新监控图配置失败 monitorId:{}", monitorId, e);
            return Response.<Boolean>builder().code("0001").info("调用失败").data(true).build();
        }
    }

}
