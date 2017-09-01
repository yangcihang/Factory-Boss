package boss_android.transparent_factory.detail.model;

import java.io.Serializable;

/**
 * @author YangCihang
 * @since 17/8/31.
 * email yangcihang@hrsoft.net
 */

public class ProcedureModel implements Serializable {
    //     "id": 1,
//             "name": "生产胖次",
//             "weight": 0.6,
//             "standard": "件",
//             "description": "测试",
//             "orderId": 1,
//             "totalCount": 1000,
//             "leaderId": 1,
//             "workGroupId": 1,
//             "startTime": "2017-08-11 19:00:00",
//             "endTime": "2017-09-11 19:00:00",
//             "addOn": null,
//             "createdAt": null,
//             "updatedAt": null,
//             "workGroupName": "测试班组",
//             "successCount": 1160
    private int id;
    private String name;
    private float weight;
    private String standard;
    private String description;
    private int orderId;
    private int totalCount;
    private int leaderId;
    private int workGroupId;
    private String startTime;
    private String endTime;
    private String addOn;//附加字段
    private String createdAt;
    private String updatedAt;
    private String workGroupName;
    private int successCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public int getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(int workGroupId) {
        this.workGroupId = workGroupId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddOn() {
        return addOn;
    }

    public void setAddOn(String addOn) {
        this.addOn = addOn;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getWorkGroupName() {
        return workGroupName;
    }

    public void setWorkGroupName(String workGroupName) {
        this.workGroupName = workGroupName;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }
}
