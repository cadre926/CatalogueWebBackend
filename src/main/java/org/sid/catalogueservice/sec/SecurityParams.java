package org.sid.catalogueservice.sec;
public interface SecurityParams {

    public static final String HEADERNAME="Authorization";
    public static final String SECRET="assabyl4@gmail.com";
    public static final long EXPIRATION=10*24*3600*1000;
    public static final String HEADER_PREFEX="Bearer ";

}
