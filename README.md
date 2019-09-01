# java-todolist (※ 9月1日 追記)
## フォルダ説明
toDoListProject: 8月上旬に作成したもの  
toDoListProjectUpdated: 前回のtoDoListProjectに修正を加えたもの (※ 9月1日 更新)  
## ※ 以下, toDoListProjectUpdatedに関する情報です。
## 使用した技術要素
言語： Java (version: 11.0.2)  
フレームワーク： SpringBoot(Maven)  
→ Web, JPA, Thymeleaf, DevTools, Lombok, H2(*MySQLの代用) 使用  
## 全体の設計・構成
### Javaファイル  
- ToDo.java : ToDoクラス(データの生成・getter/setter)
- ToDoRepository.java : H2データベースへの動作ファイル(save, findAll, deleteなど)
- ToDoService.java : ToDoRepository.javaの操作クラス
- ToDoController.java : 画面遷移, ToDo作成・変更・削除・検索など
- ToDoListProjectApplication.java : SpringBootプロジェクト全体の起動/停止ファイル  
### htmlファイル
- top.html : トップ画面(ToDoの表示, ToDo追加, ToDoの状態変更)
- edit.html : ToDo編集画面(ToDoの表示, 編集, 削除)
- search.html : 検索画面(ToDoの検索)
## 開発環境のセットアップ手順
H2データベースを使用しているため, 環境設定は特に必要ありません。
## 前回までの進捗状況
### できているところ
仕様書に記載されていた機能および各画面の実装は完了しています。  
### できていないところ
MySQLのテーブルにToDoの状態データを記録して動作させようと試みたのですが, MySQLの使い方がわからずエラーから脱することができなかったため今回はMySQLを使用しない形で作成しました。  
*そのため現状では再起動するごとにToDoが初期化されます。  
## 現在の進捗状況 (※ 9月1日 時点)
### 修正できたところ
これまでの機能に加えて, 編集画面でtodoの削除ができるようにしました。  
またH2データベースを使用して, 再起動しても初期化せず, todoを保存できるようにしました。
### まだ修正できていないところ
MySQLの使い方が未だに理解できていないため, 今回は代替策としてH2データベースを使用しました。
## 動作確認
heroku上で実行できるようにデプロイしてあります。  
<https://java-todolist.herokuapp.com>  
*推奨ブラウザ: Google Chrome  
### ※ 9月1日 追記   
herokuでH2データベースを使用する方法が分からなかったため, heroku上にデプロイしてあるwebアプリは前作(toDoListProject)のまま修正を加えていません。そのため再起動するごとにToDoが初期化されます。
