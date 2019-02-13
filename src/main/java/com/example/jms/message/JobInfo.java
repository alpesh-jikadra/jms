/* $RCSfile: JobInfo.java,v $ */
/* $Author: cvanwijk $ */
/* $Date: 2008-09-03 21:37:18 $ */
/* $Revision: 1.1 $ */
package com.example.jms.message;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import org.jboss.marshalling.SerializabilityChecker;


/**
 * The main information wrapped within the workflow messages.
 */
@SuppressWarnings("serial")
public class JobInfo implements Serializable {
    /*
     * Attributes to be exposed outside framework will have public
     * getters/setters
     */

    /**
     * The parameter set to be used by business Services.
     */
    private HashMap<String, Object> paramSet = new HashMap<String, Object>();

    /**
     * The addtitionalEventDataMap used to pass additional data while a event is invoked.
     */
    private HashMap<String, Object> addtitionalEventDataMap = new HashMap<String, Object>();

    /**
     * The addtitionalTaskDataMap used to pass additional data by business services.
     */
    private HashMap<String, Object> addtitionalTaskDataMap = new HashMap<String, Object>();
    /**
     * Location/Carpark specific job type / event type.
     */
    private String jobTypeCd;

    /**
     * Lock level for the Job.
     */
    private String lockLevel;

    /**
     * The Leve0 identifier.
     */
    private String level0Id;

    /**
     * The Leve1 identifier.
     */
    private String level1Id;

    /**
     * The Leve2 identifier.
     */
    private String level2Id;

    /**
     * The taskMapCriteria0 identifier.
     */
    private String taskMapCrit0Id;

    /**
     * The taskMapCriteria1 identifier.
     */
    private String taskMapCrit1Id;

    /**
     * The taskMapCriteria2 identifier.
     */
    private String taskMapCrit2Id;

    /**
     * The Priority of the job.
     */
    private int jobPriority;

    /**
     * The identifier for the agent invoking the workflow process. If a manual
     * trigger, like click of a button, invokes the process then this field will
     * contain the user id, otherwise it will be SYSTEM
     */
    private String invokingAgent;

    /**
     * Name of the file (if any) associated with the workflow process.
     */
    private String fileName;

    /**
     * Decides whether the Job is of normal flow or restart/cleanup flow.
     */
    private String jobFlwCd;

    /**
     * Decides whether the User will Receive a mail or not.
     */
    private String notifReqdInd;

    /**
     * The email id where the mail will be posted.
     */
    private String userEmailId;

    /**
     * The Type of the Email to be Sent. in workflow this is either SUC/FAL case.
     */
    private String emailType;

    // Attributes to be used within framework will have package protected
    // getters/setters

    /**
     * The Job Monitor Identifier.
     */
    private Integer jobMontrPk;

    /**
     * Blocking job Identifier.
     */
    private Integer blockedByJob;

    /**
     * Total number of tasks for this job.
     */
    private int totalTaskSize;

    /**
     * The Source node where the job is triggered from.
     */
    private String srcNode;

    /**
     * Call back message indicator.
     */
    private boolean isCallBack;

    /**
     * The target Datasource to be used by Invoker. This defines the DataSource
     * where Business service will run.
     */
    private String targetDataSourceName;
    
    /**
     * Time at which this job was Queued
     */
    private Date queueTime;
    
    /**
     * Event Type Code for this job
     */
    private String eventTypeCd;

    /**
     * Job Task Mapping Storage.
     */
    private TreeMap<Integer, HashMap<String, String>> taskRoutingMap = new TreeMap<Integer, HashMap<String, String>>();

    /**
     * The Completed task Storage.
     */
    private TreeMap<Integer, HashMap<String, String>> completedTaskMap = new TreeMap<Integer, HashMap<String, String>>();

    /**
     * The Failed Task Storage.
     */
    private TreeMap<Integer, HashMap<String, String>> failedTaskMap = new TreeMap<Integer, HashMap<String, String>>();

    /**
     * Where the request will be posted.
     */
    private String queue = "";

    private String jobStatus;
    
    private Set<String> clusters=new HashSet<>();
    
    private String prevMessageId;
    /**
	 * @return the jobStatus
	 */
	public String getJobStatus() {
		return jobStatus;
	}

	/**
	 * @param jobStatus the jobStatus to set
	 */
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	private Date messageSendTime;
	/**
     * The Default Constructor.
     */
    public JobInfo() {
    }
    

