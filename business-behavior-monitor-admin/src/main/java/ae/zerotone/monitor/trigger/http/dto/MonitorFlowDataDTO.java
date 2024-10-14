package ae.zerotone.monitor.trigger.http.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitorFlowDataDTO {

    private String monitorId;
    @JsonProperty("class")
    private String clazz = "go.GraphLinksModel";

    private ModelData modelData = new ModelData();

    private List<NodeData> nodeDataArray;

    private List<LinkData> linkDataArray;

    @Data
    public static class ModelData {
        private final String position = "-5 -5";
    }

    @Data
    public static class NodeData {
        // 节点标识
        private String key;
        // 节点内容
        private String text;
        // 节点坐标 210 110
        private String loc;
        // 填充颜色 #CE0620 #4fba4f
        private String fill;
        // 备注信息
        private String remark;

        public NodeData() {
        }

        public NodeData(String key, String text01, String text02, String text03, String loc, Color color) {
            this.key = key;
            this.text = "编号：" + text01 + "\r\n" + "名称：" + text02 + "\r\n" + "次数：" + text03;
            this.loc = loc;
            this.fill = color.getCode();
        }

        public NodeData(String key, String text01, String text02, String text03, String loc, String color) {
            this.key = key;
            this.text = "编号：" + text01 + "\r\n" + "名称：" + text02 + "\r\n" + "次数：" + text03;
            this.loc = loc;
            this.fill = color;
        }

        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        public enum Color {

            green("#2ECC40", "绿色"),
            red("#DC143C", "红色"),
            yellow("#FFDC00", "黄色");

            private String code;
            private String info;
        }

    }

    @Data
    public static class LinkData {
        private String from;
        private String to;
        private String key;
        private String text;
        private String remark;
        private String condition;

        public LinkData() {
        }

        public LinkData(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public LinkData(String from, String to, String key, String text) {
            this.from = from;
            this.to = to;
            this.key = key;
            this.text = text;
        }
    }

}
