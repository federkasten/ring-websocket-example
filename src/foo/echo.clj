(ns foo.echo
  (:require [ring-jetty.util.ws :as ws]))

(defn on-connect [session]
  (println "connected"))

(defn on-text [session message]
  (println message)
  (ws/send! session (str "foo.echo says : " message)))

(defn on-bytes [session payload offset len]
  (println payload)
  payload)

(defn on-close [session code reason]
  (println "closed"))

(defn on-error [session e]
  (println "error")
  (.printStackTrace e))
