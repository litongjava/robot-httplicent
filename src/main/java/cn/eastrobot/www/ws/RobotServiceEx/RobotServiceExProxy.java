package cn.eastrobot.www.ws.RobotServiceEx;

public class RobotServiceExProxy implements cn.eastrobot.www.ws.RobotServiceEx.RobotServiceEx_PortType {
  private String _endpoint = null;
  private cn.eastrobot.www.ws.RobotServiceEx.RobotServiceEx_PortType robotServiceEx_PortType = null;
  
  public RobotServiceExProxy() {
    _initRobotServiceExProxy();
  }
  
  public RobotServiceExProxy(String endpoint) {
    _endpoint = endpoint;
    _initRobotServiceExProxy();
  }
  
  private void _initRobotServiceExProxy() {
    try {
      robotServiceEx_PortType = (new cn.eastrobot.www.ws.RobotServiceEx.RobotServiceEx_ServiceLocator()).getDefaultRobotServiceExPort();
      if (robotServiceEx_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)robotServiceEx_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)robotServiceEx_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (robotServiceEx_PortType != null)
      ((javax.xml.rpc.Stub)robotServiceEx_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.eastrobot.www.ws.RobotServiceEx.RobotServiceEx_PortType getRobotServiceEx_PortType() {
    if (robotServiceEx_PortType == null)
      _initRobotServiceExProxy();
    return robotServiceEx_PortType;
  }
  
  public cn.eastrobot.www.ws.RobotServiceEx.RobotResponse openSession(cn.eastrobot.www.ws.RobotServiceEx.RobotRequest robotRequest) throws java.rmi.RemoteException{
    if (robotServiceEx_PortType == null)
      _initRobotServiceExProxy();
    return robotServiceEx_PortType.openSession(robotRequest);
  }
  
  public cn.eastrobot.www.ws.RobotServiceEx.RobotResponse closeSession(cn.eastrobot.www.ws.RobotServiceEx.RobotRequest robotRequest) throws java.rmi.RemoteException{
    if (robotServiceEx_PortType == null)
      _initRobotServiceExProxy();
    return robotServiceEx_PortType.closeSession(robotRequest);
  }
  
  public cn.eastrobot.www.ws.RobotServiceEx.RobotResponse deliver(cn.eastrobot.www.ws.RobotServiceEx.RobotRequest robotRequest) throws java.rmi.RemoteException{
    if (robotServiceEx_PortType == null)
      _initRobotServiceExProxy();
    return robotServiceEx_PortType.deliver(robotRequest);
  }
  
  
}