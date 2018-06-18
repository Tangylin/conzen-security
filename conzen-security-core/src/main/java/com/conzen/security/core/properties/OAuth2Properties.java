package com.conzen.security.core.properties;

/**
 * @Author: Less
 * @Date: 2018/6/18 下午5:18
 * @Description:
 **/
public class OAuth2Properties {

    private String jwtSigningKey = "conzen";

    private OAuth2ClientProperties[] clients = {};

    public OAuth2ClientProperties[] getClients() {
        return clients;
    }

    public void setClients(OAuth2ClientProperties[] clients) {
        this.clients = clients;
    }

    public String getJwtSigningKey() {
        return jwtSigningKey;
    }

    public void setJwtSigningKey(String jwtSigningKey) {
        this.jwtSigningKey = jwtSigningKey;
    }
}
