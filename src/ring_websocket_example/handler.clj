(ns ring-websocket-example.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.core :refer :all]
            [hiccup.page :refer :all]))

(defn- page []
  (html5 [:head [:title "Ring WebSocket Example"] (include-js "example.js")]
         [:body
          [:div#form
           [:input#send-text {:type "text"}]
           [:input#send-button {:type "button" :value "Send"}]]
          [:div#message]]))

(defroutes app-routes
  (GET "/" [] (page))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
