//DOMContentLoadedイベントは、ページのDOM(Document Object Model)が完全に読み込まれて解析された後に発生します、
//このイベントが発生したときに、指定した関数を実行します。
document.addEventListener("DOMContentLoaded", function(){
	
	//document.querySelectorを使用して、名前が'task'のinput要素をページから検索し、それをinputField変数に格納します。
	const inputField = document.querySelector('input[name="task"]');
	
	//inputイベントは、input要素に入力があるたびに発生します。
	//このイベントが発生したときに、指定した関数を実行します。
	inputField.addEventListener('input', function(){
		
		//this.valueはinput要素に入力された現在の値です。
		//文字数が30文字を超えた場合に警告を表示し、30文字に制限します。
		if(this.value.length > 30){
			
			//ユーザに警告メッセージを表示します。
			alert('タスクは30文字以内で入力してください。');
			
			//文字列のsliceメソッドを使用して、値を最初の30文字に制限します。
			this.value = this.value.slice(0,30);
		}
		
		
	})
});