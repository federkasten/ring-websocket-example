(defproject foo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [javax.servlet/javax.servlet-api "3.1.0"]
                 [ring-jetty/ring-ws "0.1.0-SNAPSHOT"]
                 [ring-jetty/ring-servlet "0.1.0-SNAPSHOT"]]
  :plugins [[lein-ring-jetty "0.1.0-SNAPSHOT"]]
  :ring {:handler foo.handler/app
         :websockets {"/echo" foo.echo/handler
                      "/test" foo.echo/handler}}
  :profiles
  {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]
                        [ring-mock "0.1.5"]]}})
