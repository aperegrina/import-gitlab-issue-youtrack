package org.youtrack.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.certuit.utils.DateFormat;

import java.util.ArrayList;
import java.util.Date;



/**
 * Created by andre on 5/13/16.
 */
public class YouTrack {

    public static final ObjectMapper MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private static final String API_NAMESPACE = "/rest";
    private static final String PARAM_SUDO = "sudo";
    private static final String  authMethod="/user/login";
    private int requestTimeout = 0;
    private final String hostUrl;
    private Date expires;

    public YouTrack(String hostUrl) {
        this.hostUrl = hostUrl;
    }

    public YouTrack(String hostUrl, Date expires) {
        this.hostUrl = hostUrl;
        this.expires = expires;
    }

    public static YouTrack connect(String hostUrl, String apiUser, String apiPassword) {
        ArrayList<BasicNameValuePair> arrayListParams=new ArrayList<BasicNameValuePair>();
        arrayListParams.add(new BasicNameValuePair("login",apiUser));
        arrayListParams.add(new BasicNameValuePair("password",apiPassword));
        HttpResponse httpResponse=YoutrackHttpConection.executeHttpPost( (hostUrl.endsWith("/") ? hostUrl.replaceAll("/$", "") : hostUrl)+API_NAMESPACE+authMethod,arrayListParams);
        Date expires= null;
        expires = DateFormat.parse(httpResponse.getFirstHeader("Expires").getValue());
        return new YouTrack(hostUrl,expires);
    }



}
