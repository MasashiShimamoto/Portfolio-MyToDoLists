package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.TodoModel;
import com.example.service.TodoService;

// @Controller アノテーションは、このクラスがコントローラーの役割を果たすことをSpringに示します。
@Controller
public class TodoController {
	
	//AUtowiredアノテーションにより、Springが自動的にTodoServiceのインスタンスをこのフィールドに注入する
	@Autowired
	private TodoService todoService;;

    // @GetMapping アノテーションは、特定のHTTP GETリクエストをこのメソッドにマッピングします。
    // この場合、ルートURL("/")にアクセスされた時にこのメソッドが呼び出されます。
    @GetMapping("/")
    public String home(Model model) {
        // ログ出力
    	System.out.println("★★アクセスがあった場合コンソールに出ます★★");
        
    	//リストを作成しThymeleaf側へ表示する要素として追加
    	/*List<String> todos = new ArrayList<>();
    	todos.add("犬の散歩");
    	todos.add("映画を見る");
    	todos.add("たくさん寝る");*/
    	
    	//TodoServiceを使用して、データベースからすべてのToDoアイテムを取得する
    	List<TodoModel> todos = todoService.findAll();
    	
    	//取得したToDoアイテムをビューに渡す
    	model.addAttribute("todos",todos);
    	
        // "home"ビュー(通常はhome.html)を返して、ブラウザに表示させます。
        return "home";
    }
    
    @PostMapping("/add")
    //`PostMapingアノテーションは。特定のHTTP POSTリクエストをこのメソッドにマッピングします。
    //この場合、".add"に対するPOSTリクエストでこのメソッドは呼び出されます。
    
    public String addTodo(TodoModel todo) {
    /*public String addTodo(@RequestParam("task") String task) {
    	//フォームから送信されたToDoタスクをコンソールパネルに表示します。
    	System.out.println("追加されたToDo: " + task);*/
    	
    	//ログ出力
    	System.out.println("★★★POSTを受け取りました：" + todo.getTask());
    	//フォームから受け取ったToDoアイテムをデータベースに挿入します
    	todoService.add(todo);
    
        // ルートURL("/")にリダイレクトします。
        return "redirect:/";
    }
    
    //ToDoアイテムの削除を行うエンドポイント
    @GetMapping("delete/{id}")
    public String deleteTodo(@PathVariable("id") Integer id) {
    	try {
    		todoService.delete(id);
    		//削除後にホームページにリダイレクト
    		return "redirect:/";
    	} catch(Exception e) {
    		//エラー処理（必要に応じてエラーメッセージを表示）
    		return "redirect:/error";
    	}
    }
}
