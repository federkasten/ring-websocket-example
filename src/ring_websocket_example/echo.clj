(ns ring-websocket-example.echo
  (:require [ring-jetty.util.ws :as ws]))

(def all-sessions (ref #{}))

(defn- on-connect [session]
  (dosync
   (alter all-sessions conj session)))

(defn- on-close [session code reason]
  (dosync
   (alter all-sessions disj session)))

(defn- on-text [session message]
  (doseq [s @all-sessions]
    (ws/send! s (str
                 (.. session getSession getRemoteAddress getHostName)
                 ":"
                 message))))

(defn- on-bytes [session payload offset len]
  nil)

(defn- on-error [session e]
  (.printStackTrace e)
  (dosync
   (alter all-sessions disj session)))

(def handler
  {:on-connect on-connect
   :on-error on-error
   :on-text on-text
   :on-close on-close
   :on-bytes on-bytes})
