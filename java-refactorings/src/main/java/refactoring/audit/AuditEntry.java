package refactoring.audit;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AuditEntry {

    private Date timestamp;
    private String operatorId;
    private String operatorName;
    private String eventId;
    private String id;
    private String businessUnitId;
    private String objectId;
    private String objectVersion;
    private String objectType;
    private String objectLabel;
    private String targetId;
    private String targetVersion;
    private String targetType;
    private String targetLabel;
    private Map<String, String> objectProperties;

    private String comments;
    private String tenantId;

    public AuditEntry() {
        this.setTimestamp(new Date());
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessUnitId() {
        return businessUnitId;
    }

    public void setBusinessUnitId(String businessUnitId) {
        this.businessUnitId = businessUnitId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectLabel() {
        return objectLabel;
    }

    public void setObjectLabel(String objectLabel) {
        this.objectLabel = objectLabel;
    }

    public Map<String, String> getObjectProperties() {
        if (this.objectProperties == null)
            this.setObjectProperties(new HashMap<>());

        return objectProperties;
    }

    public void setObjectProperties(Map<String, String> objectProperties) {
        this.objectProperties = objectProperties;
    }

    public void setObjectProperty(String key, String value) {
        this.getObjectProperties().put(key, value);
    }

    public String getObjectProperty(String key) {
        return this.getObjectProperties().get(key);
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(String objectVersion) {
        this.objectVersion = objectVersion;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetVersion() {
        return targetVersion;
    }

    public void setTargetVersion(String targetVersion) {
        this.targetVersion = targetVersion;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getTargetLabel() {
        return targetLabel;
    }

    public void setTargetLabel(String targetLabel) {
        this.targetLabel = targetLabel;
    }

    @Override
    public String toString() {
        return "<eventId=" + eventId +
                " / objectId=" + objectId +
                " / objectType=" + objectType +
                " / objectLabel=" + objectLabel +
                " / objectVersion=" + objectVersion +
                ">";
    }
}
