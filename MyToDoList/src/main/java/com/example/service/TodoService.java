package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.TodoMapper;
import com.example.model.TodoModel;

@Service
public class TodoService {
	
	@Autowired
	private TodoMapper todoMapper;
	
	//マッパーからToDoをすべて取得する
	public List<TodoModel> findAll(){
		return todoMapper.findAll();
	}
	
	//新しいタスクを追加する
	public void add(TodoModel todo) {
		todoMapper.insert(todo);
	}
	
	//タスクを削除する
	public void delete(Integer id) {
		todoMapper.delete(id);
	}

}
