/**
 * RobotRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.eastrobot.www.ws.RobotServiceEx;

public class RobotRequest  implements java.io.Serializable {
    private cn.eastrobot.www.ws.RobotServiceEx.UserAttribute[] attributes;

    private int maxReturn;

    private java.lang.String[] modules;

    private java.lang.String question;

    private java.lang.String sessionId;

    private java.lang.String[] tags;

    private java.lang.String userId;

    public RobotRequest() {
    }

    public RobotRequest(
           cn.eastrobot.www.ws.RobotServiceEx.UserAttribute[] attributes,
           int maxReturn,
           java.lang.String[] modules,
           java.lang.String question,
           java.lang.String sessionId,
           java.lang.String[] tags,
           java.lang.String userId) {
           this.attributes = attributes;
           this.maxReturn = maxReturn;
           this.modules = modules;
           this.question = question;
           this.sessionId = sessionId;
           this.tags = tags;
           this.userId = userId;
    }


    /**
     * Gets the attributes value for this RobotRequest.
     * 
     * @return attributes
     */
    public cn.eastrobot.www.ws.RobotServiceEx.UserAttribute[] getAttributes() {
        return attributes;
    }


    /**
     * Sets the attributes value for this RobotRequest.
     * 
     * @param attributes
     */
    public void setAttributes(cn.eastrobot.www.ws.RobotServiceEx.UserAttribute[] attributes) {
        this.attributes = attributes;
    }

    public cn.eastrobot.www.ws.RobotServiceEx.UserAttribute getAttributes(int i) {
        return this.attributes[i];
    }

    public void setAttributes(int i, cn.eastrobot.www.ws.RobotServiceEx.UserAttribute _value) {
        this.attributes[i] = _value;
    }

    /**
     * Gets the maxReturn value for this RobotRequest.
     * 
     * @return maxReturn
     */
    public int getMaxReturn() {
        return maxReturn;
    }


    /**
     * Sets the maxReturn value for this RobotRequest.
     * 
     * @param maxReturn
     */
    public void setMaxReturn(int maxReturn) {
        this.maxReturn = maxReturn;
    }


    /**
     * Gets the modules value for this RobotRequest.
     * 
     * @return modules
     */
    public java.lang.String[] getModules() {
        return modules;
    }


    /**
     * Sets the modules value for this RobotRequest.
     * 
     * @param modules
     */
    public void setModules(java.lang.String[] modules) {
        this.modules = modules;
    }

    public java.lang.String getModules(int i) {
        return this.modules[i];
    }

    public void setModules(int i, java.lang.String _value) {
        this.modules[i] = _value;
    }


    /**
     * Gets the question value for this RobotRequest.
     * 
     * @return question
     */
    public java.lang.String getQuestion() {
        return question;
    }


    /**
     * Sets the question value for this RobotRequest.
     * 
     * @param question
     */
    public void setQuestion(java.lang.String question) {
        this.question = question;
    }


    /**
     * Gets the sessionId value for this RobotRequest.
     * 
     * @return sessionId
     */
    public java.lang.String getSessionId() {
        return sessionId;
    }


    /**
     * Sets the sessionId value for this RobotRequest.
     * 
     * @param sessionId
     */
    public void setSessionId(java.lang.String sessionId) {
        this.sessionId = sessionId;
    }


    /**
     * Gets the tags value for this RobotRequest.
     * 
     * @return tags
     */
    public java.lang.String[] getTags() {
        return tags;
    }


    /**
     * Sets the tags value for this RobotRequest.
     * 
     * @param tags
     */
    public void setTags(java.lang.String[] tags) {
        this.tags = tags;
    }

    public java.lang.String getTags(int i) {
        return this.tags[i];
    }

    public void setTags(int i, java.lang.String _value) {
        this.tags[i] = _value;
    }


    /**
     * Gets the userId value for this RobotRequest.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this RobotRequest.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RobotRequest)) return false;
        RobotRequest other = (RobotRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.attributes==null && other.getAttributes()==null) || 
             (this.attributes!=null &&
              java.util.Arrays.equals(this.attributes, other.getAttributes()))) &&
            this.maxReturn == other.getMaxReturn() &&
            ((this.modules==null && other.getModules()==null) || 
             (this.modules!=null &&
              java.util.Arrays.equals(this.modules, other.getModules()))) &&
            ((this.question==null && other.getQuestion()==null) || 
             (this.question!=null &&
              this.question.equals(other.getQuestion()))) &&
            ((this.sessionId==null && other.getSessionId()==null) || 
             (this.sessionId!=null &&
              this.sessionId.equals(other.getSessionId()))) &&
            ((this.tags==null && other.getTags()==null) || 
             (this.tags!=null &&
              java.util.Arrays.equals(this.tags, other.getTags()))) &&
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAttributes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttributes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttributes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getMaxReturn();
        if (getModules() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getModules());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getModules(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getQuestion() != null) {
            _hashCode += getQuestion().hashCode();
        }
        if (getSessionId() != null) {
            _hashCode += getSessionId().hashCode();
        }
        if (getTags() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTags());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTags(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RobotRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eastrobot.cn/ws/RobotServiceEx", "RobotRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attributes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "attributes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eastrobot.cn/ws/RobotServiceEx", "UserAttribute"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modules");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modules"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("question");
        elemField.setXmlName(new javax.xml.namespace.QName("", "question"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sessionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tags");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tags"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
