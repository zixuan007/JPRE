package net.mamoe.jpre.event.qq;

import net.mamoe.jpre.QQ;
import net.mamoe.jpre.RobotQQ;
import net.mamoe.jpre.event.HandlerList;

/**
 * 好友"正在输入"
 * "正在输入": 使用电脑 QQ, 对方正在打字时聊天窗口顶部对方名字旁边会显示 "正在输入".
 *
 * @author Him188 @ JPRE Project
 */
public class FriendTypingEvent extends QQEvent {
	private static final HandlerList handlers = new HandlerList();

	public static HandlerList getHandlers() {
		return handlers;
	}


	public FriendTypingEvent(RobotQQ robot, QQ qq) {
		super(robot, qq);
	}
}