    /**
     * Constructor - Used from JobMontr Dao.
     * @param lockLevel The Locklevel for the Job.
     * @param level0Id The level0 id For the Job.
     * @param level1Id The level1 id For the Job.
     * @param level2Id The level2 id For the Job.
     * @param jobMontrPk The job Monitor Pk For the Job.
     * @param jobTypeCd The Event Type For the Job.
     * @param blkByPk The PK by which this job is blocked
     */
    public JobInfo(final String lockLevel, final String level0Id,
        final String level1Id, final String level2Id, final int jobMontrPk,
        final String jobTypeCd, final Integer blkByPk) {
        super();
        this.lockLevel = lockLevel;
        this.level0Id = level0Id;
        this.level1Id = level1Id;
        this.level2Id = level2Id;
        this.jobMontrPk = jobMontrPk;
        this.jobTypeCd = jobTypeCd;
        this.blockedByJob = blkByPk;
    }

    /**
     * @return queue
     */
    public final String getQueue() {
        return queue;
    }

    /**
     * @param queue  the queue to set.
     */
    public final void setQueue(final String queue) {
        this.queue = queue;
    }

    // ====================== Start Public attributes
    // =============================
    /**
     * @return Returns the jobTypeCd.
     */
    public final String getJobTypeCd() {
        return jobTypeCd;
    }

    /**
     * @param jobTypeCd
     *            The jobTypeCd to set.
     */
    public final void setJobTypeCd(final String jobTypeCd) {
        this.jobTypeCd = jobTypeCd;
    }

    /**
     * @return Returns the lockLevel.
     */
    public final String getLockLevel() {
        return lockLevel;
    }

    /**
     * @param lockLevel
     *            The lockLevel to set.
     */
    public final void setLockLevel(final String lockLevel) {
        this.lockLevel = lockLevel;
    }

    /**
     * @return Returns the Level0 ID
     */
    public final String getLevel0Id() {
        return level0Id;
    }

    /**
     * @param level0Id
     *            The Level0 ID to set
     */
    public final void setLevel0Id(final String level0Id) {
        this.level0Id = level0Id;
    }

    /**
     * @return Returns the Level1 ID
     */
    public final String getLevel1Id() {
        return level1Id;
    }

    /**
     * @param level1Id
     *            The Level1 ID to set
     */
    public final void setLevel1Id(final String level1Id) {
        this.level1Id = level1Id;
    }

    /**
     * @return Returns the Level2 ID
     */
    public final String getLevel2Id() {
        return level2Id;
    }

    /**
     * @param level2Id
     *            The Level2 ID to set
     */
    public final void setLevel2Id(final String level2Id) {
        this.level2Id = level2Id;
    }

    /**
     * @return Returns the TaskMapCrit0Id
     */
    public final String getTaskMapCrit0Id() {
        return taskMapCrit0Id;
    }

    /**
     * @param taskMapCrit0Id
     *            The taskMap criteria0 ID to set
     */
    public final void setTaskMapCrit0Id(final String taskMapCrit0Id) {
        this.taskMapCrit0Id = taskMapCrit0Id;
    }

    /**
     * @return Returns the TaskMapCrit1Id
     */
    public final String getTaskMapCrit1Id() {
        return taskMapCrit1Id;
    }

    /**
     * @param taskMapCrit1Id
     *            The taskMap criteria1 ID to set
     */
    public final void setTaskMapCrit1Id(final String taskMapCrit1Id) {
        this.taskMapCrit1Id = taskMapCrit1Id;
    }

    /**
     * @return Returns the invoking agent
     */
    public final String getInvokingAgent() {
        return invokingAgent;
    }

    /**
     * @param invokingAgent
     *            The invoking agent to set
     */
    public final void setInvokingAgent(final String invokingAgent) {
        this.invokingAgent = invokingAgent;
    }

    /**
     * @return Returns the priority.
     */
    public final int getJobPriority() {
        return jobPriority;
    }

    /**
     * @param jobPriority
     *            The priority to set
     */
    public final void setJobPriority(final int jobPriority) {
        this.jobPriority = jobPriority;
    }

    /**
     * @return Returns the fileName.
     */
    public final String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     *            The fileName to set.
     */
    public final void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return taskMapCrit2Id
     */
    public final String getTaskMapCrit2Id() {
        return taskMapCrit2Id;
    }

    /**
     * sets taskMapCrit2Id.
     *
     * @param taskMapCrit2Id The taskMapCrit2Id to set.
     */
    public final void setTaskMapCrit2Id(final String taskMapCrit2Id) {
        this.taskMapCrit2Id = taskMapCrit2Id;
    }

    /**
     * @return Returns the jobFlwCd.
     */
    public final String getJobFlwCd() {
        return jobFlwCd;
    }

