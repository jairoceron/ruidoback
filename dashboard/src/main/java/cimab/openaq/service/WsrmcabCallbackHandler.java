package cimab.openaq.service;
import org.apache.commons.httpclient.HttpException;
import org.apache.axis2.transport.TransportUtils;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.transport.MessageFormatter;
/**
 *  WsrmcabCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class WsrmcabCallbackHandler{



    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public WsrmcabCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public WsrmcabCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

    public Object getClientData() {
        return clientData;
    }


    /**
     * auto generated Axis2 call back method for getDataHorario method
     * override this method for handling normal response from getDataHorario operation
     */
    public void receiveResultgetDataHorario(
            cimab.openaq.service.WsrmcabStub.GetDataHorarioResponseE result
    ) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getDataHorario operation
     */
    public void receiveErrorgetDataHorario(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getDataPeriodo method
     * override this method for handling normal response from getDataPeriodo operation
     */
    public void receiveResultgetDataPeriodo(
            cimab.openaq.service.WsrmcabStub.GetDataPeriodoResponseE result
    ) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getDataPeriodo operation
     */
    public void receiveErrorgetDataPeriodo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for hello method
     * override this method for handling normal response from hello operation
     */
    public void receiveResulthello(
            cimab.openaq.service.WsrmcabStub.HelloResponseE result
    ) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from hello operation
     */
    public void receiveErrorhello(java.lang.Exception e) {
    }



}
