package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.TodoModel;

//TodoMapperインターフェースは、ToDoアプリケーションのデータベース操作を定義します。
//MyBatisは、このインターフェースのメソッドとSQLクエリをマッピングして、データベース操作を実行します。
public interface TodoMapper {
	//すべてのToDoアイテムをデータベースから取得するためのメソッドです。
	@Select("SELECT * FROM todoapp")
	List<TodoModel> findAll();
	
	//特定のIDを持つToDoアイテムをデータベースから取得するためのメソッドです。
	@Select("SELECT * FROM todoapp WHERE id = #{id}")
	TodoModel findById(Integer id);
	
	//新しいToDoアイテムをデータベースに挿入するためのメソッドです。
	//#{task}は、TodoModelオブジェクトのフィールドに対応しています。
	@Insert("INSERT INTO todoapp(task, deleted_flag) VALUES(#{task}, false)")
	void insert(TodoModel todo);
	
	//既存のアイテムを更新するメソッド
	//#{id}, #{task}, #{deletedFlag}, #{createAt}は、TodoModelオブジェクトのフィールドに対応している
	@Update("UPDATE todoapp SET task = #{task}, deleted_flag = #{deletedFlag}, creat_at = #{createAt} WHERE id = #{id}")
	void update(TodoModel todo);
	
	//特定のIDを持つアイテムを削除するメソッド
	@Delete("DELETE FROM todoapp WHERE id = #{id}")
	void delete(Integer id);
}