    /**
     * @param jobFlwCd
     *            The jobFlwCd to set.
     */
    public final void setJobFlwCd(final String jobFlwCd) {
        this.jobFlwCd = jobFlwCd;
    }

    // ====================== End Public attributes
    // =============================

    // ====================== Start Protected attributes
    // ==========================
    /**
     * @return Returns the taskRoutingMap.
     */
    public final TreeMap<Integer, HashMap<String, String>> getTaskRoutingMap() {
        return taskRoutingMap;
    }

    /**
     * @param taskRoutingMap
     *            The taskRoutingMap to set.
     */
    public final void setTaskRoutingMap(
        final TreeMap<Integer, HashMap<String, String>> taskRoutingMap) {
        this.taskRoutingMap = taskRoutingMap;
    }

    /**
     * @return Returns the completedTaskMap.
     */
    public final TreeMap<Integer, HashMap<String, String>> getCompletedTaskMap() {
        return completedTaskMap;
    }

    /**
     * @param completedTaskMap
     *            The completedTaskMap to set.
     */
    public final void setCompletedTaskMap(
        final TreeMap<Integer, HashMap<String, String>> completedTaskMap) {
        this.completedTaskMap = completedTaskMap;
    }

    /**
     * @return Returns the failedTaskMap.
     */
    public final TreeMap<Integer, HashMap<String, String>> getFailedTaskMap() {
        return failedTaskMap;
    }

    /**
     * @param failedTaskMap
     *            The failedTaskMap to set.
     */
    public final void setFailedTaskMap(
        final TreeMap<Integer, HashMap<String, String>> failedTaskMap) {
        this.failedTaskMap = failedTaskMap;
    }

    /**
     * @return Returns the callBack.
     */
    public final boolean isCallBack() {
        return isCallBack;
    }

    /**
     * @param callBack
     *            The callBack to set.
     */
    public final void setCallBack(final boolean callBack) {
        this.isCallBack = callBack;
    }

    @Override
	public String toString() {
		return "JobInfo [paramSet=" + paramSet + ", addtitionalEventDataMap="
				+ addtitionalEventDataMap + ", addtitionalTaskDataMap="
				+ addtitionalTaskDataMap + ", jobTypeCd=" + jobTypeCd
				+ ", lockLevel=" + lockLevel + ", level0Id=" + level0Id
				+ ", level1Id=" + level1Id + ", level2Id=" + level2Id
				+ ", taskMapCrit0Id=" + taskMapCrit0Id + ", taskMapCrit1Id="
				+ taskMapCrit1Id + ", taskMapCrit2Id=" + taskMapCrit2Id
				+ ", jobPriority=" + jobPriority + ", invokingAgent="
				+ invokingAgent + ", fileName=" + fileName + ", jobFlwCd="
				+ jobFlwCd + ", notifReqdInd=" + notifReqdInd
				+ ", userEmailId=" + userEmailId + ", emailType=" + emailType
				+ ", jobMontrPk=" + jobMontrPk + ", blockedByJob="
				+ blockedByJob + ", totalTaskSize=" + totalTaskSize
				+ ", srcNode=" + srcNode + ", isCallBack=" + isCallBack
				+ ", targetDataSourceName=" + targetDataSourceName
				+ ", queueTime=" + queueTime + ", eventTypeCd=" + eventTypeCd
				+ ", taskRoutingMap=" + taskRoutingMap + ", completedTaskMap="
				+ completedTaskMap + ", failedTaskMap=" + failedTaskMap
				+ ", queue=" + queue + ", jobStatus=" + jobStatus
				+ ", messageSendTime=" + messageSendTime + "]";
	}

    /**
     * @return Returns the totalTaskSize.
     */
    public final int getTotalTaskSize() {
        return totalTaskSize;
    }

    /**
     * @param totalTaskSize
     *            The totalTaskSize to set.
     */
    public final void setTotalTaskSize(final int totalTaskSize) {
        this.totalTaskSize = totalTaskSize;
    }

    /**
     * @return srcNode
     */
    public final String getSrcNode() {
        return srcNode;
    }

    /**
     * @param srcNode
     *            the srcNode to set
     */
    public final void setSrcNode(final String srcNode) {
        this.srcNode = srcNode;
    }

    /**
     * Gets blocked by job id.
     *
     * @return blocked by job id.
     */
    public final Integer getBlockedByJob() {
        return blockedByJob;
    }

    /**
     * Sets blocked by job id.
     *
     * @param blockedByJob The blockedByJob to set.
     */
    public final void setBlockedByJob(final Integer blockedByJob) {
        this.blockedByJob = blockedByJob;
    }

