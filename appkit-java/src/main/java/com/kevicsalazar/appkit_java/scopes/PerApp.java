package com.kevicsalazar.appkit_java.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApp {

}
