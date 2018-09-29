package com.litong.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import com.litong.utils.spring.SpringConfigTool;

/**
 * 
 * @author litong 读取config.properties
 */
public class ConfigUtil {
  private static String configFilePath = null;
  private static Properties prop = null;
  private static InputStream ins = null;

  static {
    // 从application.properties中获取config.path的值
    configFilePath =SpringConfigTool.getPropertiesValue("config.path");
    if (configFilePath != null) {
      // 获取到值,表明使用的是外部的路径
      File configFile = new File(configFilePath);
      if (configFile.exists()) {
        // 如果文件已经存在,则读取文件
        try {
          ins = new FileInputStream(configFilePath);
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      } else {
        // 如果文件不存在,尝试使用user.dir读入
        String userDir = System.getProperty("user.dir");
        File file = new File(userDir + configFilePath);
        // 如果文件还是不存在,抛出异常
        if (file.exists()) {
          System.err.println(file.getAbsolutePath() + "文件不存在");
        }
        try {
          ins = new FileInputStream(file);
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      }
    } else {
      // 没有获取到值,读取classpath下的config.propertie
      configFilePath = "config.properties";
      ins = ConfigUtil.class.getClassLoader().getResourceAsStream(configFilePath);
    }

    // 防止读取乱码
    InputStreamReader insReader = null;
    try {
      insReader = new InputStreamReader(ins, "UTF-8");
    } catch (UnsupportedEncodingException e1) {
      e1.printStackTrace();
    }

    prop = new Properties();
    try {
      prop.load(insReader);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * get value of key
   */
  public static String getValue(String key) {
    return prop.getProperty(key);
  }

  /**
   * get properties
   * 
   * @param args
   */
  public static Properties getProperties() {
    return prop;
  }

  public static String getConfigFile() {
    return configFilePath;
  }

  public static void main(String[] args) {
    // String value = ConfigUtil.getValue("prorject_id");
    // System.out.println(value);

    Properties prop = ConfigUtil.getProperties();
    Set<Entry<Object, Object>> entrySet = prop.entrySet();
    for (Entry<Object, Object> entry : entrySet) {
      System.out.println("" + entry.getKey() + "=" + entry.getValue());
    }
  }
}