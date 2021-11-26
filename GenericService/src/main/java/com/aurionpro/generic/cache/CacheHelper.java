package com.aurionpro.generic.cache;
/*import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import net.sf.ehcache.Element;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service("cacheHelper")
public class CacheHelper {

  private final Logger logger = LoggerFactory.getLogger(getClass());
  
  @Autowired private String serviceUrl;
  @Autowired private int readTimeout;
  @Autowired private int connectTimeout;
  @Autowired private int maxRetries;
  @Autowired private HttpClient httpClient;
  
  public Element get(String cacheName, String key) throws Exception {
    String url = StringUtils.join(new String[] {
      serviceUrl, cacheName, key}, "/");
    GetMethod getMethod = new GetMethod(url);
    configureMethod(getMethod);
    ObjectInputStream oin = null;
    int status = -1;
    try {
      status = httpClient.executeMethod(getMethod);
      if (status == HttpStatus.SC_NOT_FOUND) {
        // if the content is deleted already
        return null;
      }
      InputStream in = getMethod.getResponseBodyAsStream();
      oin = new ObjectInputStream(in);
      Element element = (Element) oin.readObject();
      return element;
    } catch (IOException e) {
      logger.warn("GET Failed (" + status + ")", e);
    } finally {
      IOUtils.closeQuietly(oin);
      getMethod.releaseConnection();
    }
    return null;
  }
  
  public void put(String cacheName, String key, Serializable value) 
      throws Exception {
    Element element = new Element(key, value);
    String url = StringUtils.join(new String[] {
      serviceUrl, cacheName, key}, "/");
    PutMethod putMethod = new PutMethod(url);
    configureMethod(putMethod);
    ObjectOutputStream oos = null;
    int status = -1;
    try {
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      oos = new ObjectOutputStream(bos);
      oos.writeObject(element);
      putMethod.setRequestEntity(new InputStreamRequestEntity(
        new ByteArrayInputStream(bos.toByteArray())));
      status = httpClient.executeMethod(putMethod);
    } catch (Exception e) {
      logger.warn("PUT Failed (" + status + ")", e);
    } finally {
      IOUtils.closeQuietly(oos);
      putMethod.releaseConnection();
    }
  }
  
  public void delete(String cacheName, String key) throws Exception {
    String url = StringUtils.join(new String[] {
      serviceUrl, cacheName, key}, "/");
    DeleteMethod deleteMethod = new DeleteMethod(url);
    configureMethod(deleteMethod);
    int status = -1;
    try {
      status = httpClient.executeMethod(deleteMethod);
    } catch (Exception e) {
      logger.warn("DELETE Failed (" + status + ")", e);
    } finally {
      deleteMethod.releaseConnection();
    }
  }
  
  private void configureMethod(HttpMethod method) {
    if (readTimeout > 0) {
      method.getParams().setSoTimeout(readTimeout);
    }
    if (maxRetries > 0) {
      method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
        new DefaultHttpMethodRetryHandler(maxRetries, false));
    }
  }
}*/