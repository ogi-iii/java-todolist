# toDoListProject
## 使用した技術要素
言語： Java  
フレームワーク： SpringBoot(Gradle)  
→ Web, JPA, Thymeleaf, DevTools, MySQL 使用  
## 全体の設計・構成
### Javaファイル  
- ToDo.java : ToDoクラス(MySQLと関連)
- ToDoController.java : 画面遷移, ToDo作成・変更・検索など
- ToDoListProjectApplication.java : SpringBootプロジェクト全体の起動/停止ファイル
- ToDoSample.java : ToDoクラス(MySQLと非関連) *未使用
- ToDoRepository.java : MySQLへの動作(save, findなど)ファイル *未使用
- ToDoService.java : ToDoRepository.javaの操作クラス *未使用  
### htmlファイル
- top.html : トップ画面(ToDoの表示、ToDo追加、ToDoの状態変更)
- edit.html : ToDo編集画面(ToDoの表示、編集)
- search.html : 検索画面(ToDoの検索)
## 開発環境のセットアップ手順
toDoListProject/src/main/resources/配下のapplication.propertiesを実行環境に合わせて変更してください。
```text:application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/tododb #使用するMySQLテーブルを指定
spring.datasource.username=kazuki #MySQLのユーザーを指定
spring.datasource.password=ogiwara #MySQLのユーザーアクセス用パスワードを指定
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.database=MYSQL
spring.jpa.hibernate.ddl-auto=none
spring.thymeleaf.mode=HTML
```
## 進捗状況
### できているところ
仕様書に記載されていた機能および各画面の実装は完了しています。  
### できていないところ
MySQLのテーブルにToDoの状態データを記録して動作させようと試みたのですが、MySQLの使い方がわからずエラーから脱することができなかったため今回はMySQLを使用しない形で作成しました。  
*そのため現状では再起動するごとにToDoが初期化されます。
## 動作確認
heroku上で実行できるようにデプロイしました。  
<https://java-todolist.herokuapp.com>

