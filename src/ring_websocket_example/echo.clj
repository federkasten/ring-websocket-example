(ns ring-websocket-example.echo
  (:require [ring-jetty.util.ws :as ws]))

(defn- on-connect [session]
  (println "connected"))

(defn- on-text [session message]
  (println message)
  (ws/send! session (str "foo.echo says : " message)))

(defn- on-bytes [session payload offset len]
  (println payload)
  payload)

(defn- on-close [session code reason]
  (println "closed"))

(defn- on-error [session e]
  (println "error")
  (.printStackTrace e))

(def handler
  {:on-connect on-connect
   :on-error on-error
   :on-text on-text
   :on-close on-close
   :on-bytes on-bytes})
