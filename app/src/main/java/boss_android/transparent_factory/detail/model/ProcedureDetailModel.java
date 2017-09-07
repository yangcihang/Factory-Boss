package boss_android.transparent_factory.detail.model;

import java.io.Serializable;

/**
 * @author YangCihang
 * @since 17/8/31.
 * email yangcihang@hrsoft.net
 */

public class ProcedureDetailModel implements Serializable {
    //          "id": 1,
//                  "order_id": 1,
//                  "name": "测试工序",
//                  "total_count": 100,
//                  "weight": 1,
//                  "standard": "个",
//                  "leader_id": 1,
//                  "work_group_id": 1,
//                  "start_time": "2017-08-29 19:26:39",
//                  "end_time": "2017-08-31 19:26:39",
//                  "description": null,
//                  "add_on": null,
//                  "created_at": "2017-08-29 20:37:13",
//                  "updated_at": "2017-08-29 21:07:58",
//                  "status": 1,
//                  "success_count": 0
    private int id;
    private int orderId;
    private String name;
    private int totalCount;
    private int weight;
    private String standard;
    private int leaderId;
    private int workGroupId;
    private String startTime;
    private String endTime;
    private String description;
    private String addOn;
    private String createdAt;
    private String updatedAt;
    private int status;
    private int successCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }
}
