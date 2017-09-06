

/**
 * OrderInfoWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */

    package cn.com.ctsi.orderwebservice.api.webservice;

    /*
     *  OrderInfoWebService java interface
     */

    public interface OrderInfoWebService {
          

        /**
          * Auto generated method signature
          * 
                    * @param orderInfo0
                
         */

         
                     public cn.com.ctsi.orderwebservice.api.webservice.OrderInfoResponse orderInfo(

                        cn.com.ctsi.orderwebservice.api.webservice.OrderInfo orderInfo0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param orderInfo0
            
          */
        public void startorderInfo(

            cn.com.ctsi.orderwebservice.api.webservice.OrderInfo orderInfo0,

            final cn.com.ctsi.orderwebservice.api.webservice.OrderInfoWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    