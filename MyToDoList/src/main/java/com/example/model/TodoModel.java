package com.example.model;

import java.util.Date;

//TodoModelクラスは、ToDoアイテムのデータモデルを表します。
//このクラスの各フィールド（変数）は、それぞれデータベースのカラム（列）に対応しています。

public class TodoModel {
	private Integer id;
	private String task;
	private Boolean deletedFlag;
	private Date createAt;
	
	//各変数のゲッターとセッターを定義
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTask() {
		return task;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	public Boolean getDeletedFlag() {
		return deletedFlag;
	}
	
	public void setDeletedFlag(Boolean deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

}
