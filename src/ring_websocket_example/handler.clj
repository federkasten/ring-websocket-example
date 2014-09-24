(ns ring-websocket-example.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring-websocket-example.echo]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
