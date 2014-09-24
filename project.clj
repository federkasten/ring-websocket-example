(defproject ring-websocket-example "0.1.0-SNAPSHOT"
  :description "An example project for websocket server using ring-jetty"
  :url "https://github.com/federkasten/ring-websocket-example"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [ring-jetty/ring-ws "0.1.0-SNAPSHOT"]]
  :plugins [[lein-ring-jetty "0.1.0-SNAPSHOT"]]
  :ring {:handler ring-websocket-example.handler/app
         :websockets {"/echo" ring-websocket-example.echo/handler}}
  :profiles
  {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]
                        [ring-mock "0.1.5"]]}})
