package com.cvte.protal.sdk.exception;

/**
 * Package : com.cvte.protal.sdk.exception
 * Author : jacob
 * Date : 14-12-2
 * Description : 这个类是用来xxx
 */
public class MissingManifestConfigException extends RuntimeException {
    public MissingManifestConfigException() {
        super("Missing Manifest Config Exception");
    }

    public MissingManifestConfigException(String exception) {
        super(exception);
    }
}

