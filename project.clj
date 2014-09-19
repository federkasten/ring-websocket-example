(defproject foo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]]
  :plugins [[lein-ring "0.8.12-SNAPSHOT"]]
  :ring {:handler foo.handler/app
         :websockets {"/echo" {:on-connect foo.echo/on-connect
                               :on-error foo.echo/on-error
                               :on-close foo.echo/on-close
                               :on-text foo.echo/on-text
                               :on-bytes foo.echo/on-error}}}
  :profiles
  {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]
                        [ring-mock "0.1.5"]]}})
