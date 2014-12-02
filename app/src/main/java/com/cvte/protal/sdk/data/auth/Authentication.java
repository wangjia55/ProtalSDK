package com.cvte.protal.sdk.data.auth;

/**
 * Package : com.cvte.protal.sdk.data.auth
 * Author : jacob
 * Date : 14-12-2
 * Description : 这个类是和帐号操作相关的信息类
 */
public class Authentication {
    private String account;
    private String password;
    private String appKey;
    private String appSecret;
    private String authCode;
    private String accessToken;
    private String refreshToken;
    private String id;
    private String grant;
    private String newAccount;
    private long expireTimeMillis;
    private int lang = 0;

    protected Authentication(String appKey,
                             String appSecret,
                             String accessToken,
                             String refreshToken,
                             String account,
                             String password,
                             String authCode,
                             String grantType,
                             long expireIn,
                             int lang,
                             String newAccount) {
        setAppKey(appKey);
        setAppSecret(appSecret);
        setAccessToken(accessToken);
        setRefreshToken(refreshToken);
        setAccount(account);
        setPassword(password);
        setAuthCode(authCode);
        setGrant(grantType);
        setLang(lang);
        setNewAccount(newAccount);
        setExpireTimeMillis(expireIn);
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrant() {
        return grant;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }

    public long getExpireTimeMillis() {
        return expireTimeMillis;
    }

    public void setExpireTimeMillis(long expireTimeMillis) {
        this.expireTimeMillis = expireTimeMillis;
    }

    public String getNewAccount() {
        return newAccount;
    }

    public void setNewAccount(String newAccount) {
        this.newAccount = newAccount;
    }

    public static class Builder {
        private String mAppKey;
        private String mAppSecret;
        private String mAccessToken;
        private String mRefreshToken;
        private String mAccount;
        private String mPassword;
        private String mAuthCode;
        private String mGrantType;
        private String mNewAccount;
        private long mExpireIn;
        private int mLang = 0;

        public Builder setAppKey(String appKey) {
            mAppKey = appKey;
            return this;
        }

        public Builder setAppSecret(String appSecret) {
            mAppSecret = appSecret;
            return this;
        }

        public Builder setAccessToken(String accessToken) {
            mAccessToken = accessToken;
            return this;
        }

        public Builder setRefreshToken(String refreshToken) {
            mRefreshToken = refreshToken;
            return this;
        }

        public Builder setAccount(String account) {
            mAccount = account;
            return this;
        }

        public Builder setPassword(String password) {
            mPassword = password;
            return this;
        }

        public Builder setAuthCode(String authCode) {
            mAuthCode = authCode;
            return this;
        }

        public Builder setGrantType(String grantType) {
            mGrantType = grantType;
            return this;
        }

        public Builder setExpireIn(long expireIn) {
            mExpireIn = expireIn;
            return this;
        }

        public Builder setLang(int lang) {
            mLang = lang;
            return this;
        }

        public Builder setNewAccount(String newAccount) {
            mNewAccount = newAccount;
            return this;
        }

        public Authentication build() {
            return new Authentication(mAppKey, mAppSecret, mAccessToken, mRefreshToken, mAccount, mPassword, mAuthCode, mGrantType, mExpireIn, mLang, mNewAccount);
        }
    }
}
