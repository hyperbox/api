/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Maxime Dor
 * 
 * http://kamax.io/hbox/
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.hbox.comm.out;

import io.kamax.hbox.comm.out.security.UserOut;
import io.kamax.hbox.constant.EntityType;
import io.kamax.hbox.states.TaskState;
import java.util.Date;

public class TaskOut extends ObjectOut {

   private String serverId;
   private String actionId;
   private String requestId;
   private UserOut uOut;

   private TaskState state;

   private Date createTime;
   private Date queueTime;
   private Date startTime;
   private Date endTime;
   private ExceptionOut error;

   @SuppressWarnings("unused")
   private TaskOut() {
      // used for (de)serialisation
   }

   public TaskOut(String serverId, String taskId) {
      super(EntityType.Task, taskId);
      this.serverId = serverId;
   }

   public TaskOut(String serverId, String taskId, String actionId, String requestId, TaskState state, UserOut uOut, Date createTime,
         Date queueTime,
         Date startTime, Date endTime, ExceptionOut error) {
      this(serverId, taskId);
      this.actionId = actionId;
      this.requestId = requestId;
      this.state = state;
      this.uOut = uOut;
      this.createTime = createTime;
      this.queueTime = queueTime;
      this.startTime = startTime;
      this.endTime = endTime;
      this.error = error;
   }

   public String getServerId() {
      return serverId;
   }

   public UserOut getUser() {
      return uOut;
   }

   public TaskState getState() {
      return state;
   }

   public String getActionId() {
      return actionId;
   }

   public String getRequestId() {
      return requestId;
   }

   public Date getCreateTime() {
      return createTime;
   }

   public Date getQueueTime() {
      return queueTime;
   }

   public Date getStartTime() {
      return startTime;
   }

   public Date getStopTime() {
      return endTime;
   }

   public ExceptionOut getError() {
      return error;
   }

}
