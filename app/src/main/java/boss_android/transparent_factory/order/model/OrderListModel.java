package boss_android.transparent_factory.order.model;

import java.io.Serializable;

/**
 * @author YangCihang
 * @since 17/8/27.
 * email yangcihang@hrsoft.net
 */

public class OrderListModel implements Serializable {
    // "id": 1,
//         "title": "生产变形金刚",
//         "status": 0,
//         "type": 1,
//         "description": null,
//         "orderCode": "15039187976901",
//         "startTime": "2017-08-11 12:00:00",
//         "endTime": "2017-09-11 12:00:00",
//         "creatorId": 1,
//         "totalCount": "10000个",
//         "addOn": null,
//         "customerInfo": "万代集团",
//         "createdAt": "2017-08-28 19:13:17",
//         "updatedAt": "2017-08-28 19:13:17",
//         "capacity": 0.4
    private int id;
    private String title;
    private int status;
    private int type;//内部和外部的订单
    private String description;
    private String orderCode;
    private String startTime;
    private String endTime;
    private int creatorId; //创建人的ID
    private String totalCount;
    private String addOn;
    private String customerInfo;
    private String createdAt;
    private String updatedAt;
    private String name;
    private float capacity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getAddOn() {
        return addOn;
    }

    public void setAddOn(String addOn) {
        this.addOn = addOn;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
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

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
