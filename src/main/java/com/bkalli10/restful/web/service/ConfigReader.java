package com.bkalli10.restful.web.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ConfigReader {

  final static Logger logger = Logger.getLogger(ConfigReader.class);

  private static String configFile = "web.properties";
  private static Properties props = new Properties();

  static {
    try {
      InputStream configInStream =
          ConfigReader.class.getClassLoader().getResourceAsStream(configFile);
      props.load(configInStream);

      logger.info("Config Variables Defined in Config File:");
      logger.info(String.format("course.data.file: %s", getProperty("course.data.file")));

      // log all properties
      props.forEach((key, value) -> {
        logger.info(String.format("%s: %s)", key, value));
      });
    } catch (FileNotFoundException ex) {
      logger.error(String.format("Config file: %s is not found.", configFile), ex);
    } catch (IOException ex) {
      logger.error(String.format("Error reading config file: %s.", configFile), ex);
    }
  }

  public static String getProperty(String propKey) {
    if (propKey != null && propKey.trim().length() > 0)
      return props.getProperty(propKey);
    return null;
  }

  public static int getPropertyAsInt(String propKey) {
    String value = getProperty(propKey);
    if (value != null && value.trim().length() > 0)
      return Integer.parseInt(value);
    return -1;
  }

  public static boolean getPropertyAsBool(String propKey) {
    String value = getProperty(propKey);
    if (value != null && value.trim().length() > 0)
      return Boolean.parseBoolean(value);
    return false;
  }

  public static List<String> getPropertyAsList(String propKey) {
    String propertyValue = getProperty(propKey);
    if (propertyValue != null) {
      return Arrays.asList(propertyValue.split(","));
    }
    return null;
  }
}
