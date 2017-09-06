

/**
 * OprationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */

    package com.frank.axis.service.impl;

    /*
     *  OprationService java interface
     */

    public interface OprationService {
          

        /**
          * Auto generated method signature
          * 
                    * @param search0
                
         */

         
                     public com.frank.axis.service.impl.SearchResponse search(

                        com.frank.axis.service.impl.Search search0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param search0
            
          */
        public void startsearch(

            com.frank.axis.service.impl.Search search0,

            final com.frank.axis.service.impl.OprationServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param noSearch2
                
         */

         
                     public com.frank.axis.service.impl.NoSearchResponse noSearch(

                        com.frank.axis.service.impl.NoSearch noSearch2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param noSearch2
            
          */
        public void startnoSearch(

            com.frank.axis.service.impl.NoSearch noSearch2,

            final com.frank.axis.service.impl.OprationServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    