    /**
     * @return Returns the JobMonitorPk
     */
    public final Integer getJobMontrPk() {
        return jobMontrPk;
    }

    /**
     * The Setter for Job monitor pk.
     * @param jobMontrPk
     *            The JobMonitorPk to set
     */
    // ====================== End Protected attributes
    // ==========================

    /**
     * @return Returns the targetDataSourceName.
     */
    public final String getTargetDataSourceName() {
        return targetDataSourceName;
    }

    /**
     * @param targetDataSourceName
     *            The targetDataSourceName to set.
     */
    public final void setTargetDataSourceName(final String targetDataSourceName) {
        this.targetDataSourceName = targetDataSourceName;
    }

    /**
     * @param jobMontrPk
     *            The jobMontrPk to set.
     */
    public final void setJobMontrPk(final Integer jobMontrPk) {
        this.jobMontrPk = jobMontrPk;
    }

    /**
     * @return Returns the paramSet.
     */
    public final HashMap<String, Object> getParamSet() {
        return paramSet;
    }

    /**
     * @param paramSet
     *            The paramSet to set.
     */
    public final void setParamSet(final HashMap<String, Object> paramSet) {
        this.paramSet = paramSet;
    }

    /**
     * @return Returns the notifReqdInd.
     */
    public String getNotifReqdInd() {
        return notifReqdInd;
    }

    /**
     * @param notifReqdInd The notifReqdInd to set.
     */
    public void setNotifReqdInd(final String notifReqdInd) {
        this.notifReqdInd = notifReqdInd;
    }

    /**
     * @return Returns the userEmailId.
     */
    public String getUserEmailId() {
        return userEmailId;
    }

    /**
     * @param userEmailId The userEmailId to set.
     */
    public void setUserEmailId(final String userEmailId) {
        this.userEmailId = userEmailId;
    }

    /**
     * @return Returns the emailType.
     */
    public String getEmailType() {
        return emailType;
    }

    /**
     * @param emailType The emailType to set.
     */
    public void setEmailType(final String emailType) {
        this.emailType = emailType;
    }

    /**
     * LOCK LEVEL Unifier Enumeration.
     *
     */
    public enum LockLevel {
        /**
             * The Level0 Lock Level.
             */
        LEVEL0,
        /**
             * The Level0 Lock Level.
             */
        LEVEL1,
        /**
             * The Level0 Lock Level.
             */
        LEVEL2;
    }

	/**
	 * @return Returns the eventTypeCd.
	 */
	public String getEventTypeCd() {
		return eventTypeCd;
	}

	/**
	 * @param eventTypeCd The eventTypeCd to set.
	 */
	public void setEventTypeCd(String eventTypeCd) {
		this.eventTypeCd = eventTypeCd;
	}

	/**
	 * @return Returns the queueTime.
	 */
	public Date getQueueTime() {
		return queueTime;
	}

	/**
	 * @param queueTime The queueTime to set.
	 */
	public void setQueueTime(Date queueTime) {
		this.queueTime = queueTime;
	}
 
    /**
     * @return Returns the addtitionalEventDataMap.
     */	
	public HashMap<String, Object> getAddtitionalEventDataMap() {
		return addtitionalEventDataMap;
	}

    /**
     * @param addtitionalEventDataMap The addtitionalJobDataMap to set.
     */		
	public void setAddtitionalEventDataMap(
			HashMap<String, Object> addtitionalEventDataMap) {
		this.addtitionalEventDataMap = addtitionalEventDataMap;
	}
	
    /**
     * @return Returns the addtitionalTaskDataMap.
     */
	public HashMap<String, Object> getAddtitionalTaskDataMap() {
		return addtitionalTaskDataMap;
	}

    /**
     * @param addtitionalTaskDataMap The addtitionalTaskDataMap to set.
     */		
	public void setAddtitionalTaskDataMap(
			HashMap<String, Object> addtitionalTaskDataMap) {
		this.addtitionalTaskDataMap = addtitionalTaskDataMap;
	}

	public Date getMessageSendTime() {
		return messageSendTime;
	}

	public void setMessageSendTime(Date messageSendTime) {
		this.messageSendTime = messageSendTime;
	}

	public Set<String> getClusters() {
		return clusters;
	}

	public void setClusters(Set<String> clusters) {
		this.clusters = clusters;
	}

	public String getPrevMessageId() {
		return prevMessageId;
	}

	public void setPrevMessageId(String prevMessageId) {
		this.prevMessageId = prevMessageId;
	}
	
	
	
}