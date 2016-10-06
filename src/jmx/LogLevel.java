package jmx;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.LoggerConfig;

import filter.ExecutionModeFilter;

public class LogLevel {

 public Level getMode() {
  return LogManager.getRootLogger().getLevel();
 }

 public void changeMode(Boolean mode) {
	 // LogManager.getRootLogger().set
 }

}