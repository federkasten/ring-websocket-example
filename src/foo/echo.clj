(ns foo.echo
  (:require [ring.adapter.jetty9 :refer [send! close! remote-addr idle-timeout!]]))

(defn on-connect [session]
  (println "connected"))

(defn on-text [session message]
  (println message)
  (send! session (str "foo.echo says " message)))

(defn on-bytes [session payload offset len]
  (println payload)
  payload)

(defn on-close [session code reason]
  (println "closed"))

(defn on-error [session e]
  (println "error")
  (.printStackTrace e))
