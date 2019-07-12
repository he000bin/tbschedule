package com.yoloho.schedule.types;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;
import com.yoloho.schedule.util.TaskItemUtil;

/**
 * Task
 * 
 * @author xuannan
 * 
 * Restructured by 
 * @author jason
 *
 */
public class Task implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    /**
     * 向配置中心更新心跳信息的频率
     */
    private long heartBeatRate = 5*1000;//1分钟
    
    /**
     * 判断一个服务器死亡的周期。为了安全，至少是心跳周期的两倍以上
     */
    private long judgeDeadInterval = 1*60*1000;//2分钟
    
    /**
     * 当没有数据的时候，休眠的时间
     * 
     */
    private int sleepTimeNoData = 500;
    
    /**
     * 在每次数据处理晚后休眠的时间
     */
    private int sleepTimeInterval = 0;
    
    /**
     * 每次获取数据的数量
     */
    private int fetchDataNumber = 500;
    
    /**
     * 在批处理的时候，每次处理的数据量
     */
    private int executeNumber =1;
    
    private int threadNumber = 5;
    
    /**
     * 调度器类型
     */
    private String processorType="SLEEP" ;
    /**
     * 允许执行的开始时间
     */
    private String permitRunStartTime;
    /**
     * 允许执行的开始时间
     */
    private String permitRunEndTime;
    
    /**
     * 清除过期环境信息的时间间隔,以天为单位
     */
    private double expireOwnSignInterval = 1;
    
    /**
     * 处理任务的BeanName
     */
    private String dealBeanName;
    /**
     * 任务bean的参数，由用户自定义格式的字符串
     */
    private String taskParameter;
    
    //任务类型：静态static,动态dynamic
    private String taskKind = TASKKIND_STATIC;
    
    public static String TASKKIND_STATIC="static";
    public static String TASKKIND_DYNAMIC="dynamic";
 
    
    /**
     * 任务项数组
     */
    private String[] taskItems;
    
    /**
     * 每个线程组能处理的最大任务项目书目
     */
    private int maxTaskItemsOfOneThreadGroup = 0;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getHeartBeatRate() {
		return heartBeatRate;
	}
	public void setHeartBeatRate(long heartBeatRate) {
		this.heartBeatRate = heartBeatRate;
	}

	public long getJudgeDeadInterval() {
		return judgeDeadInterval;
	}

	public void setJudgeDeadInterval(long judgeDeadInterval) {
		this.judgeDeadInterval = judgeDeadInterval;
	}

	public int getFetchDataNumber() {
		return fetchDataNumber;
	}

	public void setFetchDataNumber(int fetchDataNumber) {
		this.fetchDataNumber = fetchDataNumber;
	}

	public int getExecuteNumber() {
		return executeNumber;
	}

	public void setExecuteNumber(int executeNumber) {
		this.executeNumber = executeNumber;
	}

	public int getSleepTimeNoData() {
		return sleepTimeNoData;
	}

	public void setSleepTimeNoData(int sleepTimeNoData) {
		this.sleepTimeNoData = sleepTimeNoData;
	}

	public int getSleepTimeInterval() {
		return sleepTimeInterval;
	}

	public void setSleepTimeInterval(int sleepTimeInterval) {
		this.sleepTimeInterval = sleepTimeInterval;
	}

	public int getThreadNumber() {
		return threadNumber;
	}

	public void setThreadNumber(int threadNumber) {
		this.threadNumber = threadNumber;
	}

	public String getPermitRunStartTime() {
		return permitRunStartTime;
	}

	public String getProcessorType() {
		return processorType;
	}

	public void setProcessorType(String processorType) {
		this.processorType = processorType;
    }

    public void setPermitRunStartTime(String permitRunStartTime) {
        this.permitRunStartTime = permitRunStartTime;
        if (this.permitRunStartTime != null && this.permitRunStartTime.trim().length() == 0) {
            this.permitRunStartTime = null;
        }
    }

    public String getPermitRunEndTime() {
        return permitRunEndTime;
    }

    public double getExpireOwnSignInterval() {
        return expireOwnSignInterval;
    }

    public void setExpireOwnSignInterval(double expireOwnSignInterval) {
        this.expireOwnSignInterval = expireOwnSignInterval;
    }

    public String getDealBeanName() {
        return dealBeanName;
    }

    public void setDealBeanName(String dealBeanName) {
        this.dealBeanName = dealBeanName;
    }

    public void setPermitRunEndTime(String permitRunEndTime) {
        this.permitRunEndTime = permitRunEndTime;
        if (this.permitRunEndTime != null && this.permitRunEndTime.trim().length() == 0) {
            this.permitRunEndTime = null;
        }

    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void setTaskItems(String[] aTaskItems) {
        this.taskItems = aTaskItems;
    }

    public String[] getTaskItems() {
        return taskItems;
    }
    
    @JSONField(serialize = false)
    public TaskItem[] getTaskItemList() {
        return TaskItemUtil.parseItems(taskItems);
    }

    public void setTaskKind(String taskKind) {
        this.taskKind = taskKind;
    }

    public String getTaskKind() {
        return taskKind;
    }

    public void setTaskParameter(String taskParameter) {
        this.taskParameter = taskParameter;
    }

    public String getTaskParameter() {
        return taskParameter;
    }

    public int getMaxTaskItemsOfOneThreadGroup() {
        return maxTaskItemsOfOneThreadGroup;
    }

    public void setMaxTaskItemsOfOneThreadGroup(int maxTaskItemsOfOneThreadGroup) {
        this.maxTaskItemsOfOneThreadGroup = maxTaskItemsOfOneThreadGroup;
    }
	
}
