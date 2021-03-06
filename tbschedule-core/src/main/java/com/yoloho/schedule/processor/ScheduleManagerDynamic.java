package com.yoloho.schedule.processor;

import java.util.List;

import com.yoloho.schedule.ScheduleManagerFactory;
import com.yoloho.schedule.types.TaskItem;

public class ScheduleManagerDynamic extends AbstractScheduleManager {
	//private static transient Log log = LogFactory.getLog(TBScheduleManagerDynamic.class);

    ScheduleManagerDynamic(ScheduleManagerFactory factory, String taskName, String ownSign, int managerPort,
            String jxmUrl) throws Exception {
        super(factory, taskName, ownSign);
    }

    @Override
    public void initial() throws Exception {
        if (isLeader()) {
            // 是第一次启动，检查对应的数据
            factory.getStorage().emptyTaskItems(this.currentServer().getTaskName(),
                    this.currentServer().getOwnSign());
        }
        computerStart();
    }

    @Override
    public void refreshScheduleServerInfo() throws Exception {
        throw new Exception("没有实现");
    }

    @Override
    public List<TaskItem> getCurrentScheduleTaskItemList() {
        throw new RuntimeException("没有实现");
    }

    @Override
    public int getTaskItemCount() {
        throw new RuntimeException("没有实现");
    }
}
