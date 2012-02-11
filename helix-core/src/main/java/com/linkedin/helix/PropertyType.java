package com.linkedin.helix;

import com.linkedin.helix.DataAccessor.Type;

public enum PropertyType
{
  // @formatter:off
  // CLUSTER PROPERTIES
  CONFIGS(Type.CLUSTER, true, false, false, false, true),
  LIVEINSTANCES(Type.CLUSTER, false, false, false, true, true),
  INSTANCES(Type.CLUSTER, true, false),
  IDEALSTATES(Type.CLUSTER, true, false, false, false, true),
  EXTERNALVIEW(Type.CLUSTER, true, false),
  STATEMODELDEFS(Type.CLUSTER, true, false, false, false, true),
  CONTROLLER(Type.CLUSTER, true, false),
  PROPERTYSTORE(Type.CLUSTER, true, false),
  //INSTANCE PROPERTIES
  MESSAGES(Type.INSTANCE, true, true, true),
  CURRENTSTATES(Type.INSTANCE, true,true, false, false, true),
  STATUSUPDATES(Type.INSTANCE, true, true, false),
  ERRORS(Type.INSTANCE, true, true),
  HEALTHREPORT(Type.INSTANCE, true, false,false,false, false), //last was true),
  //CONTROLLER PROPERTY
  LEADER(Type.CONTROLLER, false, false, true, true),
  HISTORY(Type.CONTROLLER, true, true, true),
  PAUSE(Type.CONTROLLER, false, false, true),
  MESSAGES_CONTROLLER(Type.CONTROLLER, true, false, true),
  STATUSUPDATES_CONTROLLER(Type.CONTROLLER, true, true, true),
  ERRORS_CONTROLLER(Type.CONTROLLER,true, true, true),
  PERSISTENTSTATS(Type.CONTROLLER, true, false, false, false),
  ALERTS(Type.CONTROLLER, true, false, false, false),
  ALERT_STATUS(Type.CONTROLLER, true, false, false, false);
  // @formatter:on

  Type type;
  boolean isPersistent;

  boolean mergeOnUpdate;

  boolean updateOnlyOnExists;

  boolean createOnlyIfAbsent;

  /**
   * "isCached" defines whether the property is cached in data accessor
   * if data is cached, then read from zk can be optimized
   */
  boolean isCached;

  private PropertyType(Type type, boolean isPersistent, boolean mergeOnUpdate)
  {
    this(type, isPersistent, mergeOnUpdate, false);
  }

	private PropertyType(Type type, boolean isPersistent,
      boolean mergeOnUpdate, boolean updateOnlyOnExists)
	{
	   this(type, isPersistent, mergeOnUpdate, false, false);
	}

	private PropertyType(Type type, boolean isPersistent,
      boolean mergeOnUpdate, boolean updateOnlyOnExists, boolean createOnlyIfAbsent)
	{
	  this(type, isPersistent, mergeOnUpdate, updateOnlyOnExists, createOnlyIfAbsent, false);
	}

	 private PropertyType(Type type, boolean isPersistent,
	                      boolean mergeOnUpdate, boolean updateOnlyOnExists, boolean createOnlyIfAbsent,
	                      boolean isCached)
  {
    this.type = type;
    this.isPersistent = isPersistent;
    this.mergeOnUpdate = mergeOnUpdate;
    this.updateOnlyOnExists = updateOnlyOnExists;
	this.createOnlyIfAbsent = createOnlyIfAbsent;
	this.isCached = isCached;
  }

  public boolean isCreateOnlyIfAbsent()
  {
    return createOnlyIfAbsent;
  }

  public void setCreateIfAbsent(boolean createIfAbsent)
  {
    this.createOnlyIfAbsent = createIfAbsent;
  }

  public Type getType()
  {
    return type;
  }

  public void setType(Type type)
  {
    this.type = type;
  }

  public boolean isPersistent()
  {
    return isPersistent;
  }

  public void setPersistent(boolean isPersistent)
  {
    this.isPersistent = isPersistent;
  }

  public boolean isMergeOnUpdate()
  {
    return mergeOnUpdate;
  }

  public void setMergeOnUpdate(boolean mergeOnUpdate)
  {
    this.mergeOnUpdate = mergeOnUpdate;
  }

  public boolean isUpdateOnlyOnExists()
  {
    return updateOnlyOnExists;
  }

  public void setUpdateOnlyOnExists(boolean updateOnlyOnExists)
  {
    this.updateOnlyOnExists = updateOnlyOnExists;
  }

  public boolean isCached()
  {
    return isCached;
  }
}
